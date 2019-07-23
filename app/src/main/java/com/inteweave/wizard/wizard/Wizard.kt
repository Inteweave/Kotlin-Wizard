package com.inteweave.wizard.wizard

import java.util.*

/**
 * The wizard class is the engine that drives the navigation
 * Given the screen navigations and the events it determines the identifier for the
 * next screen
 *
 * @param ScreenIdentifier The type of the screen identifier; normally an enum
 * @param WizardEvent The type of the event raised; normally an enum
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
class Wizard<ScreenIdentifier, WizardEvent>(
    private val screenNavigations: List<ScreenNavigation<ScreenIdentifier, WizardEvent>>,
    private val startScreen: ScreenIdentifier
) {
    var currentScreen = startScreen
    private val screenStack = Stack<ScreenIdentifier>()

    /**
     * An event was raised on the current screen
     *
     * @param event The event that occurred on the current screen
     * @return The {link ScreenIdentifier} for the event
     */
    fun onEvent(event: WizardEvent): ScreenIdentifier {
        val navigations = screenNavigations.filter { it.event == event && it.from == currentScreen }
        when (navigations.size) {
            1 -> {
                screenStack.push(currentScreen)
                // we have navigated to the to screen so update the current screen
                currentScreen = navigations[0].to
                return currentScreen
            }
            0 ->
                throw WizardError("No event found for screen $currentScreen")
            else ->
                throw WizardError("Multiple definitions for screen $currentScreen")
        }
    }

    /**
     * Used when the wizard has gone back a screen
     * The guard is useful when the user backs out of the wizard.
     */
    fun back() {
        if (screenStack.size > 0) {
            currentScreen = screenStack.pop()
        }
    }

    /**
     * Reset the wizard (for example, when finishing and going back to the start)
     */
    fun reset() {
        screenStack.removeAllElements()
        currentScreen = startScreen
    }
}
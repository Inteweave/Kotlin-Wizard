package com.inteweave.wizard.wizard

/**
 * This is the actual navigation
 * There is one of these created for each possible event for each screen
 * This can follow the UX flow; requirement is that each screen has a name
 *
 * @param ScreenIdentifier The type of the screen identifier; normally an enum
 * @param WizardEvent The type of the event raised; normally an enum
 *
 * @param from The screen that the user is currently looking at
 * @param event The event that occurred
 * @param to The screen the user is going to
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
class ScreenNavigation<ScreenIdentifier, WizardEvent>(
    val from: ScreenIdentifier,
    val event: WizardEvent,
    val to: ScreenIdentifier
)
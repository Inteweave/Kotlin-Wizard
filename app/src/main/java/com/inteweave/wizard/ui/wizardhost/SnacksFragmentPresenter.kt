package com.inteweave.wizard.ui.wizardhost

import android.content.Context
import com.inteweave.wizard.R
import com.inteweave.wizard.snacks.wizard.ScreenContents
import com.inteweave.wizard.snacks.wizard.SnacksEvent
import com.inteweave.wizard.snacks.wizard.SnacksScreen

/**
 * The presenter for the snacks fragment defines the actual contents of each screen and the events it can raise.
 *
 * It translates user action into the actual event.
 *
 * @author W M Milward
 * Copyright © 2019 Inteweave. All rights reserved.
 */
class SnacksFragmentPresenter(screen: SnacksScreen, context: Context, private val listener: EventListener) {

    interface EventListener {
        fun onSnacksEvent(event: SnacksEvent)
    }

    val screenContents: ScreenContents

    init {
        when (screen) {
            SnacksScreen.SELECT_TYPE ->
                screenContents = ScreenContents(
                    context,
                    R.string.select_type_label,
                    R.string.select_type_button1,
                    R.string.select_type_button2,
                    SnacksEvent.ICE_CREAM_CHOSEN,
                    SnacksEvent.NUTS_CHOSEN,
                    false
                )
            SnacksScreen.ICE_CREAM_SERVE ->
                screenContents = ScreenContents(
                    context,
                    R.string.ice_cream_label,
                    R.string.ice_cream_button1,
                    R.string.ice_cream_button2,
                    SnacksEvent.CONE_CHOSEN,
                    SnacksEvent.SOFT_SERVE_CHOSEN,
                    false
                )
            SnacksScreen.CONE ->
                screenContents = ScreenContents(
                    context,
                    R.string.cone_label,
                    R.string.cone_button1,
                    R.string.cone_button2,
                    SnacksEvent.FINISH,
                    SnacksEvent.FINISH,
                    true
                )
            SnacksScreen.CHOOSE_TOPPING ->
                screenContents = ScreenContents(
                    context,
                    R.string.topping_label,
                    R.string.topping_button1,
                    R.string.topping_button2,
                    SnacksEvent.CHOC_DIP_CHOSEN,
                    SnacksEvent.SPRINKLES_CHOSEN,
                    false
                )
            SnacksScreen.SOFT_SERVE_CHOC_DIP ->
                screenContents = ScreenContents(
                    context,
                    R.string.choc_dip_label,
                    R.string.choc_dip_button1,
                    R.string.choc_dip_button2,
                    SnacksEvent.FINISH,
                    SnacksEvent.FINISH,
                    true
                )
            SnacksScreen.SOFT_SERVE_SPRINKLES ->
                screenContents = ScreenContents(
                    context,
                    R.string.sprinkles_label,
                    R.string.sprinkles_button1,
                    R.string.sprinkles_button2,
                    SnacksEvent.FINISH,
                    SnacksEvent.FINISH,
                    true
                )
            SnacksScreen.NUTS ->
                screenContents = ScreenContents(
                    context,
                    R.string.nuts_label,
                    R.string.nuts_button1,
                    R.string.nuts_button2,
                    SnacksEvent.FINISH,
                    SnacksEvent.FINISH,
                    true
                )
        }
    }

    fun onButton1Pressed() {
        listener.onSnacksEvent(screenContents.button1Event)
    }

    fun onButton2Pressed() {
        listener.onSnacksEvent(screenContents.button2Event)
    }
}
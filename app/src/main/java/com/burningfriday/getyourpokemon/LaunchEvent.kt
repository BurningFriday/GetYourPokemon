package com.burningfriday.getyourpokemon

import com.burningfriday.getyourpokemon.common.Event

/**
 * @author Hyunwoo Choi
 */
sealed class LaunchEvent : Event {
    object OnClickSampleAAC : LaunchEvent()
    object OnClickSampleCompose : LaunchEvent()
}
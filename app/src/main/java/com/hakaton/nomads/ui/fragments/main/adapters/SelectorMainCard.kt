package com.hakaton.nomads.ui.fragments.main.adapters

import com.hakaton.nomads.domain.models.events.Events
import com.hakaton.nomads.domain.models.habitations.Habitations

interface SelectorMainCard {

}

class HabitationMainDataClass(val habitations: List<Habitations>) : SelectorMainCard {

}

class EventMainDataClass(val event: Events) : SelectorMainCard {

}

class TwoTextDataClass(val mainText: String, val secondaryText: String) : SelectorMainCard {

}
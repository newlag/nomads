package com.hakaton.nomads.ui.fragments.main.adapters

import com.hakaton.nomads.domain.models.events.Events
import com.hakaton.nomads.domain.models.habitations.Habitations

interface SelectorMainCard {

}

class HabitationMainDataClass(val habitations: List<Habitations>) : SelectorMainCard {

}

class HabitationDataClass(val habitations: Habitations) : SelectorMainCard {

}

class HabitationFavDataClass(val habitation: Habitations) : SelectorMainCard {

}

class HabitationFavHeaderDataClass(val habitation: Habitations) : SelectorMainCard {
}

class EventMainDataClass(val event: Events) : SelectorMainCard {

}

class TwoTextDataClass(val mainText: String, val secondaryText: String) : SelectorMainCard {

}
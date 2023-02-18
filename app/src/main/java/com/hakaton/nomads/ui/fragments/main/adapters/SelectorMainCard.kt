package com.hakaton.nomads.ui.fragments.main.adapters

interface SelectorMainCard {

}

class HabitationMainDataClass() : SelectorMainCard {

}

class EventMainDataClass() : SelectorMainCard {

}

class TwoTextDataClass(val mainText: String, val secondaryText: String) : SelectorMainCard {

}
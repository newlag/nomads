package com.hakaton.nomads.ui.fragments.events.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard

abstract class BaseElementViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(selectorMainCard: SelectorMainCard, click: MainRecyclerClickListener)
}
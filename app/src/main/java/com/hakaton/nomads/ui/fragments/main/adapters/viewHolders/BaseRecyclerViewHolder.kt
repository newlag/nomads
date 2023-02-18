package com.hakaton.nomads.ui.fragments.main.adapters.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard

abstract class BaseRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(selectorMainCard: SelectorMainCard)
}
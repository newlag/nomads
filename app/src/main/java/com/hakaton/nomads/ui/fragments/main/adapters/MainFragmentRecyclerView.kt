package com.hakaton.nomads.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.adapters.viewHolders.BaseRecyclerViewHolder
import com.hakaton.nomads.ui.fragments.main.adapters.viewHolders.EventRecyclerViewHolder
import com.hakaton.nomads.ui.fragments.main.adapters.viewHolders.HabitationsRecyclerViewHolder
import com.hakaton.nomads.ui.fragments.main.adapters.viewHolders.ViewHolderTwoText

class MainFragmentRecyclerView(val list: List<SelectorMainCard>) :
    RecyclerView.Adapter<BaseRecyclerViewHolder>() {
    override fun getItemViewType(position: Int): Int {

        return when (list[position]) {
            is HabitationMainDataClass -> {
                0
            }
            is TwoTextDataClass -> {
                1
            }
            else -> {
                2
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_habitation, parent, false)
                HabitationsRecyclerViewHolder(view)
            }
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_volder_main_two_text, parent, false)
                ViewHolderTwoText(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_volder_events_in_fragment, parent, false)
                EventRecyclerViewHolder(view)
            }
        }
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}
package com.hakaton.nomads.ui.fragments.events.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard

class ElementAdapter(
    val list: List<SelectorMainCard>,
    private val click: MainRecyclerClickListener
) :
    RecyclerView.Adapter<BaseElementViewHolder>() {
    override fun getItemViewType(position: Int): Int {

        return when (list[position]) {
            is HabitationDataClass -> {
                0
            }
            else -> {
                1
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseElementViewHolder {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_habitation, parent, false)
                HabitationsHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_events, parent, false)
                EventViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseElementViewHolder, position: Int) {
        holder.onBind(list[position], click)
    }

    override fun getItemCount() = list.size


}
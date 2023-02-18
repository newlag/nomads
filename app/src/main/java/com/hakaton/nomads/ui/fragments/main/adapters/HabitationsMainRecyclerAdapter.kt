package com.hakaton.nomads.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.adapters.viewHolders.EventRecyclerViewHolder
import com.hakaton.nomads.utils.SizesUtil

class HabitationsMainRecyclerAdapter(val list: List<EventMainDataClass>) :
    RecyclerView.Adapter<EventRecyclerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_events, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(
            SizesUtil().calculateDpToPx(parent.context, 250),
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        return EventRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventRecyclerViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}
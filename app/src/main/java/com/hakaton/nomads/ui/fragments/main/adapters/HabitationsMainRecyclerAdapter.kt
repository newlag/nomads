package com.hakaton.nomads.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.adapters.viewHolders.HabitationsRecyclerViewHolder
import com.hakaton.nomads.utils.SizesUtil

class HabitationsMainRecyclerAdapter(val list: HabitationMainDataClass) :
    RecyclerView.Adapter<HabitationsRecyclerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HabitationsRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_habitation, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(
            SizesUtil().calculateDpToPx(parent.context, 250),
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        return HabitationsRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitationsRecyclerViewHolder, position: Int) {
        holder.onBind(list.habitations[position])
    }

    override fun getItemCount() = list.habitations.size

}
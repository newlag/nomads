package com.hakaton.nomads.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
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
        val param = LinearLayout.LayoutParams(
            SizesUtil().calculateDpToPx(parent.context, 250),
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )
        param.setMargins(8, 8, 8, 8)
        view.layoutParams = param
        return HabitationsRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitationsRecyclerViewHolder, position: Int) {
        if (position == 0) {
            val param = LinearLayout.LayoutParams(
                SizesUtil().calculateDpToPx(holder.itemView.context, 250),
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            param.setMargins(35, 8, 8, 8)
            holder.itemView.layoutParams = param
        }
        holder.onBind(list.habitations[position])
    }

    override fun getItemCount() = list.habitations.size

}
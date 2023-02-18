package com.hakaton.nomads.ui.fragments.main.adapters.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.R
import com.hakaton.nomads.domain.models.habitations.Habitations
import com.hakaton.nomads.utils.GlideWrapper

class HabitationsRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(data: Habitations) {
        itemView.findViewById<TextView>(R.id.text_view_header).text =
            data.details?.mainInfo?.name ?: "Name"
        itemView.findViewById<TextView>(R.id.text_view_region).text =
            data.details?.mainInfo?.city ?: "City"
        data.details?.mainInfo?.photos?.get(0)?.let {
            GlideWrapper(itemView.context).loadImageNoCash(
                itemView.findViewById(R.id.imageView),
                it
            )
        }
    }
}
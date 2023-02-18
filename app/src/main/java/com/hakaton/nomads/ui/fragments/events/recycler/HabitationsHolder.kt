package com.hakaton.nomads.ui.fragments.events.recycler

import android.view.View
import android.widget.TextView
import com.hakaton.nomads.R
import com.hakaton.nomads.domain.models.habitations.Habitations
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard
import com.hakaton.nomads.utils.GlideWrapper

class HabitationsHolder(itemView: View) : BaseElementViewHolder(itemView) {


    override fun onBind(selectorMainCard: SelectorMainCard, click: MainRecyclerClickListener) {
        selectorMainCard as HabitationDataClass
        val data = selectorMainCard.habitations
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
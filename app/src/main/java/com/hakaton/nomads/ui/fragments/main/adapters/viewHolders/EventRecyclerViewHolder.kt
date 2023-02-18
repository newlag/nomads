package com.hakaton.nomads.ui.fragments.main.adapters.viewHolders

import android.view.View
import android.widget.TextView
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.adapters.EventMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard
import com.hakaton.nomads.utils.GlideWrapper

class EventRecyclerViewHolder(itemView: View) : BaseRecyclerViewHolder(itemView) {

    override fun onBind(selectorMainCard: SelectorMainCard) {
        selectorMainCard as EventMainDataClass
        val data = selectorMainCard.event
        itemView.findViewById<TextView>(R.id.text_view_header).text =
            data.details.name
        data.details.photos[0].let {
            GlideWrapper(itemView.context).loadImageNoCash(
                itemView.findViewById(R.id.imageView),
                it
            )
        }
    }
}
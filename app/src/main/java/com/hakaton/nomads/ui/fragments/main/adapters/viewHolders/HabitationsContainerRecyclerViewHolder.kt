package com.hakaton.nomads.ui.fragments.main.adapters.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationsMainRecyclerAdapter
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard

class HabitationsContainerRecyclerViewHolder(itemView: View) : BaseRecyclerViewHolder(itemView) {
    lateinit var recycler: RecyclerView

    override fun onBind(selectorMainCard: SelectorMainCard, click: MainRecyclerClickListener) {
        selectorMainCard as HabitationMainDataClass
        recycler = itemView.findViewById(R.id.recycler_view)
        recycler.adapter = HabitationsMainRecyclerAdapter(
            selectorMainCard
        )
        itemView.findViewById<View>(R.id.text_view_show_all).setOnClickListener{
            click.onClickHabitation()
        }

    }
}
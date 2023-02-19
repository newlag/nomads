package com.hakaton.nomads.ui.fragments.main.adapters.viewHolders

import android.view.View
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard

class ViewHolderTwoText(itemView: View) : BaseRecyclerViewHolder(itemView) {
    override fun onBind(selectorMainCard: SelectorMainCard, click: MainRecyclerClickListener) {
        itemView.findViewById<View>(R.id.text_view_show_all).setOnClickListener{
            click.onClickEvent("")
        }
    }
}
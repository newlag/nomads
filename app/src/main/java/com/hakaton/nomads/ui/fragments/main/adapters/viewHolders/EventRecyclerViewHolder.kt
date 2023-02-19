package com.hakaton.nomads.ui.fragments.main.adapters.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.EventMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard
import com.hakaton.nomads.utils.GlideWrapper

class EventRecyclerViewHolder(itemView: View) : BaseRecyclerViewHolder(itemView) {

    private var isFav = false
    private var favImageView: ImageView? = null

    override fun onBind(selectorMainCard: SelectorMainCard, click: MainRecyclerClickListener) {
        isFav = ((0..10).random() < 4)
        selectorMainCard as EventMainDataClass
        val data = selectorMainCard.event
        itemView.findViewById<TextView>(R.id.text_view_header).text =
            data.details.name
        favImageView = itemView.findViewById<ImageView>(R.id.like_image_view)
        data.details.photos[0].let {
            GlideWrapper(itemView.context).loadImageNoCash(
                itemView.findViewById(R.id.imageView),
                it
            )
        }
        if (favImageView != null) {
            favImageView!!.setOnClickListener {
                isFav = !isFav
                updateFavImage()
            }
            updateFavImage()
        }
    }

    private fun updateFavImage() {
        if (favImageView != null) {
            favImageView!!.setImageDrawable(favImageView!!.context.resources.getDrawable(if (isFav) R.drawable.ic_liked else R.drawable.ic_unliked))
        }
    }
}
package com.hakaton.nomads.ui.fragments.main.adapters.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hakaton.nomads.R
import com.hakaton.nomads.ui.fragments.main.MainRecyclerClickListener
import com.hakaton.nomads.ui.fragments.main.adapters.EventMainDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationFavDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.HabitationFavHeaderDataClass
import com.hakaton.nomads.ui.fragments.main.adapters.SelectorMainCard
import com.hakaton.nomads.utils.GlideWrapper

class HabitationsFavRecyclerViewHolder(itemView: View) : BaseRecyclerViewHolder(itemView) {

    private var isFav = false
    private var favImageView: ImageView? = null
    private var title: TextView? = null

    override fun onBind(selectorMainCard: SelectorMainCard, click: MainRecyclerClickListener) {
        isFav = ((0..10).random() < 4)
        if (selectorMainCard is HabitationFavDataClass) {
            val data = selectorMainCard.habitation
            favImageView = itemView.findViewById<ImageView>(R.id.like_image_view)
            itemView.findViewById<TextView>(R.id.text_view_header).text =
                data.details?.mainInfo?.name ?: "City"
            data.details?.mainInfo?.photos?.get(0)?.let {
                GlideWrapper(itemView.context).loadImageNoCash(
                    itemView.findViewById(R.id.imageView),
                    it
                )
            }
            itemView.findViewById<TextView>(R.id.text_view_region).text =
                data.details?.mainInfo?.city ?: "City"
        } else if (selectorMainCard is HabitationFavHeaderDataClass) {
            val data = selectorMainCard.habitation
            favImageView = itemView.findViewById<ImageView>(R.id.like_image_view)
            itemView.findViewById<TextView>(R.id.text_view_header).text =
                data.details?.mainInfo?.name ?: "City"
            data.details?.mainInfo?.photos?.get(0)?.let {
                GlideWrapper(itemView.context).loadImageNoCash(
                    itemView.findViewById(R.id.imageView),
                    it
                )
            }
            itemView.findViewById<TextView>(R.id.text_view_region).text =
                data.details?.mainInfo?.city ?: "City"
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
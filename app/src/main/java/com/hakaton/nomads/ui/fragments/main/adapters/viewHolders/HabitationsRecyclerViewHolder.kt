package com.hakaton.nomads.ui.fragments.main.adapters.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hakaton.nomads.R
import com.hakaton.nomads.domain.models.habitations.Habitations
import com.hakaton.nomads.utils.GlideWrapper

class HabitationsRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var isFav = false
    private var favImageView: ImageView? = null

    fun onBind(data: Habitations) {
        isFav = ((0..10).random() < 4)
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
        favImageView = itemView.findViewById<ImageView>(R.id.like_image_view)
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
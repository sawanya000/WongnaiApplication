package com.egco428.wongnaiapplication

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


class RecyclerDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var text_name_left: TextView
    var text_name_right: TextView
    var text_desc: TextView
    var image_url_left: ImageView
    var image_url_right: ImageView


    init {
        text_name_left = itemView.findViewById(R.id.text_name_left)
        text_name_right = itemView.findViewById(R.id.text_name_right)
        text_desc = itemView.findViewById(R.id.text_desc)
        image_url_left = itemView.findViewById(R.id.image_url_left)
        image_url_right = itemView.findViewById(R.id.image_url_right)
    }
}

class RecyclerDetailAdapter(
    private val resultData: ArrayList<Coins>,
    private val mContext: Context
) :
    RecyclerView.Adapter<RecyclerDetailViewHolder>() {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerDetailViewHolder {

        val itemView = inflater.inflate(R.layout.coins_layout, parent, false)
        return RecyclerDetailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerDetailViewHolder, position: Int) {

        holder.setIsRecyclable(false)
        if ((position + 1) % 5 == 0) {
            setImage(Uri.parse(resultData[position].iconUrl),holder.image_url_right)
            holder.image_url_left.visibility = View.INVISIBLE
            holder.text_name_left.visibility = View.INVISIBLE
            holder.text_desc.visibility = View.INVISIBLE
            holder.text_name_right.text = resultData[position].name
            holder.image_url_right.visibility = View.VISIBLE
            holder.text_name_right.visibility = View.VISIBLE

        } else {

            setImage(Uri.parse(resultData[position].iconUrl),holder.image_url_left)
            holder.text_name_left.text = resultData[position].name
            holder.text_desc.text = resultData[position].description
        }

    }

    override fun getItemCount(): Int {
        return resultData.size

    }

    private fun setImage(uri: Uri, imageView: ImageView){
        GlideToVectorYou
            .init()
            .with(mContext)
            .load(uri, imageView)
    }

}
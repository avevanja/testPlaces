package com.example.ivan.foursquareapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ivan.foursquareapp.R
import com.example.ivan.foursquareapp.models.ItemTips
import kotlinx.android.synthetic.main.item_tip.view.*


class RecyclerAdapterTips(private val mTipsList: List<ItemTips>) : RecyclerView.Adapter<RecyclerAdapterTips.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mTipsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.initTip(mTipsList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun initTip(tip: ItemTips) {
            itemView.textViewTip.text = tip.text
        }

    }
}

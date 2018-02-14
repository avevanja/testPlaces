package com.example.ivan.foursquareapp.ui


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ivan.foursquareapp.GlideApp
import com.example.ivan.foursquareapp.R
import com.example.ivan.foursquareapp.models.DetailnfoVenue
import com.example.ivan.foursquareapp.models.ItemVenue

import java.util.ArrayList
import kotlinx.android.synthetic.main.item_place.view.*

class RecyclerAdapterPlaces(private val mListener: ItemClick) : RecyclerView.Adapter<RecyclerAdapterPlaces.ViewHolder>() {

    private val mListVenues = ArrayList<ItemVenue>()

    fun addVenues(list: List<ItemVenue>) {
        mListVenues.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setPlace(mListVenues[position])
    }

    override fun getItemCount(): Int {
        return mListVenues.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { mListener.itemClick(initDetails(mListVenues[adapterPosition])) }
            itemView.textViewPhone.setOnClickListener { mListener.phoneClick(itemView.textViewPhone.text.toString()) }
        }

        fun setPlace(itemVenue: ItemVenue) {
            with(itemVenue.venue!!.photos!!.groups[0].items[0]) {
                GlideApp
                        .with(itemView.imageViewLogo.context)
                        .load(prefix + "600x400" + suffix)
                        .centerCrop()
                        .into(itemView.imageViewLogo)
            }
            itemView.textViewName.text = itemVenue.venue!!.name
            itemView.textViewPhone.text = itemVenue.venue!!.contact!!.phone
            if (itemVenue.venue!!.hours != null)
                itemView.textViewOpen.text = if (itemVenue.venue!!.hours!!.isOpen) "open" else "close"
        }

        private fun initDetails(itemVenue: ItemVenue): DetailnfoVenue {
            with(itemVenue.venue!!.photos!!.groups[0].items[0]) {
                return DetailnfoVenue(itemVenue.venue!!.stats!!.usersCount!!, itemVenue.venue!!.rating!!,
                        prefix + "600x400" + suffix, itemVenue.tips!!)
            }
        }
    }

    interface ItemClick {
        fun itemClick(venue: DetailnfoVenue)
        fun phoneClick(phone: String)
    }
}

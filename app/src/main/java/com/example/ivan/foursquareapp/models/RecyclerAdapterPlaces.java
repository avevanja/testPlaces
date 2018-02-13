package com.example.ivan.foursquareapp.models;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivan.foursquareapp.GlideApp;
import com.example.ivan.foursquareapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterPlaces extends RecyclerView.Adapter<RecyclerAdapterPlaces.ViewHolder> {

    private List<ItemVenue> mListVenues = new ArrayList<>();
    private ItemClick mListener;

    public RecyclerAdapterPlaces(ItemClick mListener) {
        this.mListener = mListener;
    }

    public void addVenues(List<ItemVenue> list) {
        mListVenues.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setPlace(mListVenues.get(position));
    }

    @Override
    public int getItemCount() {
        return mListVenues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewLogo;
        private TextView textViewName, textViewIsOpen, textViewPhone;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewLogo = itemView.findViewById(R.id.iv_logo);
            textViewName = itemView.findViewById(R.id.tv_name);
            textViewIsOpen = itemView.findViewById(R.id.tv_is_open);
            textViewPhone = itemView.findViewById(R.id.tv_telephone);
            textViewPhone.setOnClickListener(v -> mListener.phoneClick(textViewPhone.getText().toString()));
        }

        public void setPlace(ItemVenue itemVenue) {
            GlideApp
                    .with(imageViewLogo.getContext())
                    .load(itemVenue.getVenue().getPhotos().getGroups().get(0).getItems().get(0).getPrefix() + "600x400" + itemVenue.getVenue().getPhotos().getGroups().get(0).getItems().get(0).getSuffix())
                    .centerCrop()
                    .into(imageViewLogo);
            textViewName.setText(itemVenue.getVenue().getName());
            textViewPhone.setText(itemVenue.getVenue().getContact().getPhone());
            if (itemVenue.getVenue().getHours() != null)
                textViewIsOpen.setText(itemVenue.getVenue().getHours().getIsOpen() ? "open" : "close");
        }
    }

    public interface ItemClick{
        void itemClick();
        void phoneClick(String phone);
    }
}

package com.tanzible.sampleproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {

    List<OfferViewModel> offerViewModelList;

    public OfferAdapter(List<OfferViewModel> offerViewModelList) {
        this.offerViewModelList = offerViewModelList;
    }

    @NonNull
    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.slider_recyclerview_items,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.ViewHolder viewHolder, int position) {

        int offerImage = offerViewModelList.get(position).getOfferImage();


        viewHolder.setData(offerImage);

    }

    @Override
    public int getItemCount() {
        return offerViewModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView offerImageView;
        private TextView offerTitletxt, offerTypetxt, offerTimetxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            offerImageView = itemView.findViewById(R.id.offer_image);

        }

        public void setData(int Image) {
            offerImageView.setImageResource(Image);
           ;

        }

    }
}

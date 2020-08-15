package com.tanzible.sampleproject;


import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private LinearLayout home_layout;
    private LinearLayout registration_layout;
    private LinearLayout gallery_layout;
    private LinearLayout profile_layout;
    private RecyclerView recyclerView;

    View view;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            init(getActivity().getAssets());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(AssetManager assetManager) throws Exception {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());

    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_blank, container, false);
        this.home_layout = (LinearLayout) this.view.findViewById(R.id.home_layout);
        this.registration_layout = (LinearLayout) this.view.findViewById(R.id.registraion_layout);
        this.gallery_layout = (LinearLayout) this.view.findViewById(R.id.gallery_layout);
        this.profile_layout = (LinearLayout) this.view.findViewById(R.id.profile_layout);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recylerView);

        home_layout.setOnClickListener(this);
        registration_layout.setOnClickListener(this);
        gallery_layout.setOnClickListener(this);
        profile_layout.setOnClickListener(this);

        List<OfferViewModel> flightModelList = new ArrayList<>();

        flightModelList.add(new OfferViewModel(R.drawable.sliderimg1));
        flightModelList.add(new OfferViewModel(R.drawable.sliderimg2));
        flightModelList.add(new OfferViewModel(R.drawable.sliderimg3));
        flightModelList.add(new OfferViewModel(R.drawable.sliderimg4));
        flightModelList.add(new OfferViewModel(R.drawable.sliderimh5));
        flightModelList.add(new OfferViewModel(R.drawable.sliderimg6));
        flightModelList.add(new OfferViewModel(R.drawable.sliderimg7));
        flightModelList.add(new OfferViewModel(R.drawable.sliderimg8));
        flightModelList.add(new OfferViewModel(R.drawable.sliderimg9));

        OfferAdapter adapter = new OfferAdapter(flightModelList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager
                .HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onClick(View view2) {

        switch (view2.getId()) {
            case R.id.home_layout /*2131297833*/:

                startActivity(new Intent(getContext(), MainActivity.class));
                break;


            case R.id.registraion_layout /*2131297873*/:

                startActivity(new Intent(this.getContext(), Registration.class));

                break;

            case R.id.gallery_layout /*2131297908*/:

                startActivity(new Intent(getContext(), Gallery.class));
                break;

            case R.id.profile_layout /*2131297910*/:

                startActivity(new Intent(getContext(), Profile.class));
                break;


        }
    }

}

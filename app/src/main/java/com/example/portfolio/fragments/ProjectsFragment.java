package com.example.portfolio.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.portfolio.Adapter;
import com.example.portfolio.Item;
import com.example.portfolio.MainActivity;
import com.example.portfolio.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsFragment extends Fragment {

    ImageView  langBtn;
    CircleImageView profileImage;

    private ArrayList<Item> items = new ArrayList<>();

    public ProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects, container, false);

        profileImage = view.findViewById(R.id.profile_image);


//        backBtn = view.findViewById(R.id.back_icon);
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), MainActivity.class);
//
//                Pair[] pairs = new Pair[1];
//                pairs[0] = new Pair<View, String>(profileImage,"imageTransition");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pairs);
//
//                startActivity(intent,options.toBundle());
//
//            }
//        });
        langBtn = view.findViewById(R.id.language_icon);
        langBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(profileImage,"imageTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pairs);

                startActivity(intent,options.toBundle());
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new Adapter(items,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        items.add(new Item(R.drawable.maize,getString(R.string.project1_title),getString(R.string.project1)));
        items.add(new Item(R.drawable.coconut,getString(R.string.project2_title),getString(R.string.project2)));
        items.add(new Item(R.drawable.tomato,getString(R.string.project3_title),getString(R.string.project3)));
        items.add(new Item(R.drawable.quize,getString(R.string.project4_title),getString(R.string.project4)));
        items.add(new Item(R.drawable.covid,getString(R.string.project5_title),getString(R.string.project5)));


        return view;
    }

}

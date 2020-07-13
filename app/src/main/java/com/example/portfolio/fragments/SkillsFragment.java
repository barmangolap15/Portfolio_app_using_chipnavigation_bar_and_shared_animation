package com.example.portfolio.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.portfolio.MainActivity;
import com.example.portfolio.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsFragment extends Fragment {

    ImageView langBtn;
    CircleImageView profileImage;

    public SkillsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skills, container, false);

        profileImage = view.findViewById(R.id.profile_image);

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

        return view;
    }
}

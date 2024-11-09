package com.example.night.fragmentManage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.night.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PictureFragment_home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PictureFragment_home extends Fragment {
    int draw1;
    ImageView imageView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public PictureFragment_home() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PictureFragment_home.
     */
    public static PictureFragment_home newInstance(String param1, String param2) {
        PictureFragment_home fragment = new PictureFragment_home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture_home, container, false);
        Bundle args = getArguments();
        if (args != null) {
            String imageUrl = args.getString("image_url");
            ImageView imageView = view.findViewById(R.id.imageView);
            imageView.setImageResource(Integer.parseInt(imageUrl));
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
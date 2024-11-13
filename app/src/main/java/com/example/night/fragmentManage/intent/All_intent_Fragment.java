package com.example.night.fragmentManage.intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.night.Adapter.IntentFragmentRecyclerViewAdapter2;
import com.example.night.Bean.PersonalHistory;
import com.example.night.R;
import com.example.night.presenter.PersonalHistoryPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link All_intent_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class All_intent_Fragment extends Fragment {
    RecyclerView recyclerView;
    PersonalHistoryPresenter personalHistoryPresenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public All_intent_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment All_intent_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static All_intent_Fragment newInstance(String param1, String param2) {
        All_intent_Fragment fragment = new All_intent_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_all_intent_, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        personalHistoryPresenter = new PersonalHistoryPresenter(this);
        PersonalHistory personalHistory = personalHistoryPresenter.getPersonalHistory();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        IntentFragmentRecyclerViewAdapter2 intentFragmentRecyclerViewAdapter2 = new IntentFragmentRecyclerViewAdapter2(personalHistory);
        recyclerView.setAdapter(intentFragmentRecyclerViewAdapter2);
        return view;
    }
}
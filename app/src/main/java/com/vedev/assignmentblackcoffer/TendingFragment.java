package com.vedev.assignmentblackcoffer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TendingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TendingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Tags> tagsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TagAdapter tagAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TendingFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TendingFragment newInstance(String param1, String param2) {
        TendingFragment fragment = new TendingFragment();
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

    private void prepareTagData() {
        Tags tags = new Tags("techmonday", "11");
        tagsList.add(tags);
        tags = new Tags("covid19", "100");
        tagsList.add(tags);
        tags = new Tags("fifa_cup", "8");
        tagsList.add(tags);
        tags = new Tags("lockdown", "120");
        tagsList.add(tags);
        tags = new Tags("foodie", "67");
        tagsList.add(tags);
        tags = new Tags("guruji", "2");
        tagsList.add(tags);
        tags = new Tags("startups", "100");
        tagsList.add(tags);
        tags = new Tags("bored", "1020");
        tagsList.add(tags);
        tags = new Tags("Money_Heist", "241");
        tagsList.add(tags);
        tags = new Tags("Netflix_and_Chill", "2251");
        tagsList.add(tags);
        tags = new Tags("#Prime", "27");
        tagsList.add(tags);

        tagAdapter.notifyDataSetChanged();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tending, container, false);
        // 1. get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.tagsRecyclerView);

        // 2. set layoutManger
        tagAdapter = new TagAdapter(tagsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        prepareTagData();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tagAdapter);
        return rootView;

    }
}

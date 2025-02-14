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
 * Use the {@link SavedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SavedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<SavedBrodcasts> savedBrodcastsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SavedBrodcastAdapter savedBrodcastAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SavedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SavedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SavedFragment newInstance(String param1, String param2) {
        SavedFragment fragment = new SavedFragment();
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_saved, container, false);
        // 1. get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.savedRecyclerView);

        // 2. set layoutManger
        savedBrodcastAdapter = new SavedBrodcastAdapter(savedBrodcastsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        prepareTagData();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(savedBrodcastAdapter);
        return rootView;
    }

    private void prepareTagData() {
        SavedBrodcasts savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcasts = new SavedBrodcasts(null, "Username", "India", "odaigjeigjseopgjpojespojgp adgpg opj opvs jops jvpos jgposgcpo phposf jsfpo jfop fspob msfo bjpfos fpo mpod bmpsfombpob mopfmfpodb fdpob m"
                , "#Covid_19", "Developer");
        savedBrodcastsList.add(savedBrodcasts);
        savedBrodcastAdapter.notifyDataSetChanged();


    }
}

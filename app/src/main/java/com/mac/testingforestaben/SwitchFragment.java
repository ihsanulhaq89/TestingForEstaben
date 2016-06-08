package com.mac.testingforestaben;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SwitchFragment extends Fragment {
    int fragVal;

    static SwitchFragment init(int val) {
        SwitchFragment truitonFrag = new SwitchFragment();
        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        truitonFrag.setArguments(args);
        return truitonFrag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragVal = getArguments() != null ? getArguments().getInt("val") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.list, container,
                false);
        ListView lv = (ListView) layoutView.findViewById(R.id.list);
        List<String> dummyData = new ArrayList<>();

        for(int i=0; i<10; i++){
            dummyData.add("");
        }
        lv.setAdapter(new ListAdapter(dummyData, getActivity()));
        return layoutView;
    }
}
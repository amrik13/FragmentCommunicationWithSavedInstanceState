package com.amriksinghpadam.fragmentcommunicate;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class HeadingListFragment extends Fragment {

    private ListView list;
    private HashMap<String,String> detail;
    private Connector con;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment1, container, false);
        list = v.findViewById(R.id.listViewId);
        return v;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final String[] heading = getActivity().getResources().getStringArray(R.array.list_data);
        final String[] desc = getActivity().getResources().getStringArray(R.array.description);
        con= (Connector) getContext();
        detail = new HashMap<>();
        for(int i=0;i<heading.length;i++){
            detail.put(heading[i],desc[i]);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,heading);
        list.setAdapter(arrayAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            //  Toast.makeText(getContext(),"Hello "+position,Toast.LENGTH_SHORT).show();
                con.connect(heading[position],detail);
            }
        };
        list.setOnItemClickListener(itemListener);

    }


}

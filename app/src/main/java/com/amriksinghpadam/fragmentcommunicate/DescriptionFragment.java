package com.amriksinghpadam.fragmentcommunicate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class DescriptionFragment extends Fragment {
    private TextView tvHead, tvPara;
    private Map<String, String> map;
    private String description,index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        tvHead = v.findViewById(R.id.frag2TXTHeadId);
        tvPara = v.findViewById(R.id.frag2TXTParaId);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        tvHead.setText(index);
        tvPara.setText(description);
    }

    public void changeText(String index, String value) {

        this.description = value;
        this.index = index;
    }

    public void updateTextOnRotation(String index, String value){
        this.description = value;
        this.index = index;
    }


}

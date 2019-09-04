package com.amriksinghpadam.fragmentcommunicate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements Connector {

    private TextView textView;
    private FragmentManager fm = getSupportFragmentManager();
    private int orientation;
    private String index,value;
    private Fragment frag1;
    private DescriptionFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Switch Fragment");
        frag = new DescriptionFragment();
        textView = findViewById(R.id.topTxt);
        textView.startAnimation((Animation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate));

        if (savedInstanceState!=null){
            String heading = savedInstanceState.getString("heading");
            String paragraph = savedInstanceState.getString("paragraph");
            frag.updateTextOnRotation(heading,paragraph);
        }
        FragmentTransaction ft = fm.beginTransaction();
        orientation = getResources().getConfiguration().orientation;
        if (orientation == 2) {

            ft.replace(R.id.layoutID2, frag);
        }
        frag1 = new HeadingListFragment();
        ft.replace(R.id.layoutID1, frag1);
        ft.commit();

    }

    @Override
    public void connect(String index, Map<String, String> hMap) {
        this.index = index;
        this.value = hMap.get(index);

        frag = new DescriptionFragment();
        frag.changeText(index, value);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(orientation==1){
            ft.replace(R.id.layoutID1, frag);
        }
        if(orientation==2){
            ft.replace(R.id.layoutID2, frag);
        }
        ft.addToBackStack(null);
        ft.commit();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("heading",index);
        outState.putString("paragraph",value);
    }

}

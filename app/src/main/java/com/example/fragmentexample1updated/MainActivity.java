package com.example.fragmentexample1updated;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button nButton;
    private boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nButton = findViewById(R.id.open_button);
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentDisplayed){
                    displayFragment();
                }
                else{
                    closeFragment();
                }
            }
        });
    }



    private void displayFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SimpleFragment simpleFragment = SimpleFragment.newInstance();

        fragmentTransaction.add(R.id.fragment_container, simpleFragment).addToBackStack(null).commit();

        isFragmentDisplayed = true;
        nButton.setText(R.string.close);
    }

    private void closeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment_container);

        if(simpleFragment!=null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }

        nButton.setText(R.string.open);
        isFragmentDisplayed = false;
    }
}


package com.example.re;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {

    private TextView mTextMessage;
    private Fragment []mfragme;
    private Serach serach;
    private Collect collect;
    private About about;
    FragmentManager fragmentManager=getSupportFragmentManager();
    private FragmentTransaction transaction;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                transaction=fragmentManager.beginTransaction();
                hideFragment(transaction);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(serach==null) {
                        serach = new Serach();
                        transaction.add(R.id.linearLayout2, serach).commit();
                    }
                    else
                        transaction.show(serach).commit();
                    return true;
                case R.id.navigation_dashboard:
                    if(collect==null){
                        collect=new Collect();
                        transaction.add(R.id.linearLayout2, collect).commit();
                    } else
                        transaction.show(collect).commit();
                    return true;
                case R.id.navigation_notifications:
                    if (about == null) {
                        about = new About();
                        transaction.add(R.id.linearLayout2,about).commit();
                    }else
                    transaction.show(about).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        serach=new Serach();
        getSupportFragmentManager().beginTransaction().add(R.id.linearLayout2, serach).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (collect != null) {
            transaction.hide(collect);
        }
        if (serach != null) {
            transaction.hide(serach);
        }
        if (about != null) {
            transaction.hide(about);
        }
    }
}

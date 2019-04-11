package com.example.re;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main2 extends AppCompatActivity {
    String url="http://192.168.43.169:8080/appService/servlet/Friends";
    private TextView mTextMessage;
    private Fragment []mfragme;
    private Serach serach;
    private Collect collect;
    private About about;
    private List<FriendsInfo> responsData ;
    private String userid;
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
        Intent intent = getIntent();
        userid= intent.getStringExtra("param");
        Log.e("main2", userid );
        getFriends();
        Toast.makeText(this,userid,Toast.LENGTH_LONG).show();
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

    public String getUserid() {
        return  userid;
    }


    public List<FriendsInfo> getFriends() {
//        final Main2 main2= (Main2) getActivity();
//        final List<FriendsInfo> infos=new LinkedList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody=new FormBody.Builder()

                            .add("userid",userid).build();
                    Request request = new Request.Builder()
                            .url(url)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String re=response.body().string();
                    responsData= parseJSONWithGSON(re);
                    Log.e("main2", responsData.get(0).getIp()+responsData.get(0).getName());

                } catch (Exception e) {
                    e.printStackTrace();
                }}
        }).start();
        return null;
    }
    public List<FriendsInfo> parseJSONWithGSON(String jsondata) {
        Gson gson=new Gson();
        List<FriendsInfo> info = gson.fromJson(jsondata, new TypeToken<List<FriendsInfo>>(){}.getType());
        return info;
    }

    public List<FriendsInfo> getResponsData() {
        return responsData;
    }
}





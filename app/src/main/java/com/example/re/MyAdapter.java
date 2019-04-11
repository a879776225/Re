package com.example.re;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<FriendsInfo> {
    private int resourcdID;
    public MyAdapter(Context context, int resource, List<FriendsInfo> objects) {
        super(context, resource, objects);
        resourcdID=resource;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        FriendsInfo friendsInfo = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourcdID, parent, false);
        TextView name = view.findViewById(R.id.name);
        TextView ip = view.findViewById(R.id.classinfo);
        friendsInfo.setName(friendsInfo.getName());
        friendsInfo.setIp(friendsInfo.getIp());
        return view;
    }
}

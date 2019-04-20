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
        ViewHolder viewHolder;
        View view ;

        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourcdID, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.name = view.findViewById(R.id.name);
            viewHolder.ip = view.findViewById(R.id.classinfo);
            view.setTag(viewHolder);
        }
        else {
            view=convertView;
        }
        TextView name = view.findViewById(R.id.name);
        TextView ip = view.findViewById(R.id.classinfo);
        name.setText(friendsInfo.getName());
        ip.setText(friendsInfo.getIp());
        return view;

    }
    class ViewHolder{
        TextView name;
        TextView ip;
    }
}

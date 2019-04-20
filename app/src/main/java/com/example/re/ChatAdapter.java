package com.example.re;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter <ChatAdapter.ViewHolder>{
    private  List<Info> minfo;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftlayout;
        LinearLayout rightlayout;
        TextView nameview;
        TextView otherview;
        public ViewHolder(View view){
            super(view);
            nameview=view.findViewById(R.id.name);
            otherview = view.findViewById(R.id.classinfo);
        }


    }

    public ChatAdapter(List<Info> infoList){
        minfo=infoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int psotion) {
        Info info = minfo.get(psotion);
        viewHolder.nameview.setText(info.getName());
        viewHolder.otherview.setText(info.getClassname());

    }



    @Override
    public int getItemCount() {
        return minfo.size();
    }
}

package com.example.re;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyCurosrAdapter extends CursorAdapter {
    private LayoutInflater layoutInflater;
    private TextView name;
    private TextView classinfo;
    public MyCurosrAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public CharSequence convertToString(Cursor cursor) {
        return cursor==null ? "":cursor.getString(cursor.getColumnIndex("_id"));
    }

    private void setView(View view, Cursor cursor) {
        name = view.findViewById(R.id.name);
        classinfo = view.findViewById(R.id.classinfo);
        name.setText(cursor.getString(cursor.getColumnIndex("name")));
        classinfo.setText(cursor.getString(cursor.getColumnIndex("classname")));

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.info_item, null);
        setView(view,cursor);
        return view;
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        setView(view,cursor);
    }
}

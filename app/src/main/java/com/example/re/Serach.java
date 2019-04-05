package com.example.re;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Serach extends Fragment implements TextWatcher {
    private List<Info> infoList = new ArrayList<>();
    private Button serach;
    private Sqldatabase sqldatabase;
    private SQLiteDatabase database;
    private AutoCompleteTextView autoCompleteTextView;
    private String databasepath= Environment.getExternalStorageDirectory().getPath()+"/redata/sa.db";;
    public Serach() {
        // Required empty public constructor
        this.sqldatabase = new Sqldatabase(getContext(), databasepath, null, 1);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_serach, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        serach = getActivity().findViewById(R.id.button2serach);
        autoCompleteTextView = getActivity().findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.addTextChangedListener(this);
//        autoCompleteTextView.setAdapter();
        serach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "sdfsfa", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        database = SQLiteDatabase.openOrCreateDatabase(databasepath, null);
        Cursor cursor=database.rawQuery("select _id as _id ,name ,classname from wmxm where name like ?",
                new String[]{ s.toString() + "%" });
        MyCurosrAdapter adapter = new MyCurosrAdapter(getActivity(), cursor, true);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);
        a
    }
}

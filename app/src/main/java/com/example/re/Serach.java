package com.example.re;


import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Serach extends Fragment implements TextWatcher {
    private List<Info> infoList = new ArrayList<>();
    private Info saveinfo;
    private Button save;
    private Sqldatabase sqldatabase;
    private SQLiteDatabase database;
    private Cursor cursor;
    private TextView textViewinfoall;
    public String info;
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
        save= getActivity().findViewById(R.id.button2serach);
        textViewinfoall = getActivity().findViewById(R.id.textView4allinfo);
        textViewinfoall.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        autoCompleteTextView = getActivity().findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.addTextChangedListener(this);

//        autoCompleteTextView.setAdapter();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (saveinfo != null) {

                    ContentValues values = new ContentValues();
//                    values.put("_id", saveinfo.getIdnum());
                    values.put("dean", saveinfo.getDean());
                    values.put("classname", saveinfo.getClassname());
                    values.put("name", saveinfo.getName());
                    values.put("addres", saveinfo.getAdress());
                    values.put("date", saveinfo.getBrithdate());
                    values.put("lunar", saveinfo.getLunar_brithday());
                    values.put("citv", saveinfo.getCity());
                    values.put("num", saveinfo.getPhonenum());
                    values.put("md", saveinfo.getMd());
                    database.insert("u_like", null, values);
                }

                Toast.makeText(getActivity(), "", Toast.LENGTH_LONG).show();
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
         cursor=database.rawQuery("select * from wmxm where name like ?",
                new String[]{ s.toString() + "%" });
//        final Cursor cursor1=cursor;
//        cursor12=cursor;
         final MyCurosrAdapter adapter = new MyCurosrAdapter(getActivity(), cursor, true);

        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                autoCompleteTextView.removeTextChangedListener();
                boolean is = cursor.isClosed();
                if (is) {
                    textViewinfoall.setText("close");
                }
                else{
                    cursor.moveToFirst();
//                    textViewinfoall.setText(cursor.getString(0));
                saveinfo=new Info(cursor.getString(0)
                      ,cursor.getString(1)
                      ,cursor.getString(2)
                      ,cursor.getString(3)
                      ,cursor.getString(4)
                      ,cursor.getString(5)
                      ,cursor.getString(6)
                      ,cursor.getString(7)
                      ,cursor.getString(8)
                        ,cursor.getString(9)
                );
                info= cursor.getString( 0)+"\n"+
                        cursor.getString(1)+"\n"+
                        cursor.getString(2)+"\n"+
                        cursor.getString(3)+"\n"+
                        cursor.getString(4)+"\n"+
                        cursor.getString(5)+"\n"+
                        cursor.getString(6)+"\n"+
                        cursor.getString(8);
                textViewinfoall.setText(info);
            }}
        });

    }

    public String getInfo() {
        return info;
    }
}

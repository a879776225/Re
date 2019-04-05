package com.example.re;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Head extends LinearLayout{
    public Head(Context context,AttributeSet attrs) {

        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.searchbox, this);
        ImageButton search = (ImageButton) findViewById(R.id.imageButton);
        final TextView textView = findViewById(R.id.textView2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(load());
            }
        });
    }

    public String load() {
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content = new StringBuilder();
        try {
            in = new FileInputStream("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }







}

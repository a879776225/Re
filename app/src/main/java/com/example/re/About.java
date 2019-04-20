package com.example.re;


import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class About extends Fragment implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private EditText editText;
    private EditText computerre;
    static StringBuilder temp;
    static StringBuilder result;
    private char opre;
    private int TAG=0;


    public About() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_about2, container, false);
        button0 = view.findViewById(R.id.buttonnum10);
        button1 = view.findViewById(R.id.buttonnum1);
        button2 = view.findViewById(R.id.buttonnum2);
        button3 = view.findViewById(R.id.buttonnum3);
        button4 = view.findViewById(R.id.buttonnum4);
        button5 = view.findViewById(R.id.buttonnum5);
        button6 = view.findViewById(R.id.buttonnum6);
        button7 = view.findViewById(R.id.buttonnum7);
        button8 = view.findViewById(R.id.buttonnum8);
        button9 = view.findViewById(R.id.buttonnum9);
        editText = view.findViewById(R.id.editText2);
        computerre = view.findViewById(R.id.editText3result);

        return view;
    }

    @Override
    public void onClick(View v) {
        temp=new StringBuilder();
        result = new StringBuilder();
        switch (v.getId()){

            case R.id.buttonnum10:
                temp.append(button0.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum1:
                temp.append(button1.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum2:
                temp.append(button2.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum3:
                temp.append(button3.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum4:
                temp.append(button4.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum5:
                temp.append(button5.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum6:
                temp.append(button6.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum7:
                temp.append(button7.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum8:
                temp.append(button8.getText());
                editText.setText(temp);
                break;
            case R.id.buttonnum9:
                temp.append(button9.getText());
                editText.setText(temp);
                break;
            case R.id.buttonadd:
                if(TAG>0){
                    computerre.setText(count());
                    editText.setText("");}
                else {
                    opre = '+';
                    TAG=1;
                }
            case R.id.buttonjian:
                if(TAG>0){
                    computerre.setText(count());
                editText.setText("");}
                else {
                    opre = '-';
                    TAG=1;
                }
            case R.id.buttonsq:
                if(TAG>0){
                    computerre.setText(count());
                    editText.setText("");}
                else {
                    opre = '*';
                    TAG=1;
                }
            case R.id.buttonchu:
                if(TAG>0){
                    computerre.setText(count());
                    editText.setText("");}
                else {
                    opre = '/';
                    TAG=1;
                }
        }


    }
    public String setTAG(String operator){
        TAG=1;
        return operator;
    }

    public int count() {
        int re=0;
        switch (opre) {
            case '+':
                re=Integer.parseInt(temp.toString())+Integer.parseInt(editText.getText().toString());
                break;
            case '-':
                re=Integer.parseInt(temp.toString())-Integer.parseInt(editText.getText().toString());
                break;
            case '*':
                re=Integer.parseInt(temp.toString())*Integer.parseInt(editText.getText().toString());
                break;
            case '/':
                re=Integer.parseInt(temp.toString())/Integer.parseInt(editText.getText().toString());
                break;
        }


        return re;
    }
    public void clenInput(){}

}

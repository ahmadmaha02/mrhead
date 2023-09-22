package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class Head extends AppCompatActivity implements View.OnClickListener {
    Button _contact,_back;
    ImageView _Eye;
    ImageView _Beard;
    ImageView _Hair;
    ImageView _Eyebrow;
    CheckBox _CekMata;
    CheckBox _cekAlis;
    CheckBox _cekRambut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        _contact = findViewById(R.id.contact);
        _back = findViewById(R.id.back);
        _Eye = findViewById(R.id.Mata);
        _Beard = findViewById(R.id.Kumis);
        _Eyebrow = findViewById(R.id.Alis);
        _Hair = findViewById(R.id.Rambut);
        _CekMata = findViewById(R.id.boxMata);
        _cekAlis = findViewById(R.id.boxAlis);
        _cekRambut = findViewById(R.id.boxRambut);


        _cekRambut.setOnClickListener(this);
        _CekMata.setOnClickListener(this);
        _cekAlis.setOnClickListener(this);
        _contact.setOnClickListener(this);
        _back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (_cekAlis.getId()==v.getId()){
            if(_Eyebrow.getVisibility()==View.INVISIBLE){
                _Eyebrow.setVisibility(View.VISIBLE);
            }else{
                _Eyebrow.setVisibility(View.INVISIBLE);
            }}


        if (_CekMata.getId()==v.getId()){
            if(_Eye.getVisibility()==View.INVISIBLE){
                _Eye.setVisibility(View.VISIBLE);
            }else{
                _Eye.setVisibility(View.INVISIBLE);
            }}

        if (_cekRambut.getId()==v.getId()){
            if(_Hair.getVisibility()==View.INVISIBLE){
                _Hair.setVisibility(View.VISIBLE);
            }else{
                _Hair.setVisibility(View.INVISIBLE);
            }}
        if (v.getId()==_back.getId()){
            finish();
        }
        if (v.getId()==_contact.getId()){
            Uri uri = Uri.parse("tel:089674405614");
            Intent it = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(it);
        }
    }
}
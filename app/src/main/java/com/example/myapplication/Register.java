package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {
    Button _reg;
    EditText _nama,_email,_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _reg = findViewById(R.id._reg);
        _nama = findViewById(R.id._nama);
        _email = findViewById(R.id._email);
        _Pass = findViewById(R.id._pass);

        _reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==_reg.getId()){
            Intent result = new Intent();
            result.putExtra("email", _email.getText().toString());
            result.putExtra("PW", _Pass.getText().toString());
            setResult(RESULT_OK,result);
            finish();
        }
    }
}
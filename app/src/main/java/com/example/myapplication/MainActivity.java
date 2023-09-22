package com.example.myapplication;

import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button _Regis,_Login;
    EditText _Email;
    EditText _Pass;
    String _tempE,_temP;
    ActivityResultLauncher<Intent> intentLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _Regis = findViewById(R.id._regis);
        _Login = findViewById(R.id._login);
        _Email = findViewById(R.id._email);
        _Pass = findViewById(R.id._pass);
        _Regis.setOnClickListener(this);
        _Login.setOnClickListener(this);

        intentLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
            if(result.getResultCode()==RESULT_OK){
                _tempE = result.getData().getStringExtra("email");
                _Email.setText(_tempE);
                _temP = result.getData().getStringExtra("Password");;
                _Pass.setText(_temP);
            }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            _tempE = data.getStringExtra("email");
            _Email.setText(_tempE);
            _temP = data.getStringExtra("Password");
            _Pass.setText(_temP);
        }
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == _Regis.getId()){
            Intent intent = new Intent(MainActivity.this, Register.class);
            intentLauncher.launch(intent);
        }
        if(v.getId()==_Login.getId()){
            if(_Pass.getText().toString().equals(_temP)&&_Email.getText().toString().equals(_tempE) ){
                Intent il = new Intent(MainActivity.this,Head.class);
                startActivity(il);
            }else{
                Toast.makeText(MainActivity.this,
                        "login gagal", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
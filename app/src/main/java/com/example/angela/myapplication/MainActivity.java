package com.example.angela.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final String TAG = "";
    EditText emailET;
    EditText passwordET;
    EditText phoneET;
    Button registerBtn;
    boolean passwordValid , emailValid , phoneValid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);
        registerBtn = findViewById(R.id.register_btn);
        phoneET = findViewById(R.id.phone_et);



        registerBtn.setOnClickListener(this);
        Log.i("MainActivity", "activity created");

        emailET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                emailValid = isValidEmail();
                enableButton();
            }});

        passwordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordValid = isValidPassword();
                enableButton();
            }});

        phoneET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                phoneValid = isValidPhone();
                enableButton();
            }});



    }

    public void enableButton(){
        registerBtn.setEnabled(emailValid && passwordValid && phoneValid);
    }



    private void ShowErrorMessage() {
        Toast.makeText(getApplicationContext(), "Registrazione fallita", Toast.LENGTH_LONG).show();

    }

    private void ShowSuccessMessage() {
        Toast.makeText(getApplicationContext(), "Registrazione completata",Toast.LENGTH_LONG).show();
    }


    private boolean isValidEmail() {
        String email = emailET.getText().toString();
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword() {
        return (passwordET.getText().toString().length() >= 6);
    }
    private boolean isValidPhone() {
        String phone = phoneET.getText().toString();
        return Patterns.PHONE.matcher(phone).matches();
    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","activity created");

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }




    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.register_btn){

            if (isValidEmail() & isValidPassword() & isValidPhone()) {
                ShowSuccessMessage();
            }else{
                ShowErrorMessage();
            }

        }
    }


}





package com.example.angela.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private static final Object TAG = ;
    EditText emailET;
    EditText passwordET;

    Button loginBtn;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET=findViewById(R.id.email_et);
        passwordET=findViewById(R.id.password_et);
        loginBtn=findViewById(R.id.login_btn);
        registerBtn=findViewById(R.id.register_btn);

        loginBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        Log.i("MainActivity","activity created");

    }

    private boolean isValidEmail(){
        //TODO how to check if a mail is valid
        return false;
    }

    private boolean isValidPassword(){
        //TODO how to check if a password is valid
        return false;
    }

    private void ShowErrorMessage(){
        log.e(TAG,getString(R.string.login_success));
    }

    private void ShowSuccessMessage(){
        log.i(TAG,getString(R.string.password_success));
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
        if(view.getId()==R.id.login_btn){
            //TODO perfom login
        }else if(view.getId()==R.id.register_btn){
            //TODO perform register
        }
    }
}

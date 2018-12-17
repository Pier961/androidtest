package com.example.angela.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class LoginActivity extends AppCompatActivity implements OnClickListener,OnCheckedChangeListener {

    private static final String TAG = "";
    EditText emaillogET;
    EditText passwordlogET;
    EditText phoneET;
    Button loginBtn;
    Button registerlogBtn;
    Switch changecolorSwc;
    LinearLayout sfondoBg;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor spEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emaillogET = findViewById(R.id.emaillog_et);
        passwordlogET = findViewById(R.id.passwordlog_et);
        registerlogBtn = findViewById(R.id.registerlog_btn);
        phoneET = findViewById(R.id.phone_et);
        loginBtn = findViewById(R.id.login_btn);
        changecolorSwc =findViewById(R.id.switchbottom_swc);
        sfondoBg=findViewById(R.id.sfondo);

        loginBtn.setOnClickListener(this);
        registerlogBtn.setOnClickListener(this);
        changecolorSwc.setOnCheckedChangeListener(this);
        Log.i("MainActivity", "activity created");

        sharedPreferences = getPreferences(MODE_PRIVATE );
        spEditor = sharedPreferences.edit();

        sfondoBg.setBackgroundColor(getResources().getColor(sharedPreferences.getInt("sfondobg", 000000)));
        changecolorSwc.setChecked(sharedPreferences.getBoolean("switch", false));




    }



    private void ShowErrorMessage() {
        Toast.makeText(getApplicationContext(), "login fallito", Toast.LENGTH_LONG).show();

    }

    private void ShowSuccessMessage() {
        Toast.makeText(getApplicationContext(), "Login effettuato",Toast.LENGTH_LONG).show();
    }


    private boolean isValidEmail() {
        String email = emaillogET.getText().toString();
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword() {
        return (passwordlogET.getText().toString().length() >= 6);
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

    public void changePage(){
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void changePage2(){
        Intent a = new Intent(getBaseContext(), WelcomeActivity.class);
        String prova = emaillogET.getText().toString();
        a.putExtra("welcome",prova);
        startActivity(a);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.registerlog_btn){

          changePage();

        }else if (view.getId()==R.id.login_btn){
            if (isValidEmail() & isValidPassword()) {
                ShowSuccessMessage();
                changePage2();

            }
            else
                {
                ShowErrorMessage();
                }

        }


        }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            sfondoBg.setBackgroundColor(getResources().getColor(R.color.bg));
            spEditor.putInt("sfondobg",R.color.bg).putBoolean("switch", true).commit();

        }else{
            sfondoBg.setBackgroundColor(getResources().getColor(R.color.bgtext));
            spEditor.putInt("sfondobg",R.color.bgtext).putBoolean("switch", false).commit();
        }
    }
}






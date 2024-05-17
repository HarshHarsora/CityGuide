package com.harshharsora.cityguide.Common.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.harshharsora.cityguide.R;

public class SignupActivity extends AppCompatActivity {
    ImageView backBtn;
    Button next,login;
    TextView titleText;
    TextInputLayout fullName,username,email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        backBtn=findViewById(R.id.signup_back_button);
        next=findViewById(R.id.signup_next_btn);
        login=findViewById(R.id.signup_login_btn);
        titleText=findViewById(R.id.signup_title);


        fullName =findViewById(R.id. signup_fullname);
        username=findViewById(R.id.signup_username);
        email=findViewById(R.id.signup_email);
        password=findViewById(R.id.signup_password);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    public void callNextSignupScreen(View view){

        if (!validateFullName() | !validateUsername() | !validateEmail()){
            return;
        }
        if (password.getEditText().getText().toString().trim().isEmpty()){
            password.setError("field can not be empty");
            Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), SignUp2ndClassActivity.class);
            intent.putExtra("fullName",fullName.getEditText().getText().toString().trim());
            intent.putExtra("username",username.getEditText().getText().toString().trim());
            intent.putExtra("email",email.getEditText().getText().toString().trim());
            intent.putExtra("password",password.getEditText().getText().toString().trim());
            startActivity(intent);
        }

    }

    private boolean validateFullName(){
        String val=fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()){
            fullName.setError("field can not be empty");
            return false;
        }else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateUsername(){
        String val=username.getEditText().getText().toString().trim();
        String checkspaces="\\A\\w{4,20}\\z";
        if (val.isEmpty()){
            username.setError("field can not be empty");
            return false;
        } else if (val.length()>20) {
            username.setError("Username is too large!");
            return false;
        } else if (!val.matches(checkspaces)) {
            username.setError("no white spaces allowed");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail(){
        String val=email.getEditText().getText().toString().trim();
        String checkEmail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()){
            email.setError("field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }


}
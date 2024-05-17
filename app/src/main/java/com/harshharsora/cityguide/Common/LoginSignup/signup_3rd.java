package com.harshharsora.cityguide.Common.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.harshharsora.cityguide.R;
import com.hbb20.CountryCodePicker;

public class signup_3rd extends AppCompatActivity {
    ImageView backBtn;
    TextInputLayout phoneNo;
    CountryCodePicker countryCodePicker;
    Button signup_next_btn;

    String fullName, username, password, date, gender, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup3rd);
        countryCodePicker = findViewById(R.id.country_code);
        phoneNo = findViewById(R.id.signup_phone_number);

        backBtn = findViewById(R.id.signup_back_button);
        signup_next_btn = findViewById(R.id.signup_next_btn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        signup_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callVerifyOTPScreen();
            }
        });

    }

    public void callVerifyOTPScreen() {

        fullName = getIntent().getStringExtra("fullName");
        email = getIntent().getStringExtra("email");
        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        date = getIntent().getStringExtra("date");
        gender = getIntent().getStringExtra("gender");

        String _getUserEnteredPhoneNumber = phoneNo.getEditText().getText().toString().trim();
        String phoneNo = " " + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;
        Intent intent = new Intent(getApplicationContext(), VerifyOtpActivity.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("email", email);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        intent.putExtra("date", date);
        intent.putExtra("gender", gender);
        intent.putExtra("phoneNo", _getUserEnteredPhoneNumber);
        startActivity(intent);
    }
}
package com.harshharsora.cityguide.Common.LoginSignup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.harshharsora.cityguide.R;

import java.time.Year;
import java.util.Calendar;

public class SignUp2ndClassActivity extends AppCompatActivity {
    ImageView backBtn;
    Button next,login;
    TextView titleText;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;

    String fullName,email,password,username;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up2nd_class);

        backBtn=findViewById(R.id.signup_back_button);
        next=findViewById(R.id.signup_next_btn);
        login=findViewById(R.id.signup_login_btn);
        titleText=findViewById(R.id.signup_title);
        radioGroup=findViewById(R.id.radio_group);
        datePicker=findViewById(R.id.age_picker);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void call3rdSignupScreen(View view){
        if (!validateGender() | !validateAge()){
            return;
        }

        selectedGender=findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(this, ""+selectedGender.getText().toString(), Toast.LENGTH_SHORT).show();


        int day =datePicker.getDayOfMonth();
        int month =datePicker.getMonth();
        int year =datePicker.getYear();

        String date= day+"/"+month+"/"+year;


        Intent intent=new Intent(getApplicationContext(), signup_3rd.class);
        intent.putExtra("fullName",fullName);
        intent.putExtra("username",username);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
         intent.putExtra("date",date);
        intent.putExtra("gender",selectedGender.getText().toString());
        Toast.makeText(this, ""+fullName, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    private boolean validateGender(){
        if (radioGroup.getCheckedRadioButtonId()== -1){
            Toast.makeText(this, "Please select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    private boolean validateAge(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge =datePicker.getYear();
        int isAgeValid =currentYear-userAge;

        if (isAgeValid<18){
            Toast.makeText(this, "your age not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }

}
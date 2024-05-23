package com.harshharsora.cityguide.Common.LoginSignup;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;


import com.harshharsora.cityguide.R;

public class LoginActivity extends AppCompatActivity {
ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_login);

        btnBack=findViewById(R.id.login_back_btn);

      btnBack.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              onBackPressed();
          }
      });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
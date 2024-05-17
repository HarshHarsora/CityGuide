package com.harshharsora.cityguide.User;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.harshharsora.cityguide.Common.LoginSignup.RetailerStartActivity;
import com.harshharsora.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.harshharsora.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.harshharsora.cityguide.HelperClasses.HomeAdapter.cardAdepter;
import com.harshharsora.cityguide.HelperClasses.HomeAdapter.mostAdepter;
import com.harshharsora.cityguide.R;

import java.util.ArrayList;

public class UserDeshbordActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView featuredRecycler ,mostViewedRecycler,categoriesRecycler;
    //Drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
  ImageView btn_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_deshbord);

        //hook

        featuredRecycler=findViewById(R.id.featured_recycler);
        mostViewedRecycler=findViewById(R.id.most_viewed_recycler);
        categoriesRecycler=findViewById(R.id.categories_recycler);
        btn_nav=findViewById(R.id.btn_nav);

        //menu hook
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);

        //navigation drawer


        navigationDrawer();

        featuredRecycler();
        mostViewedRecycler ();
        categoriesRecycler();
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener( this);
        navigationView.setCheckedItem(R.id.nav_home);

        btn_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (drawerLayout.isDrawerVisible(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    public void callRetailerScreen(View view){
        startActivity(new Intent(getApplicationContext(), RetailerStartActivity.class));
       
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       if (menuItem.getItemId()==R.id.nav_categories){
           startActivity(new Intent(this,AllCategoriesActivity.class));
       }
        return true;
    }

    //recycle view function
    private void featuredRecycler () {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations1 = new ArrayList<>();
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.mcdonald_img, "McDonald's", "McDonald's Corporation is an American multinational fast food"));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.hotel_img, "Hotel's", "The hotel was the perfect array of homey hues. "));
        featuredLocations1.add(new FeaturedHelperClass(R.drawable.categories_shop_icon, "Shop", "McDonald's Corporation is an American multinational fast"));

        FeaturedAdapter adapter = new FeaturedAdapter(featuredLocations1);
        featuredRecycler.setAdapter(adapter);

    }
    private void  mostViewedRecycler () {

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonald_img, "McDonald's", "McDonald's Corporation is an American multinational fast food"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.hotel_img, "Hotel's", "The hotel was the perfect array of homey hues. "));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.edu_img, "Eduction", "McDonald's Corporation is an American multinational fast"));


        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mostAdepter  adapter = new mostAdepter(featuredLocations);
        mostViewedRecycler.setAdapter(adapter);

    }
    private void   categoriesRecycler() {

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.categories_restaurant_icon, "Restaurant"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.categories_shop_icon, "Shopping"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.hospital_image, "Hospital"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bike_icon, "Bike Location"));


        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        cardAdepter adapter = new cardAdepter(featuredLocations);
        categoriesRecycler.setAdapter(adapter);
    }
}
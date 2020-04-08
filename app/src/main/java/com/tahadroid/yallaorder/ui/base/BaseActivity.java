package com.tahadroid.yallaorder.ui.base;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.tahadroid.yallaorder.ui.cart.AddCartActivity;
import com.tahadroid.yallaorder.ui.password.ForgetPasswordActivity;
import com.tahadroid.yallaorder.ui.place.LocationActivity;
import com.tahadroid.yallaorder.ui.login.LoginActivity;
import com.tahadroid.yallaorder.ui.payment.PaymentActivity;
import com.tahadroid.yallaorder.R;
import com.tahadroid.yallaorder.ui.restaurant.RestaurentsActivity;
import com.tahadroid.yallaorder.ui.restaurant.RestautrantMenuActivity;
import com.tahadroid.yallaorder.ui.signup.SignupActivity;
import com.tahadroid.yallaorder.databinding.ActivityBaseBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityBaseBinding binding;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // setSupportActionBar(binding.toolbar);
        View header = binding.navigation.getHeaderView(0);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        {
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }
//        }

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navigation.setNavigationItemSelectedListener(this);

        //FIRST SHOW
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view_tag, new LoginActivity())
                    .commit();
            binding.navigation.setCheckedItem(R.id.logincl);
        }
    }

//    @Override
//    public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_in:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new LoginActivity())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.sign_up:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new SignupActivity())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.location:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new LocationActivity())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.add_cart:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new AddCartActivity())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.restaurant:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new RestaurentsActivity())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.res_menu:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new RestautrantMenuActivity())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.payment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new PaymentActivity())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.forget_pass:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new ForgetPasswordActivity())
                        .addToBackStack(null)
                        .commit();
                break;
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

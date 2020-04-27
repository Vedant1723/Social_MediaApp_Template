package com.vedev.assignmentblackcoffer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView userName;
    private TextView userEmail;
    public static ImageView userDp;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private androidx.appcompat.widget.Toolbar toolbar;
    private NavigationView navigationView;
    private View headerView;
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private ExploreFragment exploreFragment;
    private TendingFragment trendingFragment;
    private SavedFragment savedFragment;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);


        homeFragment = new HomeFragment();
        exploreFragment = new ExploreFragment();
        trendingFragment = new TendingFragment();
        savedFragment = new SavedFragment();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        headerView = navigationView.getHeaderView(0);
        userName = (TextView) headerView.findViewById(R.id.userName);
        userEmail = (TextView) headerView.findViewById(R.id.userEmail);
        userDp = (CircleImageView) headerView.findViewById(R.id.userDP);
        title = "#Tags";
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        addFragment(homeFragment);
        setFragment(homeFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.tagsBtn: {
                        Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        setFragment(homeFragment);
                        getSupportActionBar().setTitle("#tags");
                        return true;
                    }
                    case R.id.trendingBtn: {
                        Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        setFragment(trendingFragment);
                        getSupportActionBar().setTitle("Trending Now");
                        return true;
                    }
                    case R.id.exploreBtn: {
                        Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        setFragment(exploreFragment);
                        getSupportActionBar().setTitle("Explore #tags");
                        return true;
                    }
                    case R.id.savedBtn: {
                        Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        setFragment(savedFragment);
                        getSupportActionBar().setTitle("Saved #tags");
                        return true;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }

            }
        });
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tagsBtn: {
                        Toast.makeText(HomeActivity.this, "You are already on " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        getSupportActionBar().setTitle("#tags");
                        break;
                    }
                    case R.id.trendingBtn: {
                        Toast.makeText(HomeActivity.this, "You are already on " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        getSupportActionBar().setTitle("Trending Now");
                        break;
                    }
                    case R.id.exploreBtn: {
                        Toast.makeText(HomeActivity.this, "You are already on " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        getSupportActionBar().setTitle("Explore #tags");
                        break;
                    }
                    case R.id.savedBtn: {
                        Toast.makeText(HomeActivity.this, "You are already on " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        getSupportActionBar().setTitle("Saved #tags");
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }


            }
        });

        userName.setText(MainActivity.personName);
        userEmail.setText(MainActivity.email);
        Glide.with(getApplicationContext()).load(MainActivity.displayUri)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(userDp);
    }
    private void addFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.mainLayout,fragment).commit();
    }

    private void setFragment(Fragment fragment) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.mainLayout);
        constraintLayout.removeAllViews();
        constraintLayout.setVisibility(View.VISIBLE);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.mainLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout: {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }

        return false;
    }
}

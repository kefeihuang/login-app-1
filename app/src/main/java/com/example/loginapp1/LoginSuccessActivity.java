package com.example.loginapp1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.fragment.NavHostFragment;

import com.example.loginapp1.databinding.ActivityLoginSuccessBinding;

public class LoginSuccessActivity extends AppCompatActivity {

//    private AppBarConfiguration appBarConfiguration;
//    private ActivityLoginSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String usernameText = intent.getStringExtra("username");
        String passwordText = intent.getStringExtra("password");
        String text = "Credentials: " + usernameText + " / " + passwordText;
        textView.setText(text);

        Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show();


//        EdgeToEdge.enable(this);
//
//        binding = ActivityLoginSuccessBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        setSupportActionBar(binding.toolbar);
//
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment_content_main);
//
//        if (navHostFragment != null) {
//            NavController navController = navHostFragment.getNavController();
//
//            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        }
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//            }
//        });
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment_content_main);
//        NavController navController = navHostFragment.getNavController();
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}
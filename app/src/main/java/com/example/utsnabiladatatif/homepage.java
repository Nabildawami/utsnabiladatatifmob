package com.example.utsnabiladatatif;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.utsnabiladatatif.DaftarFragment;
import com.example.utsnabiladatatif.DosenFragment;
import com.example.utsnabiladatatif.HomeFragment;
import com.example.utsnabiladatatif.R;
import com.example.utsnabiladatatif.StatusFragment;
import com.example.utsnabiladatatif.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepage extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView bottomNavigationVieww;
    private FrameLayout frameLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        bottomNavigationView = findViewById(R.id.bottomview);
        bottomNavigationVieww= findViewById(R.id.bottomvieww);
        frameLayout = findViewById(R.id.framelayout);

        // Mengatur listener untuk BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Mendapatkan ID item yang dipilih
                int itemId = item.getItemId();

                // Memilih fragment yang sesuai berdasarkan item yang dipilih
                switch (itemId) {
                    case R.id.home:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.dosen:
                        loadFragment(new DosenFragment());
                        return true;
                    case R.id.daftar:
                        loadFragment(new DaftarFragment());
                        return true;
                    case R.id.status:
                        loadFragment(new StatusFragment());
                        return true;
                }

                return false;
            }
        });

        bottomNavigationVieww.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Mendapatkan ID item yang dipilih
                int itemId = item.getItemId();

                // Memilih fragment yang sesuai berdasarkan item yang dipilih
                switch (itemId) {
                    case R.id.account:
                        loadFragment(new AccountFragment());
                        return true;
                }
                return false;
            }
        });

        // Memuat fragment pertama kali saat activity dibuat
        loadFragment(new HomeFragment());
    }

    // Metode untuk memuat fragment
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}

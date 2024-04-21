package com.example.utsnabiladatatif;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private CheckBox checkBoxShowPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        checkBoxShowPassword = findViewById(R.id.checkBoxShowPassword);

        checkBoxShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Mengubah inputType EditText menjadi "text" atau "textPassword" berdasarkan status CheckBox
                if (isChecked) {
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                // Memastikan teks pada EditText tetap terlihat setelah perubahan inputType
                editTextPassword.setSelection(editTextPassword.getText().length());
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Memeriksa apakah kedua input diisi atau tidak
                if (TextUtils.isEmpty(editTextUsername.getText().toString()) || TextUtils.isEmpty(editTextPassword.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Silakan isi username dan password terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    // Jika kedua input diisi, maka periksa kredensial
                    checkCredentials();
                }
            }
        });
    }

    private void checkCredentials() {
        // Implementasikan logika pemeriksaan kredensial di sini
        // Anda dapat memeriksa kredensial dengan database, API, atau logika lainnya
        // Contoh sederhana:
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        if (username.equals("111") && password.equals("111")) {
            // Login berhasil, pindah ke halaman utama
            Intent intent = new Intent(MainActivity.this, homepage.class);
            startActivity(intent);
            finish(); // Optional, untuk menutup activity login setelah pindah ke halaman utama
        } else {
            // Login gagal, tampilkan pesan kesalahan
            Toast.makeText(MainActivity.this, "Login gagal, periksa kembali username dan password Anda", Toast.LENGTH_SHORT).show();
            // Mengosongkan EditText username dan password
            editTextUsername.setText("");
            editTextPassword.setText("");
        }
    }
}

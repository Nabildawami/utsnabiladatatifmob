package com.example.utsnabiladatatif;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class frompage extends AppCompatActivity {

    private static final int PICK_PDF_REQUEST = 1;
    private Button buttonChooseFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.from);

        buttonChooseFile = findViewById(R.id.buttonChooseFile);

        // Mengatur onClickListener untuk tombol "Upload Berkas"
        buttonChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }
        });

        // Mengatur onClickListener untuk tombol "Kirim"
        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke HomeFragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new HomeFragment())
                        .commit();
            }
        });

        // Mengatur onClickListener untuk tombol "Batal"
        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke DaftarFragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DaftarFragment())
                        .commit();
            }
        });
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF"), PICK_PDF_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PDF_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            // File yang dipilih
            Uri filePath = data.getData();
            // Lakukan sesuatu dengan file yang dipilih, seperti mengunggahnya ke server
            // Contoh:
            String selectedFilePath = filePath.getPath();
            // Tampilkan pesan bahwa file telah dipilih
            Toast.makeText(this, "File selected: " + selectedFilePath, Toast.LENGTH_LONG).show();
            // Ubah teks tombol menjadi "Upload Berhasil"
            buttonChooseFile.setText("Upload Berhasil");
        }
    }
}

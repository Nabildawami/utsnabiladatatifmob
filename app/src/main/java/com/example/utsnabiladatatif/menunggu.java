package com.example.utsnabiladatatif;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class menunggu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunggu);

        // Mengambil referensi tombol kembali
        Button kembaliButton = findViewById(R.id.buttonKembali);

        // Menambahkan OnClickListener ke tombol kembali
        kembaliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk kembali ke halaman StatusFragment
                Intent intent = new Intent(menunggu.this, MainActivity.class);
                // Mengatur agar tidak ada multiple instances dari MainActivity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                // Menutup aktivitas saat ini (Diterimal)
                finish();
            }
        });
    }
}


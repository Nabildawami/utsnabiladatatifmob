package com.example.utsnabiladatatif;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        // Mengambil referensi tombol keluar
        Button keluarButton = view.findViewById(R.id.keluar_button);

        // Menambahkan OnClickListener ke tombol keluar
        keluarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk kembali ke MainActivity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                // Mengatur agar tidak ada multiple instances dari MainActivity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                // Menutup aktivitas saat ini (AccountFragment)
                getActivity().finish();
            }
        });

        return view;
    }
}

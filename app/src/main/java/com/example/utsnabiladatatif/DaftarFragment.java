package com.example.utsnabiladatatif;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;

public class DaftarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daftar, container, false);

        // Mendapatkan referensi tombol "Daftar"
        Button daftarButton = view.findViewById(R.id.button);

        // Mengatur onClickListener untuk tombol "Daftar"
        daftarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buat Intent untuk berpindah ke frompage
                Intent intent = new Intent(getActivity(), frompage.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

package com.example.utsnabiladatatif;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class StatusFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        // Mengambil referensi TextView lihat3 dari layout
        TextView lihat3TextView = view.findViewById(R.id.lihat3);
        TextView lihat2TextView = view.findViewById(R.id.lihat2);
        TextView lihat1TextView = view.findViewById(R.id.lihat);

        // Menambahkan OnClickListener ke TextView lihat3
        lihat3TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk memulai aktivitas Diterimal
                Intent intent = new Intent(getActivity(), Diterimal.class);
                startActivity(intent);
            }
        });
        lihat1TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk memulai aktivitas
                Intent intent = new Intent(getActivity(), ditolak.class);
                startActivity(intent);
            }
        });
        lihat2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk memulai aktivitas
                Intent intent = new Intent(getActivity(), menunggu.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

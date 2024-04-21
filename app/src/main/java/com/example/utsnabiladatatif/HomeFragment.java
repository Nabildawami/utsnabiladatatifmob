package com.example.utsnabiladatatif;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        List<item> items = new ArrayList<>();
        items.add(new item("Informasi Pengumpulan Datamahasiswa", "pengumpulan dilakukan pada waktu yang telah disampaikan pada surat edaran setiap falkutas", R.drawable.baseline_album_24));
        items.add(new item("Informasi Pengumpulan Data Dosen", "pengumpulan dilakukan pada waktu yang telah disampaikan pada surat edaran setiap falkutas", R.drawable.baseline_album_24));
        items.add(new item("Informasi Pengumpulan Data Rektor", "pengumpulan dilakukan pada waktu yang telah disampaikan pada surat edaran setiap falkutas", R.drawable.baseline_album_24));
        items.add(new item("Informasi Pengumpulan Data Alumni", "pengumpulan dilakukan pada waktu yang telah disampaikan pada surat edaran setiap falkutas", R.drawable.baseline_album_24));
        items.add(new item("Informasi Pengumpulan Data Maba", "pengumpulan dilakukan pada waktu yang telah disampaikan pada surat edaran setiap falkutas", R.drawable.baseline_album_24));


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyAdapter(getActivity(), items));

        return view;
    }
}

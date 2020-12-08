package com.example.dinoapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dinoapp.GameActivity;
import com.example.dinoapp.R;
import com.example.dinoapp.TenttiActivity;
import com.example.dinoapp.YtjActivity;

public class HomeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button playButton = view.findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),GameActivity.class);
                startActivity(intent);
            }
        });

//
//           Button findCompanyButton = view.findViewById(R.id.findCompanyButton);
//           final EditText searchCompanyText = view.findViewById(R.id.searchCompanyText);
//
//            findCompanyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               String companyNameSearch = searchCompanyText.getText().toString();
//                Intent intent = new Intent(getActivity(), YtjActivity.class);
//                intent.putExtra("search", companyNameSearch);
//
//                startActivity(intent);
//            }
//        });

        Button findCompanyButton = view.findViewById(R.id.findCompanyButton);
        final EditText searchCompanyText = view.findViewById(R.id.searchCompanyText);

        findCompanyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TenttiActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
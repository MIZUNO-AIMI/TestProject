package com.example.namebattler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BattleMainFragment extends Fragment {

    // Fragmentで表示するViewを作成するメソッド
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // 先ほどのレイアウトをここでViewとして作成します
        View view = inflater.inflate(R.layout.fragment_main_battle, container, false);

        Bundle bundle = getArguments();
        String title = bundle.getString("TITLE");

        TextView textView = view.findViewById(R.id.textView);

        // テキストを設定
        textView.setText(title);


        return view;
    }
}

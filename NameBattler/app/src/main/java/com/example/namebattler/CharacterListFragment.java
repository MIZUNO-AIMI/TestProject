package com.example.namebattler;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CharacterListFragment extends Fragment {

    String title = "";

    // Fragmentで表示するViewを作成するメソッド
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // 先ほどのレイアウトをここでViewとして作成します
        View view = inflater.inflate(R.layout.fragment_character_list, container, false);

        Bundle bundle = getArguments();
        title = bundle.getString("TITLE");


        TextView textView = view.findViewById(R.id.textView);

        // テキストを設定
        textView.setText(title);

        //ボタンを設定
        Button button1 = view.findViewById(R.id.button1);



        return view;
    }

    // Viewが生成し終わった時に呼ばれるメソッド
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(title.equals("キャラ一覧( )人")){

                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else if(title.equals("2")){

                    Intent intent = new Intent(getActivity(), CharacterList.class);
                    startActivity(intent);
                }

            }
        });
    }
}

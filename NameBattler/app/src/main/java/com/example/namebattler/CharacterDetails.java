package com.example.namebattler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class CharacterDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_character_details);
        // コードからFragmentを追加

        // データを渡す為のBundleを生成し、渡すデータを内包させる
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("TITLE", "キャラ詳細");
        bundle2.putInt("PageNumber", 2);

        // コードからFragmentを追加

        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Fragmentを作成します
        CharacterListFragment fragment = new  CharacterListFragment();

        // setArgumentsで先ほどのbundleをセットする
        fragment.setArguments(bundle);

        // replace メソッドを使う？
        // すでにFragmentが存在する場合には、一度removeしてからaddする
        transaction.replace(R.id.container, fragment);
        // 最後にcommitを使用することで変更を反映します

    }
}

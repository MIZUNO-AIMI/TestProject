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

        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Fragmentを作成します
        CharacterListFragment fragment = new  CharacterListFragment();
        // 新しく追加を行うのでaddを使用します
        // 他にも、よく使う操作で、replace removeといったメソッドがあります
        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
        transaction.add(R.id.container, fragment);
        // 最後にcommitを使用することで変更を反映します
        transaction.commit();
    }
}

package com.example.namebattler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_character_list);

        // データを渡す為のBundleを生成し、渡すデータを内包させる
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", "キャラ一覧( )人");

        //ボタンを設定
        Button button3 = this.findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplication(), CharacterCreate.class);
                startActivity(intent3);
            }
        });

        // コードからFragmentを追加

        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Fragmentを作成します
        CharacterListFragment fragment = new  CharacterListFragment();

        // setArgumentsで先ほどのbundleをセットする
        fragment.setArguments(bundle);

        // 新しく追加を行うのでaddを使用します
        // 他にも、よく使う操作で、replace removeといったメソッドがあります
        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
        transaction.add(R.id.container, fragment);
        // 最後にcommitを使用することで変更を反映します
        transaction.commit();


    }


}

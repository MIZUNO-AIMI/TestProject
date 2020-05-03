package com.example.namebattler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class CharacterCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // データを渡す為のBundleを生成し、渡すデータを内包させる
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", "キャラ作成");
        // コードからFragmentを追加

        setContentView(R.layout.activity_character_create);

        EditText editText = findViewById(R.id.edit_text1);

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
        transaction.commit();


        //ボタンを設定
        Button button4 = this.findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplication(), CharacterCreateComplete.class);
                startActivity(intent4);
            }
        });


    }

}

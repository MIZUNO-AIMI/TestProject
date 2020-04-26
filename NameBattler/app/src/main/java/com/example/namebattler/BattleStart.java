package com.example.namebattler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class BattleStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_battle);

        // データを渡す為のBundleを生成し、渡すデータを内包させる
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", "バトル開始");
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

        //ボタンを設定
        Button button9 = this.findViewById(R.id.button9);
        Button button10 = this.findViewById(R.id.button10);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), BattleMainActivity.class);
                startActivity(intent);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}

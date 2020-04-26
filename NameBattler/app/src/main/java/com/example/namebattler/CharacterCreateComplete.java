package com.example.namebattler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class CharacterCreateComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // データを渡す為のBundleを生成し、渡すデータを内包させる
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", "キャラ作成");

        setContentView(R.layout.activity_character_complete);
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
        Button button5 = this.findViewById(R.id.button5);
        Button button6 = this.findViewById(R.id.button6);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // アクティビティを終了させる事により、一つ前のアクティビティへ戻る事が出来る。
                finish();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent5 = new Intent(getApplication(), CharacterList.class);
                startActivity(intent5);
            }
        });
    }
}

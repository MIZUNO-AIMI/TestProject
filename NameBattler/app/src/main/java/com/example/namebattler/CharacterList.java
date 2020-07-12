package com.example.namebattler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;


public class CharacterList extends AppCompatActivity {

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // データを渡す為のBundleを生成し、渡すデータを内包させる
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", "キャラ一覧( )人");

        //listview
        myListView = (ListView)findViewById(R.id.myListView);

        //ボタンを設定
        Button button3 = this.findViewById(R.id.button3);

        setContentView(R.layout.activity_character_list);
        // DB作成
        CustomOpenHelper helper = new CustomOpenHelper(getApplicationContext());
        ArrayAdapter<String> arrayAdapter;

        //読み取り専用で良い場合はgetReadableDatabase()を呼び出す
        SQLiteDatabase db = helper.getReadableDatabase();

        // simple_list_item_1 は、 もともと用意されている定義済みのレイアウトファイルのID
        arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        // ListViewにArrayAdapterを設定する
        myListView.setAdapter(arrayAdapter);

        try{
        Cursor cursor = db.query(
                "DBName", // DB名
                new String[]{"COLUMN_NAME_TITLE1", "COLUMN_NAME_TITLE2"
                        , "COLUMN_NAME_TITLE3", "COLUMN_NAME_TITLE4"
                        , "COLUMN_NAME_TITLE5", "COLUMN_NAME_TITLE6"
                        , "COLUMN_NAME_TITLE7", "COLUMN_NAME_TITLE8"
                        , "COLUMN_NAME_TITLE9"
                },
                // 取得するカラム名
                null, // WHERE句の列名
                null, // WHERE句の値
                null, // GROUP BY句の値
                null, // HAVING句の値
                null);// ORDER BY句の値


            StringBuilder sbuilder = new StringBuilder();

            for (int i = 0; i < cursor.getCount(); i++) {
                sbuilder.append(cursor.getString(0));
                sbuilder.append("      ");
                sbuilder.append(cursor.getInt(1));
                sbuilder.append("\nHP:");
                sbuilder.append(cursor.getInt(2));
                sbuilder.append(" MP:");
                sbuilder.append(cursor.getInt(3));
                sbuilder.append(" STR:");
                sbuilder.append(cursor.getInt(4));
                sbuilder.append(" DEF:");
                sbuilder.append(cursor.getInt(5));
                sbuilder.append(" AGI:");
                sbuilder.append(cursor.getInt(6));

                cursor.moveToFirst();
            }

            cursor.close();
        }
        finally{
            db.close();
        }


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

package com.example.namebattler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BattleMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_battle);

        //ボタンを設定
        Button button11 = this.findViewById(R.id.button11);
        Button button12 = this.findViewById(R.id.button12);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), TacticsSelect.class);
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
}

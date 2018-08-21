package jp.techacademy.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Double ans = intent.getDoubleExtra("ANS",0);

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(String.valueOf(ans));
    }
}

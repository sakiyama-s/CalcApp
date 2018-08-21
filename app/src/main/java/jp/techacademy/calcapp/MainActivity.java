package jp.techacademy.calcapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        Button buttonSub = (Button) findViewById(R.id.buttonSub);
        Button buttonMulti = (Button) findViewById(R.id.buttonMulti);
        Button buttonDivision = (Button) findViewById(R.id.buttonDivision);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        TextView tv1 = (TextView) findViewById(R.id.editText1);
        TextView tv2 = (TextView) findViewById(R.id.editText2);
        String val1str = "";
        String val2str = "";
        val1str = tv1.getText().toString();
        val2str = tv2.getText().toString();


        Intent intent = new Intent(this, SecondActivity.class);

        if (!val1str.equals("") && !val2str.equals("")) {
            Double val1 = Double.valueOf(val1str);
            Double val2 = Double.valueOf(val2str);
            if (v.getId() == R.id.buttonAdd) {
                // 足し算
                intent.putExtra("ANS", val1 + val2);
                startActivity(intent);
            } else if (v.getId() == R.id.buttonSub) {
                // 引き算
                intent.putExtra("ANS", val1 - val2);
                startActivity(intent);
            } else if (v.getId() == R.id.buttonMulti) {
                // かけ算
                intent.putExtra("ANS", val1 * val2);
                startActivity(intent);
            } else if (v.getId() == R.id.buttonDivision) {
                // 割り算
                if (val2 != 0) {
                    // 0除算回避
                    intent.putExtra("ANS", val1 / val2);
                    startActivity(intent);
                } else {
                    showAlertDialog();
                }
            }
        } else {
            showAlertDialog();
        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Alert");
        adb.setMessage("値が不適切です");

        adb.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog ad = adb.create();
        ad.show();
    }
}

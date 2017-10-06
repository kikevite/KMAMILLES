package edu.upc.eseiaat.pma.kmamilles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_a_millas = (Button) findViewById(R.id.btn_a_millas);
        Button btn_a_km = (Button) findViewById(R.id.btn_a_km);
        Button btn_exit = (Button) findViewById(R.id.btn_exit);

        final EditText edit_km = (EditText) findViewById(R.id.edit_km);
        final EditText edit_millas = (EditText) findViewById(R.id.edit_millas);

        btn_a_millas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Bernat","Boto de milles clickat!");
                String skm = edit_km.getText().toString();
                if (skm.isEmpty()){skm="0";}
                float km = Float.parseFloat(skm);
                float millas = km / 1.609344f;
                String smillas = String.format("%f", millas);

                int coma = smillas.indexOf(',');
                String p1 = smillas.substring(0, coma);
                String p2 = smillas.substring(coma+1, smillas.length());
                String mill = p1 + "." + p2;

                edit_millas.setText(mill);
            }
        });

        btn_a_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Bernat","Boto de kilometres clickat!");
                String smillas = edit_millas.getText().toString();
                if (smillas.isEmpty()){smillas="0";}
                float millas = Float.parseFloat(smillas);
                float km = millas * 1.609344f;
                String skm = String.format("%f", km);

                int coma = skm.indexOf(',');
                String p1 = skm.substring(0, coma);
                String p2 = skm.substring(coma+1, skm.length());
                String kmm = p1 + "." + p2;

                edit_km.setText(kmm);
            }


        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
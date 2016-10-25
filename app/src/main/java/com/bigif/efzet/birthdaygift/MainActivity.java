package com.bigif.efzet.birthdaygift;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Button Doa;
    TextView t;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PengaturMusik.getInstance().putarUlang(this, R.raw.happy);
        t = (TextView) findViewById(R.id.textViewSel);
        t2 = (TextView) findViewById(R.id.textViewNa);
        Typeface sukaFont = Typeface.createFromAsset(getAssets(), "jls.ttf");
        Typeface sukaFont2 = Typeface.createFromAsset(getAssets(), "jit.ttf");
        Typeface sukaFont3 = Typeface.createFromAsset(getAssets(),"krema.otf");
        t.setTypeface(sukaFont);
        t2.setTypeface(sukaFont2);
        t.setGravity(Gravity.CENTER);
        t2.setGravity(Gravity.CENTER);

        if(HarapanManager.getInstance().adaHarapan(getApplicationContext())!=null){
            Doa = (Button) findViewById(R.id.button);
            Doa.setText(R.string.l_harapan);
            Doa.setTypeface(sukaFont3);
            Doa.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(getApplicationContext(), Harapan.class);
                                           PengaturMusik.getInstance().stop();
                                           startActivity(i);
                                           finish();

                                       }
                                   }
            );
        } else {
            Doa = (Button) findViewById(R.id.button);
            Doa.setTypeface(sukaFont3);
            Doa.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(getApplicationContext(), Doa.class);
                                           PengaturMusik.getInstance().stop();
                                           startActivity(i);

                                       }
                                   }
            );
        }


    }

    Boolean duaKali=false;
    @Override
    public void onBackPressed() {
        if (duaKali) {
            super.onBackPressed();
            finish();
            System.exit(0);
        }

        duaKali = true;
        Toast.makeText(this, "Takan sakali lai untuak kalua", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                duaKali = false;
            }
        }, 3000);
    }
}

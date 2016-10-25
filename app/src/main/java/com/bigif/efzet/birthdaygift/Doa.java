package com.bigif.efzet.birthdaygift;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Doa extends AppCompatActivity implements View.OnClickListener {
    TextView doa;
    Button am;
    Button hm;
    int idDoa = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface sukaFont3 = Typeface.createFromAsset(getAssets(),"krema.otf");
        setContentView(R.layout.activity_doa);
        doa = (TextView) findViewById(R.id.doa);
        am = (Button) findViewById(R.id.amin);
        hm=(Button)findViewById(R.id.hmm) ;
        hm.setTypeface(sukaFont3);
        am.setTypeface(sukaFont3);
        int idd = this.getResources().getIdentifier("doa" + String.valueOf(idDoa), "string", this.getPackageName());
        doa.setText(idd);
        doa.setTypeface(sukaFont3);
        doa.setGravity(Gravity.CENTER);

    }

    @Override
    public void onClick(View v) {
        Typeface f = Typeface.createFromAsset(getAssets(),"krema.otf");
        PengaturMusik.getInstance().release();
        am.setOnClickListener(this);
        switch (v.getId()) {
            case R.id.amin:
                idDoa++;
                if (idDoa <= 11) {
                    PengaturMusik.getInstance().initializeMusicPlayer(this, R.raw.amiin);
                    int idd = this.getResources().getIdentifier("doa" + String.valueOf(idDoa), "string", this.getPackageName());
                    doa.setText(idd);
                    doa.setTypeface(f);
                    break;
                } else {
                    PengaturMusik.getInstance().initializeMusicPlayer(this, R.raw.amin);
                    Intent keHarapan= new Intent(getApplicationContext(),Akhir.class);
                    startActivity(keHarapan);
                    finish();
                    break;
                }
            case R.id.hmm:
                Toast.makeText(getApplicationContext(), "Harus diaminkan ! :P", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.bigif.efzet.birthdaygift;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class Harapan extends AppCompatActivity {

    TextView hrp;
    TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harapan);
        PengaturMusik.getInstance().putarUlang(getApplicationContext(),R.raw.jds);
        Typeface sukaFont3 = Typeface.createFromAsset(getAssets(),"krema.otf");
        hrp=(TextView) findViewById(R.id.textView);
        tt=(TextView)findViewById(R.id.textView2) ;
        tt.setTypeface(sukaFont3);
        hrp.setTypeface(sukaFont3);
        tt.setGravity(Gravity.CENTER);
        hrp.setGravity(Gravity.CENTER);
        HarapanManager.getInstance().bacaHarapan(hrp,getApplicationContext());
    }

    public void onBackPressed(){
        //super.onBackPressed();
        Intent i =new Intent(this,MainActivity.class);
        PengaturMusik.getInstance().stop();
        startActivity(i);
        finish();
    }
}

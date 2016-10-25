package com.bigif.efzet.birthdaygift;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Akhir extends AppCompatActivity {

    EditText et;
    Button bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akhir);

        Typeface sukaFont3 = Typeface.createFromAsset(getAssets(),"krema.otf");
        et = (EditText) findViewById(R.id.editText2);
        bs = (Button) findViewById(R.id.bSimpan);
        et.setTypeface(sukaFont3);
        bs.setTypeface(sukaFont3);
        bs.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      onCreateDialog();
                                  }
                              }
        );
    }

        public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Akhir.this);
        builder.setCancelable(true);
        builder.setIcon(R.drawable.dialog_warning);
        builder.setMessage("Apakah yakin dengan harapan tersebut?");
            builder.setPositiveButton("Yakin Dong",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(Akhir.this, Harapan.class);
                            HarapanManager.getInstance().tulisHarapan(et, Akhir.this);
                            startActivity(i);
                            finish();
                            dialog.dismiss();
                        }
                    });
            builder.setNegativeButton("Hmm Tunggu", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog , int which){
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
            dialog.setTitle("Konfirmasi Simpan");
            dialog.show();
    }
}
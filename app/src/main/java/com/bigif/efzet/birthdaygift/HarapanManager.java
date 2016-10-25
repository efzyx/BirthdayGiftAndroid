package com.bigif.efzet.birthdaygift;

import android.app.Notification;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by efzet on 14/10/2016.
 */

public class HarapanManager extends MainActivity{
    private static HarapanManager ref=null;
    public static HarapanManager getInstance(){
        if(ref==null) {
            ref=new HarapanManager();
        }
        return ref;
    }

    public void tulisHarapan( EditText et, Context ctx){
        String harapan=et.getText().toString();
        String namaFile="harapan";

        try {
            FileOutputStream fos= ctx.openFileOutput(namaFile,Context.MODE_PRIVATE);

            fos.write(harapan.getBytes());
            fos.close();
            Toast.makeText(ctx,"Harapan Berhasil Disimpan !",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void bacaHarapan(TextView tv, Context ctx){
        try {
            String harapan;
            FileInputStream fis =ctx.openFileInput("harapan");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();

            while ((harapan=br.readLine())!=null){
                sb.append(harapan + "\n");

            }
            tv.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String adaHarapan(Context c){
        try {
            String hr=null;
            FileInputStream fis =c.openFileInput("harapan");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            if((br.readLine())!=null) {
                hr= sb.toString();
            }
            return hr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

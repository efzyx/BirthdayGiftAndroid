package com.bigif.efzet.birthdaygift;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by efzet on 13/10/2016.
 */

public class PengaturMusik {

    private static PengaturMusik ref=null;
    public static PengaturMusik getInstance(){
        if(ref==null) {
            ref=new PengaturMusik();
        }
        return ref;
    }

    MediaPlayer m;
    public void initializeMusicPlayer(Context c, int musicID){

        m = MediaPlayer.create(c, musicID);
        m.start();
    }

    public void putarUlang(Context c, int musicID){

        m = MediaPlayer.create(c, musicID);
        m.start();
        m.setLooping(true);
    }

    public void pause(){

        m.pause();
    }

    public void stop(){

        m.stop();

    }

    public void release(){
        m.release();
    }
}

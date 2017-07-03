package andrewnguyen.polytopmockup;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import andrewnguyen.polytopmockup.Tab_Fragments.Global;

public class New_Device extends AppCompatActivity {

    WebView splash_animation;
    Global global;
    private static int TIME_OUT = 5000; //Time to launch the another activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.scanning);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.power);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.detected);
        global = new Global();
        splash_animation =(WebView) findViewById(R.id.splash_animation);
        WebSettings web_settings = splash_animation.getSettings();
        web_settings.setJavaScriptEnabled(true);

        //****STEFFEN - HERE IS THE URL TO THE BLUETOOTH HTML UNDER ASSETS FOLDER DIRECTORY
        splash_animation.loadUrl("file:///android_asset/bluetooth.html");
        mp.start();
        mp2.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(New_Device.this, Device_Found.class);
                startActivity(i);
                mp4.start();
                finish();
            }
        }, TIME_OUT);
    }
}
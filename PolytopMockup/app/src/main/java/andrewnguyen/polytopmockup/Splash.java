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

import andrewnguyen.polytopmockup.Data.List_Item;
import andrewnguyen.polytopmockup.Tab_Fragments.Global;

public class Splash extends AppCompatActivity {

    WebView splash_animation;
    List_Item fake_device_1, fake_device_2;
    Global global;
    private static int TIME_OUT = 5000; //Time to launch the another activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.power);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.welcome);
        mp.start();
        global = new Global();
        splash_animation =(WebView) findViewById(R.id.splash_animation);
        WebSettings web_settings = splash_animation.getSettings();
        web_settings.setJavaScriptEnabled(true);
        splash_animation.loadUrl("file:///android_asset/index.html");

        fake_device_1 = new List_Item();
        fake_device_2 = new List_Item();

        fake_device_1.setName("Model A");
        fake_device_1.setStatus("OK");
        fake_device_1.setPrice_audio("0.6");
        fake_device_1.setPrice_video("1.8");
        fake_device_1.setPrice_radio("1.2");
        fake_device_1.setAmount_audio((".80"));
        fake_device_1.setAmount_radio(("1.0"));
        fake_device_1.setAmount_video(("1.2"));
        fake_device_1.setAudio("ON");
        fake_device_1.setVideo("ON");
        fake_device_1.setRadio("ON");

        fake_device_2.setName("Model B");
        fake_device_2.setStatus("BAD");
        fake_device_2.setPrice_audio("0");
        fake_device_2.setPrice_video("0");
        fake_device_2.setPrice_radio("1.2");
        fake_device_2.setAmount_audio(("0"));
        fake_device_2.setAmount_radio(("1.4"));
        fake_device_2.setAmount_video(("0"));
        fake_device_2.setAudio("0");
        fake_device_2.setVideo("0");
        fake_device_2.setRadio("ON");

        global.addDevice_toList(fake_device_1);
        global.addDevice_toList(fake_device_2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, Main_Activity.class);
                startActivity(i);
                mp2.start();
                finish();
            }
        }, TIME_OUT);
    }
}

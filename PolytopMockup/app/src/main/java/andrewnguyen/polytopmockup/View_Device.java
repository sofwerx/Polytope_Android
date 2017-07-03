package andrewnguyen.polytopmockup;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import andrewnguyen.polytopmockup.Data.List_Item;
import andrewnguyen.polytopmockup.Tab_Fragments.Global;

public class View_Device extends AppCompatActivity {
    private final String EXTRA_NAME = "NAME",
            EXTRA_STATUS = "STATUS",
            EXTRA_RADIO="RADIO",
            EXTRA_AUDIO = "AUDIO",
            EXTRA_VIDEO = "VIDEO",
            EXTRA_AMOUNT_AUDIO = "AMOUNT_AUDIO",
            EXTRA_AMOUNT_VIDEO = "AMOUNT_VIDEO",
            EXTRA_AMOUNT_RADIO = "AMOUNT_RADIO",
            EXTRA_PRICE_AUDIO = "PRICE_AUDIO",
            EXTRA_PRICE_VIDEO = "PRICE_VIDEO",
            EXTRA_PRICE_RADIO = "PRICE_RADIO",
            BUNDLE_EXTRAS ="DEVICE_DETAILS";
    TextView total, audio_tag, radio_tag, video_tag;
    EditText video_price, audio_price, radio_price, name;
    ImageView radio_switch, audio_switch, video_switch, radio_image, audio_image, video_image;
    String name_str, status, radio, audio, video, amount_audio, amount_video, amount_radio, price_audio, price_video, price_radio, total_str, vid_price_f, aud_price_f, rad_price_f;
    double total_doub;
    Global global;
    private List<List_Item> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__device);
        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);
        global = new Global();
        name = (EditText) findViewById(R.id.name_et);
        audio_price = (EditText) findViewById(R.id.audio_price);
        radio_price = (EditText) findViewById(R.id.radio_price);
        video_price = (EditText) findViewById(R.id.video_price);
        audio_tag = (TextView) findViewById(R.id.audio_tag);
        radio_tag = (TextView) findViewById(R.id.radio_tag);
        video_tag = (TextView) findViewById(R.id.video_tag);
        total = (TextView) findViewById(R.id.total_tv);
        radio_switch = (ImageView) findViewById(R.id.radio_switch);
        audio_switch = (ImageView) findViewById(R.id.audio_switch);
        video_switch = (ImageView) findViewById(R.id.video_switch);
        radio_image = (ImageView) findViewById(R.id.radio_image);
        audio_image = (ImageView) findViewById(R.id.audio_image);
        video_image = (ImageView) findViewById(R.id.video_image);
        name.setHint(extras.get(EXTRA_NAME).toString());
        final String name_final = extras.get(EXTRA_NAME).toString();
        final String radio_price_final = extras.get(EXTRA_PRICE_RADIO).toString();
        final String audio_price_final = extras.get(EXTRA_PRICE_AUDIO).toString();
        final String video_price_final = extras.get(EXTRA_PRICE_VIDEO).toString();
        radio = extras.get(EXTRA_RADIO).toString();
        audio = extras.get(EXTRA_AUDIO).toString();
        video = extras.get(EXTRA_VIDEO).toString();
        amount_radio = extras.get(EXTRA_AMOUNT_RADIO).toString();
        amount_audio= extras.get(EXTRA_AMOUNT_AUDIO).toString();
        amount_video = extras.get(EXTRA_AMOUNT_VIDEO).toString();
        price_audio = extras.get(EXTRA_PRICE_AUDIO).toString();
        price_video = extras.get(EXTRA_PRICE_VIDEO).toString();
        price_radio = extras.get(EXTRA_PRICE_RADIO).toString();
        status = extras.get(EXTRA_STATUS).toString();
        name_str=name.getHint().toString();

        audio_price.setHint(price_audio);
        video_price.setHint(price_video);
        radio_price.setHint(price_radio);
        vid_price_f=video_price_final;
        aud_price_f=audio_price_final;
        rad_price_f=radio_price_final;

        total_doub = Double.parseDouble(amount_audio)+Double.parseDouble(amount_video)+Double.parseDouble(amount_radio);
        total_str = Double.toString(total_doub);
        total.setText(total_str + " USD");

        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    name.setHint("");
                else
                    name.setHint(name_final);
            }
        });
        audio_price.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    audio_price.setHint("");
                else
                    audio_price.setHint(audio_price_final);
            }
        });
        video_price.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    video_price.setHint("");
                else
                    video_price.setHint(video_price_final);
            }
        });
        radio_price.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    radio_price.setHint("");
                else
                    radio_price.setHint(radio_price_final);
            }
        });

        if(audio.equals("ON")){
            audio_text_on();
        }
        else{
            audio_text_off();
        }
        if(radio.equals("ON")){
            radio_text_on();
        }
        else{
            radio_text_off();
        }
        if(video.equals("ON")){
            video_text_on();
        }
        else{
            video_text_off();
        }
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(this, Main_Activity.class);
        startActivity(i);
        finish();
    }
    public void submitChanges(View view){
        List_Item item = new List_Item();
        if(audio.equals("ON")){
            if(audio_price.getText().toString() == null || audio_price.getText().toString().isEmpty()) {
                price_audio=aud_price_f;
            }
            else {
                price_audio = audio_price.getText().toString();
            }
        }
        else{
            price_audio="0";
        }
        if(video.equals("ON")){
            video = "ON";
            if(video_price.getText().toString() == null || video_price.getText().toString().isEmpty()) {
                price_video=vid_price_f;
            }
            else {
                price_video = video_price.getText().toString();
            }
        }
        else{
            price_video="0";
        }
        if(radio.equals("ON")){
            if(radio_price.getText().toString() == null || radio_price.getText().toString().isEmpty()) {
                price_radio=rad_price_f;
            }
            else {
                price_radio = radio_price.getText().toString();
            }
        }
        else{
            price_radio="0";
        }
        listData = global.getDevice_list();
        if(name.getText().toString()!=null && !name.getText().toString().isEmpty()) {

            for(int i = 0; i<listData.size(); i++){
                if(name.getText().toString().equals(listData.get(i).getName())){
                    Toast.makeText(this, "Device name is a duplicate, please rename",
                            Toast.LENGTH_LONG).show();
                    return;
                }
            }

            for(int i = 0; i<listData.size(); i++){
                if(name_str.equals(listData.get(i).getName())){
                    System.out.println("REMOVED ***** " + listData.get(i).getName());
                    listData.remove(i);
                }
            }

            name_str = name.getText().toString();
        }

        item.setAudio(audio);
        item.setPrice_audio(price_audio);
        item.setVideo(video);
        item.setPrice_video(price_video);
        item.setRadio(radio);
        item.setPrice_radio(price_radio);
        item.setStatus(status);
        item.setAmount_audio(amount_audio);
        item.setAmount_radio(amount_radio);
        item.setAmount_video(amount_video);
        item.setName(name_str);
        for(int i = 0; i<listData.size(); i++){
            if(name_str.equals(listData.get(i).getName())){
                System.out.println("REMOVED ***** " + listData.get(i).getName());
                listData.remove(i);
            }
        }
        listData.add(item);
        global.setDevice_list(listData);
        onBackPressed();
    }

    private String toggle_status(String device, String tag){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.swtch);
        if(device.equals("ON")){
            device = "OFF";
            toggle_image_off(tag);
            mp.start();
        }
        else{
            device= "ON";
            toggle_image_on(tag);
            mp.start();
        }
        return device;
    }
    private void toggle_image_on(String tag){
        if(tag.equals("radio")){
            radio_text_on();
        }
        if(tag.equals("audio")){
            audio_text_on();
        }
        if(tag.equals("video")){
            video_text_on();
        }
    }
    private void toggle_image_off(String tag){
        if(tag.equals("radio")){
            radio_text_off();
        }
        if(tag.equals("audio")){
            audio_text_off();
        }
        if(tag.equals("video")){
            video_text_off();
        }
    }

    private void audio_text_on(){
        audio_image.setImageResource(R.drawable.audios_on);
        audio_price.setTextColor(getResources().getColor(R.color.green_on));
        audio_price.setHintTextColor(getResources().getColor(R.color.green_on));
        audio_tag.setTextColor(getResources().getColor(R.color.green_on));
        audio_switch.setImageResource(R.drawable.on_switch);
    }
    private void radio_text_on(){
        radio_image.setImageResource(R.drawable.radio_on);
        radio_price.setHintTextColor(getResources().getColor(R.color.green_on));
        radio_price.setTextColor(getResources().getColor(R.color.green_on));
        radio_tag.setTextColor(getResources().getColor(R.color.green_on));
        radio_switch.setImageResource(R.drawable.on_switch);
    }
    private void video_text_on(){
        video_image.setImageResource(R.drawable.video_on);
        video_price.setTextColor(getResources().getColor(R.color.green_on));
        video_price.setHintTextColor(getResources().getColor(R.color.green_on));
        video_tag.setTextColor(getResources().getColor(R.color.green_on));
        video_switch.setImageResource(R.drawable.on_switch);
    }
    private void audio_text_off(){
        audio_image.setImageResource(R.drawable.audios_off);
        audio_price.setTextColor(getResources().getColor(R.color.red_off));
        audio_price.setHintTextColor(getResources().getColor(R.color.red_off));
        audio_tag.setTextColor(getResources().getColor(R.color.red_off));
        audio_switch.setImageResource(R.drawable.off_switch);
    }
    private void radio_text_off(){
        radio_image.setImageResource(R.drawable.radio_off);
        radio_price.setTextColor(getResources().getColor(R.color.red_off));
        radio_price.setHintTextColor(getResources().getColor(R.color.red_off));
        radio_tag.setTextColor(getResources().getColor(R.color.red_off));
        radio_switch.setImageResource(R.drawable.off_switch);
    }
    private void video_text_off(){
        video_image.setImageResource(R.drawable.video_off);
        video_price.setTextColor(getResources().getColor(R.color.red_off));
        video_price.setHintTextColor(getResources().getColor(R.color.red_off));
        video_tag.setTextColor(getResources().getColor(R.color.red_off));
        video_switch.setImageResource(R.drawable.off_switch);
    }

    public void radio_toggle(View view){
        radio = toggle_status(radio, "radio");
    }
    public void audio_toggle(View view){
        audio = toggle_status(audio, "audio");
    }
    public void video_toggle(View view){
        video = toggle_status(video, "video");
    }
}

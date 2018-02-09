package com.example.dell.texttospeechdemo;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    EditText editText;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    result=textToSpeech.setLanguage(Locale.ENGLISH);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Feature Not Supported",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onSpeakClick(View view) {
        if(result==TextToSpeech.LANG_NOT_SUPPORTED || result==TextToSpeech.LANG_MISSING_DATA){
            Toast.makeText(getApplicationContext(),"Feature Not Supported",Toast.LENGTH_SHORT).show();
        }
        else{
            textToSpeech.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        }
    }
}

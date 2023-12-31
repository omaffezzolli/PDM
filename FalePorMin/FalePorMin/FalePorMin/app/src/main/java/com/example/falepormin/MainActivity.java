package com.example.falepormin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    EditText texto;
    Button falar;
    Auxiliar txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.editText);
        falar = findViewById(R.id.button);

        txt = new Auxiliar(this);
        falar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = texto.getText().toString();
                if (!text.isEmpty()) {
                    txt.speak(text);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

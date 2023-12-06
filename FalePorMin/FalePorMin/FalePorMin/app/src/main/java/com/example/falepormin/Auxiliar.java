package com.example.falepormin;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class Auxiliar implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    boolean loaded = false;

    public Auxiliar(Context context) {
        tts = new TextToSpeech(context, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.US);
            loaded = true;
        } else {
            Log.d("TTS", "Sintetizador de voz não disponível ou configurado.");
        }
    }

    public void speak(String text) {
        if (loaded) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            Log.e("TTS", "Sintetizador de voz não carregado ainda.");
        }
    }
}

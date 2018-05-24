package com.example.got.fictions

import android.media.AudioManager
import android.os.Build
import com.example.got.fictions.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import kotlinx.android.synthetic.main.activity_book_details.*
import java.util.*

class BookDetails : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var tts : TextToSpeech? = null
    private var readAloud : Button? = null
    private var numeric = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        tts = TextToSpeech(this, this)

        val bundle = intent.extras

        bookName.text = bundle.getString("name")
        bookDetails.text = bundle.getString("description")

        readAloud = this.read
        readAloud!!.isEnabled = false

        readAloud!!.setOnClickListener {
            var text = bookDetails.text.toString()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            } else {
                val hash = HashMap<String, String>()
                hash.put(TextToSpeech.Engine.KEY_PARAM_STREAM,
                        AudioManager.STREAM_NOTIFICATION.toString())
                tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, hash)
            }
        }

        changeTextSize.setOnClickListener{
            numeric = textSize.text.matches("-?\\d+(\\.\\d+)?".toRegex())
            if(numeric) {
                bookDetails.setTextSize(textSize.text.toString().toFloat())
            }
        }
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)
            if(result != TextToSpeech.LANG_MISSING_DATA ||
                    result != TextToSpeech.LANG_NOT_SUPPORTED) {
                readAloud!!.isEnabled = true
            }
        }
    }

    public override fun onDestroy() {
        if(tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

}
package com.example.sendinginformationfromactivitytoactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        var extraText = intent.getStringExtra("text")
        val number = findViewById<TextView>(R.id.number)
        val inc = findViewById<Button>(R.id.inc)
        val dec = findViewById<Button>(R.id.dec)
        number.text = extraText
        inc.setOnClickListener {
            var ans = number.text.toString().toInt()
            ans--
            number.text = ans.toString()
        }
        dec.setOnClickListener {
            val intent = Intent()
            intent.putExtra("extraText", number.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()   // էքթիվիթի1-ում տեքստը չի փոխում , բայց չեմ կարողանում սխալը գտնել
        }
    }
}
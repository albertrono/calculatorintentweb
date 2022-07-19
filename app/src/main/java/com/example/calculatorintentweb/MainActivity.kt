package com.example.calculatorintentweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculatorintentweb.activity_web

class MainActivity : AppCompatActivity() {
    var buttoncalc:Button ?= null
    var buttonintent:Button ?= null
    var buttonweb:Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttoncalc=findViewById(R.id.btn_calc)
        buttoncalc!!.setOnClickListener {
            val intent= Intent(this,activity_calc::class.java)
            startActivity(intent)
        }
        buttonintent=findViewById(R.id.btn_intent)
        buttonintent!!.setOnClickListener {
            val intent= Intent(this,activity_intent::class.java)
            startActivity(intent)
        }
        buttonweb=findViewById(R.id.btn_web)
        buttonweb!!.setOnClickListener {
            val intent= Intent(this, activity_web::class.java)
            startActivity(intent)
        }
    }
}
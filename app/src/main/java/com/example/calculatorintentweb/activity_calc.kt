package com.example.calculatorintentweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class activity_calc : AppCompatActivity() {
    lateinit var firstno:EditText
    lateinit var secondno:EditText
    lateinit var btn_add:Button
    lateinit var btn_subtract:Button
    lateinit var btn_multiply:Button
    lateinit var btn_divide:Button
    lateinit var text_answer:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        btn_add=findViewById(R.id.btn_add)
        btn_subtract=findViewById(R.id.btn_subtract)
        btn_multiply=findViewById(R.id.btn_multiply)
        btn_divide=findViewById(R.id.btn_divide)
        firstno=findViewById(R.id.edit_num1)
        secondno=findViewById(R.id.edit_num2)
        text_answer=findViewById(R.id.txt_ans)

        btn_add!!.setOnClickListener {
            var firstno = firstno.text.toString()
            var secondno = secondno.text.toString()

            if (firstno.isEmpty() && secondno.isEmpty() || firstno.isEmpty() || secondno.isEmpty()){
                text_answer.text="fill first number and second number"
            }else{
                var answer=firstno.toDouble() + secondno.toDouble()
                text_answer.text=answer.toString()
            }
        }

        btn_subtract!!.setOnClickListener {
            var firstno = firstno.text.toString()
            var secondno = secondno.text.toString()

            if (firstno.isEmpty() && secondno.isEmpty() || firstno.isEmpty() || secondno.isEmpty()){
                text_answer.text.toString()
            }else{
                var answer=firstno.toDouble() - secondno.toDouble()
                text_answer.text=answer.toString()
            }
        }
        btn_multiply!!.setOnClickListener {
            var firstno = firstno.text.toString()
            var secondno = secondno.text.toString()

            if (firstno.isEmpty() && secondno.isEmpty() || firstno.isEmpty() || secondno.isEmpty()){
                text_answer.text.toString()
            }else{
                var answer=firstno.toDouble() * secondno.toDouble()
                text_answer.text=answer.toString()
            }
        }
        btn_divide!!.setOnClickListener {
            var firstno = firstno.text.toString()
            var secondno = secondno.text.toString()

            if (firstno.isEmpty() && secondno.isEmpty() || firstno.isEmpty() || secondno.isEmpty()){
                text_answer.text.toString()
            }else{
                var answer=firstno.toDouble() / secondno.toDouble()
                text_answer.text=answer.toString()
            }
        }
    }
}
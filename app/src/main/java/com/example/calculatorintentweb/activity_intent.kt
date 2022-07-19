package com.example.calculatorintentweb

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest


class activity_intent : AppCompatActivity() {
    var button_sms: Button? = null
    var button_calls: Button? = null
    var button_mail: Button? = null
    var button_camera: Button? = null
    var button_stk: Button? = null
    var button_dial: Button? = null
    var button_share: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        button_sms = findViewById(R.id.btn_sms)
        button_calls = findViewById(R.id.btn_calls)
        button_mail = findViewById(R.id.btn_email)
        button_camera = findViewById(R.id.btn_camera)
        button_stk = findViewById(R.id.btn_stk)
        button_dial = findViewById(R.id.btn_dial)
        button_share = findViewById(R.id.btn_share)

        button_sms!!.setOnClickListener {
            val uri = Uri.parse("smsto:+254789773665")
            var intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("hello", "good morning")
            startActivity(intent)
        }

        button_calls!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254789773665"))

            if (ContextCompat.checkSelfPermission(
                    this@activity_intent,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@activity_intent,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

        button_mail!!.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "alberitorono9017@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        button_camera!!.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)

            startActivityForResult(takePictureIntent, 1)
        }

        button_stk!!.setOnClickListener {
            var simToolKitLaunchIntent = getApplicationContext().getPackageManager()
                .getLaunchIntentForPackage("com.android.stk");

            if (simToolKitLaunchIntent != null) {

                startActivity(simToolKitLaunchIntent);
            }
        }
        button_dial!!.setOnClickListener {
            val phone = "+254789773665"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)
        }

        button_share!!.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)
        }

    }
}
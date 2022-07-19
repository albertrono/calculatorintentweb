package com.example.calculatorintentweb

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class activity_web : AppCompatActivity() {
    lateinit var web_view:WebView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        web_view=findViewById(R.id.weeeeb)
        webview()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webview(){
        web_view.webViewClient= WebViewClient()

        web_view?.apply {
            loadUrl("https://www.google.com/")
            settings.safeBrowsingEnabled=true
            settings.javaScriptEnabled=true
        }
    }

    override fun onBackPressed() {
        if (web_view.canGoBack())web_view.goBack()else
        super.onBackPressed()
    }
}
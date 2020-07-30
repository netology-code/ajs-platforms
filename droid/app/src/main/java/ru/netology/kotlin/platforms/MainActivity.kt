package ru.netology.kotlin.platforms

import android.content.Context
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webview.loadUrl("https://netology-code.github.io/ajs-platforms/")
        webview.settings.javaScriptEnabled = true
        webview.addJavascriptInterface(WebAppIntegration(this), "Android")
    }
}

class WebAppIntegration(private val context: Context) {
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show()
    }
}
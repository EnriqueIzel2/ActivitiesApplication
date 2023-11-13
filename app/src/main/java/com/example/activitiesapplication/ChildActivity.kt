package com.example.activitiesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ChildActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_child)

    val newIntent = intent
    val textView: TextView = findViewById(R.id.textView)

    if (newIntent.hasExtra(Intent.EXTRA_TEXT)) {
      val personName = newIntent.getStringExtra(Intent.EXTRA_TEXT)
      textView.text = personName
    }
  }
}
package com.example.activitiesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

  private lateinit var editTextPersonName: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    editTextPersonName = findViewById(R.id.editTextPersonName)
    val button: Button = findViewById(R.id.button)

    button.setOnClickListener {
      openChildActivity()

    }
  }

  private fun openChildActivity() {
    val personName: String = editTextPersonName.text.toString()
    Log.e("Main Activity", "setOnClickListener $personName")

    val intent = Intent(this, ChildActivity::class.java)
    intent.putExtra(Intent.EXTRA_TEXT, personName)
    startActivity(intent)
  }
}
package com.example.activitiesapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ShareCompat

class ChildActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_child)

    val newIntent = intent
    val textView: TextView = findViewById(R.id.textView)
    val buttonOpenWebPage: Button = findViewById(R.id.btn_open_webPage)
    val buttonOpenMap: Button = findViewById(R.id.btn_open_map)
    val buttonShareText: Button = findViewById(R.id.btn_share_text)

    if (newIntent.hasExtra(Intent.EXTRA_TEXT)) {
      val personName = newIntent.getStringExtra(Intent.EXTRA_TEXT)
      textView.text = getString(R.string.web_page_text, personName)
    }

    buttonOpenWebPage.setOnClickListener {
      openWebPage()
    }

    buttonOpenMap.setOnClickListener {
      openMap()
    }

    buttonShareText.setOnClickListener {
      shareText()
    }
  }

  private fun openWebPage() {
    val url = "https://ge.globo.com/"
    val uri = Uri.parse(url)

    val intent = Intent(Intent.ACTION_VIEW, uri)
    startActivity(intent)
  }

  private fun openMap() {
    val address = "1600 Amphitheatre Parkway, CA"

    val builder = Uri.Builder()
    builder.scheme("geo")
      .path("0,0")
      .appendQueryParameter("q", address)

    val uri = builder.build()
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setData(uri)

    startActivity(intent)
  }

  private fun shareText() {
    val textToShare = "Texto de exemplo para envio"
    val mimeType = "text/plain"

    ShareCompat
      .IntentBuilder(this)
      .setChooserTitle("Exemplo de envio")
      .setType(mimeType)
      .setText(textToShare)
      .startChooser()
  }
}
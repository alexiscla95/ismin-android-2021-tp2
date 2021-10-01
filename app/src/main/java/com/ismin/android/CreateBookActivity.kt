package com.ismin.android


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.ismin.androidtp1.Book

const val EXTRA_KEY = "extra-key"

class CreateBookActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_create_book)
  }

  fun saveBook(view: View) {
    val author = findViewById<EditText>(R.id.authorInput).text.toString()
    val title = findViewById<EditText>(R.id.titleInput).text.toString()
    val date = findViewById<EditText>(R.id.dateInput).text.toString()

    val book: Book = Book(title, author, date)

    val returnIntent = Intent()
    returnIntent.putExtra(EXTRA_KEY, book)
    setResult(Activity.RESULT_OK, returnIntent)
    finish()

  }
}
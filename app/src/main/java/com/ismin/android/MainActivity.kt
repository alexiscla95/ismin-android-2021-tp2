package com.ismin.android
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.EditText


import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ismin.androidtp1.Book
import com.ismin.androidtp1.Bookshelf

class MainActivity : AppCompatActivity() {
    private var bookshelf: Bookshelf = Bookshelf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val someData = result.data?.getSerializableExtra(EXTRA_KEY)
            bookshelf.addBook(someData as Book)

            findViewById<TextView>(R.id.authorText).text = someData.author
            findViewById<TextView>(R.id.titleText).text = someData.title
            findViewById<TextView>(R.id.dateText).text = someData.date

        }
    }

    fun goToCreation(view: View) {
        val intent = Intent(this, CreateBookActivity::class.java)
        startForResult.launch(intent)
    }


    fun addBook() {

    }
}
package com.example.mynotepad_ignatenko_32is_21

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText

class NoteActivity : AppCompatActivity() {
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        editText = findViewById(R.id.noteEditText)
    }
}

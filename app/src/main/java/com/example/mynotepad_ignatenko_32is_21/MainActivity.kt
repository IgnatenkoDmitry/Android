package com.example.mynotepad_ignatenko_32is_21

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.app.AlertDialog
import android.widget.EditText
import android.widget.Button
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: NoteAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager


    private var myNotes: MutableList<Note> = mutableListOf(
        Note("Заметка 1", "Это содержание заметки 1"),
        Note("Заметка 2", "Это содержание заметки 2"),
        Note("Заметка 3", "Это содержание заметки 3"),
        Note("Заметка 4", "Это содержание заметки 4"),
        Note("Заметка 5", "Это содержание заметки 5"),
        Note("Заметка 6", "Это содержание заметки 6"),
        Note("Заметка 7", "Это содержание заметки 7"),
        Note("Заметка 8", "Это содержание заметки 8"),
        Note("Заметка 9", "Это содержание заметки 9"),
        Note("Заметка 10", "Это содержание заметки 10")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = NoteAdapter(myNotes)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val addNoteButton: Button = findViewById(R.id.addNoteButton)
        addNoteButton.setOnClickListener {
            showAddNoteDialog()
        }
    }

    private fun showAddNoteDialog() {
        val titleEditText = EditText(this)
        titleEditText.hint = "Название заметки"
        val contentEditText = EditText(this)
        contentEditText.hint = "Содержание заметки"
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.addView(titleEditText)
        layout.addView(contentEditText)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Добавить заметку")
            .setView(layout)
            .setPositiveButton("Добавить") { _, _ ->
                val title = titleEditText.text.toString()
                val content = contentEditText.text.toString()
                val note = Note(title, content)
                myNotes.add(note)
                viewAdapter.notifyItemInserted(myNotes.size - 1)
            }
            .setNegativeButton("Отмена", null)
            .create()

        dialog.show()
    }

}
package com.example.mynotepad_ignatenko_32is_21
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AlertDialog

class NoteAdapter(private val notes: MutableList<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val noteTitle: TextView = view.findViewById(R.id.noteTitle)
        val noteContent: TextView = view.findViewById(R.id.noteContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.noteTitle.text = note.title
        holder.noteContent.text = note.content

        // Добавляем слушатель долгого нажатия
        holder.view.setOnLongClickListener {
            // Показываем диалоговое окно для подтверждения удаления
            AlertDialog.Builder(it.context)
                .setTitle("Удалить заметку")
                .setMessage("Вы уверены, что хотите удалить эту заметку?")
                .setPositiveButton("Удалить") { _, _ ->
                    notes.removeAt(position)
                    notifyItemRemoved(position)
                }
                .setNegativeButton("Отмена", null)
                .show()

            true
        }
    }

    override fun getItemCount() = notes.size
}



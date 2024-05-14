package com.example.mynotesapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mynotesapplication.databinding.ActivityAddNotesBinding
import com.example.mynotesapplication.databinding.ActivityMainBinding

class AddNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var db: NoteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabase(this)

        binding.saveNote.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.descriptionEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Saved", Toast.LENGTH_SHORT).show()
        }

    }
}
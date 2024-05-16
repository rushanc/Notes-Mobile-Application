package com.example.mynotesapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotesapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: NoteDatabase
    private lateinit var noteAdapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabase(this)
        noteAdapter = NoteAdapter(db.getAllNotes(),this)

        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        binding.RecyclerView.adapter = noteAdapter

        binding.AddButton.setOnClickListener{
            val intent = Intent(this, AddNotesActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        noteAdapter.refreshData(db.getAllNotes())
    }
}
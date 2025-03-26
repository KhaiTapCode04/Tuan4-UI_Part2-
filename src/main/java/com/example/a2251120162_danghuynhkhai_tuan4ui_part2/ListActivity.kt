package com.example.a2251120162_danghuynhkhai_tuan4ui_part2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a2251120162_danghuynhkhai_tuan4ui_part2.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Thiết lập tiêu đề trên ActionBar
        supportActionBar?.title = "LazyColumn"
        // Hiển thị nút Back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Tạo danh sách 1.000.000 câu trích dẫn (có thể giảm bớt số lượng)
        val quotes = List(100) { "The only way to do great work is to love what you do." }  // Reduced for demo purposes

        // Sử dụng custom adapter
        val adapter = QuoteAdapter(this, quotes)
        binding.listView.adapter = adapter

        // Xử lý sự kiện khi nhấn vào một item
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("QUOTE", quotes[position])
            startActivity(intent)
        }
    }

    // Xử lý sự kiện khi nhấn nút Back trên ActionBar
    override fun onSupportNavigateUp(): Boolean {
        finish() // Quay lại Activity trước đó (MainActivity)
        return true
    }
}
package com.example.a2251120162_danghuynhkhai_tuan4ui_part2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a2251120162_danghuynhkhai_tuan4ui_part2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail"
        // Hiển thị nút Back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Lấy dữ liệu từ Intent
        val quote = intent.getStringExtra("QUOTE") ?: ""
        binding.quoteText.text = "\"$quote\""

        // Xử lý nút "BACK TO ROOT"
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }

    // Xử lý sự kiện khi nhấn nút Back trên ActionBar
    override fun onSupportNavigateUp(): Boolean {
        finish() // Quay lại Activity trước đó (ListActivity)
        return true
    }
}
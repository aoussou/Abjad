package com.talisol.abjad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.talisol.abjad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btn = binding.button
        var textView = binding.textView
        val map = AbjadMapping.map

        val letterList = mutableListOf<Letter>()

        btn.setOnClickListener {
            var arabic = binding.inputArabic.text.toList()
            var total = 0

            for (item in arabic){

                var abjadValue =  map.get(item.toString())
                letterList.add(Letter(item.toString(),abjadValue.toString()))

                total += map.get(item.toString())!!
            }

            val adapter = LetterAdapter(letterList)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            textView.text = total.toString()
        }

    }
}
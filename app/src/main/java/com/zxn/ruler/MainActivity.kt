package com.zxn.ruler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zxn.ruler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        binding.rulerView.run {
            mMax = 2000
            mMin = 0
            currentValue = "10"
            setOnValueChangedListener {
                binding.tvVolume.text = "${it.toFloat().toInt()} ml"
            }
        }

        binding.ivReduceVolume.setOnClickListener {
            if (binding.rulerView.currentValue.toFloat()
                    .toInt() == binding.rulerView.mMin
            ) return@setOnClickListener
            binding.rulerView.currentValue = (binding.rulerView.currentValue.toFloat() - 10).toString().also {
                binding.tvVolume.text = "${it.toFloat().toInt()} ml"
            }
        }
        binding.ivAddVolume.setOnClickListener {
            if (binding.rulerView.currentValue.toFloat()
                    .toInt() == binding.rulerView.mMax
            ) return@setOnClickListener
            binding.rulerView.currentValue = (binding.rulerView.currentValue.toFloat() + 10).toString().also {
                binding.tvVolume.text = "${it.toFloat().toInt()} ml"
            }
        }
    }
}
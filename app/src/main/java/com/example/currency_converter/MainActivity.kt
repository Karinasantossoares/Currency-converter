package com.example.currency_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Spinner
import android.widget.TextView
import com.example.currency_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnConverter.setOnClickListener { convertCourrency() }
    }

    private fun convertCourrency() {
        var valueEnter = binding.valueConverted.text.toString()
        val replaceTest = valueEnter.replace("," ,".")
        var valueConverted = replaceTest.toDouble()
        var optionRadioGroup = binding.tipOptions.checkedRadioButtonId
        var currencyConverter = when (optionRadioGroup) {
            R.id.tip_option_dollar -> valueConverted *0.18
            else -> valueConverted * 0.15
        }
        binding.tvResult.text = currencyConverter.toString()
    }
}
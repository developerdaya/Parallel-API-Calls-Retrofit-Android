package com.developerdaya.parallel_api_calls_retrofit_android.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.developerdaya.parallel_api_calls_retrofit_android.R
import com.developerdaya.parallel_api_calls_retrofit_android.databinding.ActivityHomeBinding
import com.developerdaya.parallel_api_calls_retrofit_android.ui.view.EmployeesActivity
import com.developerdaya.parallel_api_calls_retrofit_android.ui.view.EmployeesParallelActivity

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mSequenceAPI.setOnClickListener {
            val intent = Intent(this, EmployeesActivity::class.java)
            startActivity(intent)
        }
        binding.mParallelAPI.setOnClickListener {
            val intent = Intent(this, EmployeesParallelActivity::class.java)
            startActivity(intent)
        }
    }
}
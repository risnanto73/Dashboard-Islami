package com.rtid.idnsolo.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtid.idnsolo.dashboardislami.databinding.ActivityDetailListDoaBinding

class ListDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailListDoaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
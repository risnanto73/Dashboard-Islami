
package com.rtid.idnsolo.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtid.idnsolo.dashboardislami.R
import com.rtid.idnsolo.dashboardislami.databinding.ActivityDoaBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar = supportActionBar
        actionBar?.title = "Doa Harian"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
package com.rtid.idnsolo.dashboardislami.sholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.rtid.idnsolo.dashboardislami.databinding.ActivitySholatBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SholatActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySholatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initSholatView()

    }

    private fun initSholatView() {
        val date: Date = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy")
        val today = dateFormat.format(date)

        binding.tvDatePray.text = today

        initGetDataSholat(today, "Jakarta")
    }

    private fun initGetDataSholat(today: String, s: String) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.format(Date())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.rtid.idnsolo.dashboardislami

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rtid.idnsolo.dashboardislami.databinding.ActivityMainBinding
import com.rtid.idnsolo.dashboardislami.doa.DoaActivity
import com.rtid.idnsolo.dashboardislami.inspiration.InspirationData
import com.rtid.idnsolo.dashboardislami.inspiration.InspirationListAdapter
import com.rtid.idnsolo.dashboardislami.inspiration.InspirationModel
import com.rtid.idnsolo.dashboardislami.kajian.KajianActivity
import com.rtid.idnsolo.dashboardislami.zakat.ZakatActivity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecyclerList()
        moveActivity()
        initTimeForSholat()

    }

    private fun initTimeForSholat() {

        val timeNow = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH")
        val time = timeFormat.format(timeNow.time)

        when{
            // 0..6 -> {}
            time.toInt() in 0..5 -> binding.imgHeader.setImageResource(
                R.drawable.bg_header_dashboard_night
            )
            time.toInt() in 6..11 -> binding.imgHeader.setImageResource(
                R.drawable.bg_header_dashboard_morning
            )
            time.toInt() in 12..17 -> binding.imgHeader.setImageResource(
                R.drawable.bg_header_dashboard_afternoon
            )
            time.toInt() in 18..23 -> binding.imgHeader.setImageResource(
                R.drawable.bg_header_dashboard_night
            )
        }
    }

    private fun moveActivity() {
        //move activity
        binding.btnDoa.setOnClickListener {
            startActivity(Intent(this, DoaActivity::class.java))
        }
        binding.btnZakat.setOnClickListener{
            startActivity(Intent(this, ZakatActivity::class.java))
        }
        binding.btnKajian.setOnClickListener{
            startActivity(Intent(this, KajianActivity::class.java))
        }
    }


    private fun showRecyclerList() {
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        val listInspiration = ArrayList<InspirationModel>()
        listInspiration.addAll(InspirationData.listData)
        val listInspirationAdapter = InspirationListAdapter(listInspiration)
        binding.rvInspiration.adapter = listInspirationAdapter
    }

}
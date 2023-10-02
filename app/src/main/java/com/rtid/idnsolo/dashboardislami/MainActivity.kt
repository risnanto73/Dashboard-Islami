package com.rtid.idnsolo.dashboardislami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.rtid.idnsolo.dashboardislami.databinding.ActivityMainBinding
import com.rtid.idnsolo.dashboardislami.doa.DoaActivity
import com.rtid.idnsolo.dashboardislami.inspiration.InspirationData
import com.rtid.idnsolo.dashboardislami.inspiration.InspirationListAdapter
import com.rtid.idnsolo.dashboardislami.inspiration.InspirationModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecyclerList()
        showMenu()

    }

    private fun showMenu() {
        //move activity
        binding.btnDoa.setOnClickListener {
            startActivity(Intent(this, DoaActivity::class.java))
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
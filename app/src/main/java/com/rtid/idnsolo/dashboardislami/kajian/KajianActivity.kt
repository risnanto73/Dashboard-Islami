package com.rtid.idnsolo.dashboardislami.kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.rtid.idnsolo.dashboardislami.R
import com.rtid.idnsolo.dashboardislami.databinding.ActivityKajianBinding
import com.rtid.idnsolo.dashboardislami.kajian.adapter.KajianAdapter
import com.rtid.idnsolo.dashboardislami.kajian.data.KajianData
import com.rtid.idnsolo.dashboardislami.kajian.model.KajianModel

class KajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvKajian.layoutManager = LinearLayoutManager(this)
        binding.rvKajian.setHasFixedSize(true)
        val listKajian = ArrayList<KajianModel>()
        listKajian.addAll(KajianData.listData)
        binding.rvKajian.adapter = KajianAdapter(listKajian)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
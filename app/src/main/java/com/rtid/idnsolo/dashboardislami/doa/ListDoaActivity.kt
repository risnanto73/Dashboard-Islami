package com.rtid.idnsolo.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rtid.idnsolo.dashboardislami.R
import com.rtid.idnsolo.dashboardislami.databinding.ActivityDetailListDoaBinding
import com.rtid.idnsolo.dashboardislami.doa.adapter.DoaListAdapter
import com.rtid.idnsolo.dashboardislami.doa.data.DoaEtikaBaik
import com.rtid.idnsolo.dashboardislami.doa.data.DoaMakananMinuman
import com.rtid.idnsolo.dashboardislami.doa.data.DoaPagiMalam
import com.rtid.idnsolo.dashboardislami.doa.data.DoaPerjalanan
import com.rtid.idnsolo.dashboardislami.doa.data.DoaRumah
import com.rtid.idnsolo.dashboardislami.doa.data.DoaSholat
import com.rtid.idnsolo.dashboardislami.doa.model.DoaModel
import java.util.ArrayList

class ListDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailListDoaBinding
    lateinit var title: String
    var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(EXTRA_TITLE).toString()
        logo = intent.getIntExtra(EXTRA_IMAGE, 0)

        val actionBar = supportActionBar
        actionBar?.title = title
        actionBar?.setDisplayHomeAsUpEnabled(true)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        val list: ArrayList<DoaModel> = arrayListOf()
        when (title) {
            getString(R.string.pagi_dan_malam) -> {
                list.addAll(DoaPagiMalam.listDoaPagiDanMalam)
            }
            getString(R.string.rumah) -> {
                list.addAll(DoaRumah.listDoaRumah)
            }
            getString(R.string.makanan_dan_minuman) -> {
                list.addAll(DoaMakananMinuman.listDoaMakananDanMinuman)
            }
            getString(R.string.perjalanan) -> {
                list.addAll(DoaPerjalanan.listDoaPerjalanan)
            }
            getString(R.string.sholat) -> {
                list.addAll(DoaSholat.listDoaShalatData)
            }
            getString(R.string.etika_baik) -> {
                list.addAll(DoaEtikaBaik.listDoaEtikaBaik)
            }
        }
        binding.rvListDoa.hasFixedSize()
        binding.rvListDoa.layoutManager = LinearLayoutManager(this)
        val adapter = DoaListAdapter(list, title, logo)
        binding.rvListDoa.adapter = adapter
    }
    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_TITLE = "extra_title"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
package com.rtid.idnsolo.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtid.idnsolo.dashboardislami.R
import com.rtid.idnsolo.dashboardislami.databinding.ActivityDetailDoaBinding
import com.rtid.idnsolo.dashboardislami.doa.model.DoaModel

class DetailDoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailDoaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_DOA) as DoaModel
        val actionBar = supportActionBar
        actionBar!!.title = doa.title
        actionBar.setDisplayHomeAsUpEnabled(true)

        binding.tvTitle.text = doa.title
        binding.tvArabic.text = doa.doa
        binding.tvLatin.text = doa.latin
        binding.tvTerjemahan.text = doa.terjemahan
        binding.tvPerawi.text = doa.profile
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
       const val EXTRA_DOA = "extra_doa"
    }
}
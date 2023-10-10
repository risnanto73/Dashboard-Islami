
package com.rtid.idnsolo.dashboardislami.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtid.idnsolo.dashboardislami.R
import com.rtid.idnsolo.dashboardislami.databinding.ActivityDoaBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "Doa Harian"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        intentToListActivity()

    }

    private fun intentToListActivity() {
        binding.cardDoaPagiMalam.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.pagi_dan_malam))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_pagi_malam)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
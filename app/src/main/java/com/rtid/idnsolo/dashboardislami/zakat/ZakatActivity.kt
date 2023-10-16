package com.rtid.idnsolo.dashboardislami.zakat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rtid.idnsolo.dashboardislami.databinding.ActivityZakatBinding
import java.text.NumberFormat
import java.util.Locale


class ZakatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZakatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Zakat"
        actionBar.setDisplayHomeAsUpEnabled(true)

        initHitungZakat()
    }

    private fun initHitungZakat() {
        binding.btnHitung.setOnClickListener {
            var isEmptyField = false
            val emas = 92395000
            val persen = 0.025
            val localeID = Locale("in", "ID")
            val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
            val totalHarta = binding.edtTotalHartaKeseluruhan.text.toString().trim()

            if(totalHarta.isEmpty()) {
                isEmptyField = true
                binding.edtTotalHartaKeseluruhan.error = "Field ini tidak boleh kosong"
            }

            if(!isEmptyField){

                val zakat = totalHarta.toInt() * persen

                if(totalHarta > emas.toString()){
                    binding.tvStatus.text = "Anda wajib membayar zakat"
                    binding.tvZakatYangDikeluarkan.text = formatRupiah.format(zakat.toInt())

                } else {
                    binding.tvStatus.text = "Anda belum wajib zakat"
                    binding.tvZakatYangDikeluarkan.text = "0"
                }

            }
        }
    }
}
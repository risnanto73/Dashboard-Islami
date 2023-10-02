package com.rtid.idnsolo.dashboardislami.inspiration

import com.rtid.idnsolo.dashboardislami.R

object InspirationData {
    private val inspirationImages = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.img_inspiration,
        R.drawable.img_inspiration
    )

    val listData: ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()
            for (position in inspirationImages.indices) {
                val inspiration = InspirationModel()
                inspiration.inspirationImage = inspirationImages[position]
                list.add(inspiration)
            }
            return list
        }


}
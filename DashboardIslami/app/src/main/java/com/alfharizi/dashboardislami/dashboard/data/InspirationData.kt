package com.alfharizi.dashboardislami.dashboard.data

import com.alfharizi.dashboardislami.R
import com.alfharizi.dashboardislami.dashboard.model.InspirationModel

object InspirationData {
    private val inspirationImage = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.img_inspiration
    )

    val listData: ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()
            for (position in inspirationImage.indices) {
                val inspiration = InspirationModel()
                inspiration.InspirationImage = inspirationImage[position]
                list.add(inspiration)
            }
            return list
        }
}
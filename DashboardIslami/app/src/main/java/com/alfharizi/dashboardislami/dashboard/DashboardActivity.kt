package com.alfharizi.dashboardislami.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfharizi.dashboardislami.R
import com.alfharizi.dashboardislami.dashboard.adapter.InspirationListAdapter
import com.alfharizi.dashboardislami.dashboard.data.InspirationData
import com.alfharizi.dashboardislami.dashboard.model.InspirationModel
import com.alfharizi.dashboardislami.databinding.ActivityDashboardBinding
import com.alfharizi.dashboardislami.databinding.ActivityMenuZakatBinding
import com.alfharizi.dashboardislami.menus.doa.MenuDoaActivity
import com.alfharizi.dashboardislami.menus.dzikir.MenuDzikirActivity
import com.alfharizi.dashboardislami.menus.jadwalsholat.MenuJadwalSholatActivity
import com.alfharizi.dashboardislami.menus.videokajian.MenuKajianVideoActivity
import com.alfharizi.dashboardislami.menus.zakat.MenuDzakatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DashboardActivity : AppCompatActivity() {


    // mendaftarkan untuk mengikat layout ke class
    private lateinit var binding: ActivityDashboardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // mendaftarkan layout activity_dashboard.xml
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        // variable view untuk menampung komponen layout
        val view = binding.root
        // menentukan tampilan dengan data yang ada di variable view (binding)
        setContentView(view)

        // memanggil fungsi
        initHeader()
        initRecyclerViewInspiration()
        initNavMenu()
    }

    // fungsi untuk berpindah activity
    private fun initNavMenu() {

        // memberikan perintah klik pada komponen iv_icon_menu_doa
        binding.ivIconMenuDoa.setOnClickListener {
            startActivity(Intent(this, MenuDoaActivity::class.java))
        }
        // memulai activity baru dengan intent sebagai pembawa alamat activity yang ingin dituju
        binding.ivIconMenuDzikir.setOnClickListener {
            startActivity(Intent(this, MenuDzikirActivity::class.java))
        }

        binding.ivIconMenuJadwalSholat.setOnClickListener {
            startActivity(Intent(this, MenuJadwalSholatActivity::class.java))
        }

        binding.ivIconMenuVideoKajian.setOnClickListener {
            startActivity(Intent(this, MenuKajianVideoActivity::class.java))
        }

        binding.ivIconMenuZakat.setOnClickListener {
            startActivity(Intent(this, MenuDzakatActivity::class.java))
        }

    }

    // fungsi untuk menampilkan data dari adapter ke komponen recyclerview
    private fun initRecyclerViewInspiration() {

        // variable list untuk menampung data dari object inspiration Data
        val list: ArrayList<InspirationModel> = arrayListOf()
        // memasukan semua data ke dalam variable list
        list.addAll(InspirationData.listData)

        // membuat object InspirationListAdapter
        val listInspirationListAdapter = InspirationListAdapter(list)

        // mengatur ukuran recyclerview agar fix
        binding.rvInspiration.setHasFixedSize(true)
        // mengatur tampilan recyclerview agar sejarah secara vertical
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        // memasang adapter ke recyclerview
        binding.rvInspiration.adapter = listInspirationListAdapter
    }

    private fun initHeader() {
        //membuat variable yang menampung data waktu
        val timeNow = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH")
        val time = timeFormat.format(timeNow.time)

        when {
            time.toInt() in 0..6 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_night)
            }
            time.toInt() in 7..12 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_morning)
            }
            time.toInt() in 13..18 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_morning)
            }
            time.toInt() in 19..23 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_night)
            }

        }
    }
}


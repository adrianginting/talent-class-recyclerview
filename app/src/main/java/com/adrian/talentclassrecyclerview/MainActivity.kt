package com.adrian.talentclassrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Profile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()

    }
    private fun getListHeroes(): ArrayList<Profile> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataEmail = resources.getStringArray(R.array.data_email)
        val dataMajor = resources.getStringArray(R.array.data_major)
        val dataSemester = resources.getStringArray(R.array.data_semester)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Profile>()
        for (i in dataName.indices) {
            val hero = Profile(dataName[i], dataEmail[i], dataMajor[i], dataSemester[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListProfileAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }
}
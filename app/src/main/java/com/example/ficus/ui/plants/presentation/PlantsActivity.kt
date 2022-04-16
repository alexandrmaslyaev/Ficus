package com.example.ficus.ui.plants.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.example.ficus.R

class PlantsActivity : AppCompatActivity(R.layout.ficus_fragment_container) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            startNavigationGraph()
        }
    }

    private fun startNavigationGraph() {
        val hostFragment = NavHostFragment.create(R.navigation.ficus_graph)
        supportFragmentManager.commit {
            replace(R.id.ficus_content, hostFragment)
            setPrimaryNavigationFragment(hostFragment)
        }
    }
}
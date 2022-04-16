package com.example.ficus.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ficus.ex.openActivity
import com.example.ficus.ui.plants.presentation.PlantsActivity

class LaunchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openActivity<PlantsActivity>()
    }
}
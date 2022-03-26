package com.emotg.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emotg.naturecollection.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Charger de notre repository */
        val repo = PlantRepository()

        /* Injecter le fragment dans notre bpîte (fragment_container) */
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment(this))
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
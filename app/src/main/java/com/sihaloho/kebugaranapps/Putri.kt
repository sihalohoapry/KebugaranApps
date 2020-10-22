package com.sihaloho.kebugaranapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_putri.*

class Putri : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_putri)
        button.setOnClickListener {
            startActivity(Intent(this, DataDiriActivity::class.java))
            finishAffinity()
        }
    }
}

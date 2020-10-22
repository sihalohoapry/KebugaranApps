package com.sihaloho.kebugaranapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sihaloho.kebugaranapps.R
import kotlinx.android.synthetic.main.activity_putra.*

class Putra : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_putra)
        button.setOnClickListener {
            startActivity(Intent(this, Putri::class.java))
        }
    }
}

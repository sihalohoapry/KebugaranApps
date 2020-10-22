package com.sihaloho.kebugaranapps

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result_wanita.*

class ResultWanitaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_wanita)

        tv_nama.text = DataDiriActivity.nama
        tv_umur.text = DataDiriActivity.umur
        textView18.text = DataDiriActivity.sp
        point_hasil.text = InputanTestWanitaActivity.fixHasilAkhir

        val nilaiMutu = Integer.parseInt(InputanTestWanitaActivity.fixHasilAkhir)

        if (nilaiMutu>=90){
            tv_ucapan.text = "Baik Sekali"
        }

        if (nilaiMutu<90){
            tv_ucapan.text = "Baik"
        }

        if (nilaiMutu<80){
            tv_ucapan.text = "Cukup"
        }

        if (nilaiMutu<70){
            tv_ucapan.text = "Kurang"
        }
        if (nilaiMutu<60){
            tv_ucapan.text = "Sangat Kurang"
        }



        exit.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah ingin keluar Aplikasi?")
                .setPositiveButton("Ya", DialogInterface.OnClickListener{ dialogInterfac, i ->
                    Toast.makeText(this, "Terimakasih telah menggunakan aplikasi ini",Toast.LENGTH_SHORT).show()
                    finish()
                })
                .setNegativeButton("Batal",DialogInterface.OnClickListener{dialogInterface, i ->

                }).show()
        }

        btn_test_lagi.setOnClickListener {
            startActivity(Intent(this, InputanTestWanitaActivity::class.java))
            finishAffinity()
        }


    }

    override fun onBackPressed(){
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi")
            .setMessage("Apakah ingin keluar Aplikasi?")
            .setPositiveButton("Ya", DialogInterface.OnClickListener{ dialogInterfac, i ->
                Toast.makeText(this, "Terimakasih telah menggunakan aplikasi ini",Toast.LENGTH_SHORT).show()
                finish()
            })
            .setNegativeButton("Batal",DialogInterface.OnClickListener{dialogInterface, i ->

            }).show()
    }
}

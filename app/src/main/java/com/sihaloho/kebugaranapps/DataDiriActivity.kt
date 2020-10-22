package com.sihaloho.kebugaranapps

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.sihaloho.kebugaranapps.modul.user
import kotlinx.android.synthetic.main.activity_data_diri.*
import java.util.*

class DataDiriActivity : AppCompatActivity() {

    companion object {
        lateinit var nama : String
        lateinit var umur : String
        lateinit var sp : String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_diri)

        btn_simpandatadiri.setOnClickListener {
            simpanDataDiri()
        }

    }

    private fun simpanDataDiri() {
        val progressBar = ProgressDialog(this)
        progressBar.setMessage("Mohon tunggu...")
        progressBar.show()

        sp = spinnerjeniskelamin.selectedItem.toString()

        if (et_nama.text.toString().isEmpty()){
            progressBar.dismiss()
            et_nama.error = "Masukkan Nama Kamu"
            et_nama.requestFocus()
            return
        }
        if (et_usia.text.toString().isEmpty()){
            progressBar.dismiss()
            et_usia.error = "Masukkan Nama Kamu"
            et_usia.requestFocus()
            return
        }
        if (sp.equals("Silahkan diisi")){
            progressBar.dismiss()
            Toast.makeText(this,"Pilih Jenis kelamin", Toast.LENGTH_SHORT).show()
            return
        }


        val uid_peserta = UUID.randomUUID().toString()
        val db = FirebaseDatabase.getInstance().getReference("DataDiriTes/$uid_peserta")


        nama = et_nama.text.toString()
        umur = et_usia.text.toString()


        db.setValue(user(
            uid_peserta,
            nama,
            umur,
            sp
        ))

            .addOnSuccessListener {

                if(sp == "Pria"){
                    progressBar.dismiss()
                    startActivity(Intent(this, InputanTestActivity::class.java))
                    finish()
                }
                if(sp == "Wanita"){
                    progressBar.dismiss()
                    startActivity(Intent(this, InputanTestWanitaActivity::class.java))
                    finish()
                }

            }
            .addOnFailureListener {

            }
    }
}

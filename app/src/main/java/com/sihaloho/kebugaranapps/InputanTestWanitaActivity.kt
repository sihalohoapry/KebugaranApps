package com.sihaloho.kebugaranapps

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inputan_test_wanita.*

class InputanTestWanitaActivity : AppCompatActivity() {


    private lateinit var progressBar: ProgressDialog
    private lateinit var etSprint: String
    private lateinit var etSprintHasil: String
    private lateinit var etPushup: String
    private lateinit var etPushupHasil: String
    private lateinit var etSitUp: String
    private lateinit var etSitUpHasil: String

    private lateinit var etSBJ: String
    private lateinit var etSBJHasil: String
    private lateinit var etlari: String
    private lateinit var etlariHasil: String

    companion object {
        lateinit var fixHasilAkhir : String
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputan_test_wanita)
        progressBar = ProgressDialog(this)
        progressBar.setMessage("Mohon tunggu...")



        btn_lihat_hasil.setOnClickListener {
            progressBar.show()
            kelolahHasilSprint()
        }

    }

    private fun hasilkeseluruhan() {
        val fixsprint = etSprintHasil.toInt()
        val fixspushup = etPushupHasil.toInt()
        val fixsitup = etSitUpHasil.toInt()
        val fixsbj = etSBJHasil.toInt()
        val fixslari = etlariHasil.toInt()


        val hasilakhir = (fixsprint + fixspushup + fixsitup + fixsbj + fixslari) * 2
        fixHasilAkhir = hasilakhir.toString()




        progressBar.dismiss()
        val intent = Intent(this,
            ResultWanitaActivity::class.java)
        startActivity(intent)
        finishAffinity()



    }



    private fun kelolahHasilLari() {
        etlari = lari.text.toString()
        var lariFloat = etlari.toFloat()
        if (lariFloat>18.57){
            etlariHasil = "2"
        }
        if (lariFloat<=18.57){
            etlariHasil = "4"
        }
        if (lariFloat<=15.30){
            etlariHasil = "6"
        }
        if (lariFloat<=13.20){
            etlariHasil = "8"
        }
        if (lariFloat<=10.55){
            etlariHasil = "10"
        }

        hasilkeseluruhan()

    }

    private fun kelolahHasilSBJ() {
        etSBJ = sbj.text.toString()
        var sbjInt = etSBJ.toInt()
        if (sbjInt>160){
            etSBJHasil = "10"
        }
        if (sbjInt<=160){
            etSBJHasil = "8"
        }
        if (sbjInt<=150){
            etSBJHasil = "6"
        }
        if (sbjInt<=140){
            etSBJHasil = "4"
        }
        if (sbjInt<130){
            etSBJHasil = "2"
        }

        kelolahHasilLari()

    }

    private fun kelolahHasilSitUp() {
        etSitUp = situp.text.toString()
        var situpInt = etSitUp.toInt()
        if (situpInt>=35){
            etSitUpHasil = "10"
        }
        if (situpInt<=34){
            etSitUpHasil = "8"
        }
        if (situpInt<=24){
            etSitUpHasil = "6"
        }
        if (situpInt<=14){
            etSitUpHasil = "4"
        }
        if (situpInt<4){
            etSitUpHasil = "2"
        }
        kelolahHasilSBJ()
    }

    private fun kelolahHasilPushUp() {
        etPushup = et_pushup.text.toString()
        var pushupInt = etPushup.toInt()
        if (pushupInt>=25){
            etPushupHasil = "10"
        }
        if (pushupInt<=25){
            etPushupHasil = "8"
        }
        if (pushupInt<=20){
            etPushupHasil = "6"
        }
        if (pushupInt<=15){
            etPushupHasil = "4"
        }
        if (pushupInt<=11){
            etPushupHasil = "2"
        }

        kelolahHasilSitUp()

    }

    private fun kelolahHasilSprint() {
        etSprint = et_sprint.text.toString()
        var sprintFloat = etSprint.toFloat()
        if (sprintFloat>= 4.06 || sprintFloat <= 4.50){
            etSprintHasil = "10"
        }
        if (sprintFloat>= 4.51){
            etSprintHasil = "8"

        }
        if (sprintFloat>= 4.97){
            etSprintHasil = "6"

        }
        if (sprintFloat>= 5.41){
            etSprintHasil = "4"

        }
        if (sprintFloat>= 5.86){
            etSprintHasil = "2"

        }
        kelolahHasilPushUp()
    }
}

package com.sihaloho.kebugaranapps.modul

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class user (
    var uid : String ?="",
    var nama : String ?="",
    var usia : String ?="",
    var jeniskl : String ?=""
): Parcelable
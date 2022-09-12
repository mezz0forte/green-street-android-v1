package kr.hs.dgsw.stac.greenstreet.util

import android.content.Context
import android.location.Geocoder
import java.util.Locale

fun Context.myLocationGPSToAddress(lat: Double, lng: Double): String {
    val geocoder = Geocoder(this, Locale.KOREA)
    var address = "주소 오류"
    var splitAddress = emptyList<String>()
    try {
        splitAddress = geocoder.getFromLocation(lat, lng, 1).first().getAddressLine(0).split(" ")
        address = splitAddress.toString()
    } catch (e: Exception) {
        println(splitAddress)
        e.printStackTrace()
    }
    return address
}

fun Context.postingLocationGPSToAddress(lat: Double, lng: Double): String {
    val geocoder = Geocoder(this, Locale.KOREA)
    var address = "주소 오류"
    try {
        val splitAddress = geocoder.getFromLocation(lat, lng, 1).first().getAddressLine(0).split(" ")
        address = "${splitAddress[3]} ${splitAddress[4]} ${splitAddress[5]}"
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return address
}

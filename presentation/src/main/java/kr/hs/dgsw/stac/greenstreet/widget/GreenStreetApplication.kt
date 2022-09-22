package kr.hs.dgsw.stac.greenstreet.widget

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kr.hs.dgsw.stac.data.database.sharedpreferences.SharedPreferenceManager

@HiltAndroidApp
class GreenStreetApplication : Application() {

    companion object {
        lateinit var prefs: SharedPreferenceManager
    }

    override fun onCreate() {
        super.onCreate()
        prefs = SharedPreferenceManager(applicationContext)
    }
}

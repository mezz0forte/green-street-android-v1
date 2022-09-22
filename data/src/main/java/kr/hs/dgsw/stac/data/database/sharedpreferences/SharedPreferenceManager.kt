package kr.hs.dgsw.stac.data.database.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("green_street_prefs", Context.MODE_PRIVATE)

    fun setAccessToken(accessToken: String) {
        prefs.edit().putString(ACCESS_TOKEN_KEY, accessToken).apply()
    }

    fun setRefreshToken(refreshToken: String) {
        prefs.edit().putString(REFRESH_TOKEN_KEY, refreshToken).apply()
    }

    fun getAccessToken(): String {
        return prefs.getString(ACCESS_TOKEN_KEY, "").toString()
    }

    fun getRefreshToken(): String {
        return prefs.getString(REFRESH_TOKEN_KEY, "").toString()
    }

    companion object {
        private const val ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY"
        private const val REFRESH_TOKEN_KEY = "REFRESH_TOKEN_KEY"
    }
}

package kr.hs.dgsw.stac.data.base

import android.app.Application
import kr.hs.dgsw.stac.data.database.RoomDatabase

open class BaseCache(application: Application) {
    protected val database = RoomDatabase.getInstance(application)!!
}
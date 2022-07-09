package kr.hs.dgsw.stac.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import kr.hs.dgsw.stac.data.database.entity.SampleEntity
import java.util.concurrent.Executors

@Database(
    entities = [SampleEntity::class],
    version = 1, exportSchema = false
)
abstract class RoomDatabase : androidx.room.RoomDatabase() {

    companion object {

        private var instance: RoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): RoomDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabase::class.java, "green_street_database"
                )
                    .setQueryCallback({ sqlQuery, bindArgs ->
                        println("SQL Query: $sqlQuery SQL Args: $bindArgs")
                    }, Executors.newSingleThreadExecutor())
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}

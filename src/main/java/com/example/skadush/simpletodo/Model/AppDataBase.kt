package com.example.skadush.simpletodo.Model

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.content.Context

@Database(entities = arrayOf(Todos::class), version = 2)
abstract class AppDataBase : RoomDatabase() {

    abstract fun MyDAO(): MyDAO

    companion object {

        @JvmField
        val MIGRATION_1_2 = Migrations()

        /**
         * Kotlin declaration of objects
         * @see https://stackoverflow.com/a/17516998/1599611
         */
        val MIGRATION_ANONMOUS_ABSTRACT = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }


        @JvmStatic
        private  var INSTANCE: AppDataBase? = null
        fun getDatabaseBuiler(contexts: Context): AppDataBase {
            return INSTANCE ?: Room.databaseBuilder(contexts,AppDataBase::class.java,"Todo").addMigrations(MIGRATION_ANONMOUS_ABSTRACT).allowMainThreadQueries().build()
        }

    }

}
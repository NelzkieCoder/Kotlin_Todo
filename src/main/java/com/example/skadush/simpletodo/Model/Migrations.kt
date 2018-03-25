package com.example.skadush.simpletodo.Model

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration


//https://medium.com/@manuelvicnt/android-room-upgrading-alpha-versions-needs-a-migration-with-kotlin-or-nonnull-7a2d140f05b9
class Migrations : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {

    }
}
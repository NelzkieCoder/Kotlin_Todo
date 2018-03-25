package com.example.skadush.simpletodo.Model

import io.realm.RealmObject
import java.util.*

/**
 * Created by skadush on 19/03/18.
 */
open class Tasks : RealmObject() {

    var taskName: String? = null
    var datetime: Date? = null
    var checked: Boolean = false;
}
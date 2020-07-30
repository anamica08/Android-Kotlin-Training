package com.example.notesapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    /***
     * we can skip this column info and let room auto generate the column name same as the attribute name we have given.
     */
    @ColumnInfo(name = "NOTE_TITLE")
    var title:String,
    @ColumnInfo(name = "NOTE_CONTENT")
    var note: String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

}
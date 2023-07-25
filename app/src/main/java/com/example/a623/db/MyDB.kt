package com.example.a623.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.a623.Contact

class MyDB(context: Context) : SQLiteOpenHelper(context, Constant.DB_NAME,null,Constant.DB_VERSION), DBcervis{
    override fun onCreate(db: SQLiteDatabase?) {
        var query = "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique, ${Constant.TAOM} text not null, ${Constant.MAXSULOT} text not null, ${Constant.RETSEP} text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }

    override fun addcontact(contact: Contact) {
        val writableDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.TAOM, contact.name)
        contentValues.put(Constant.MAXSULOT, contact.maxsulot)
        contentValues.put(Constant.RETSEP, contact.retsep)
        writableDatabase.insert(Constant.TABLE_NAME,null,contentValues)
        writableDatabase.close()
    }

    override fun deletcontact(contact: Contact) {
        val writableDatabase = this.writableDatabase
        writableDatabase.delete(Constant.TABLE_NAME, "${Constant.ID}=?", arrayOf("${contact.id}"))
    }

    override fun updatecontact(contact: Contact):Int {
        val writableDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.TAOM, contact.name)
        contentValues.put(Constant.MAXSULOT, contact.maxsulot)
        contentValues.put(Constant.RETSEP, contact.retsep)
        return writableDatabase.update(Constant.TABLE_NAME, contentValues, "${Constant.ID}=?", arrayOf(contact.id.toString()))

    }

    override fun getallcontact(): ArrayList<Contact> {
        val list = ArrayList<Contact>()
        val query = "select * from ${Constant.TABLE_NAME}"
        val readableDatabase = this.readableDatabase
        val cursor = readableDatabase.rawQuery(query,null)

        if (cursor.moveToFirst()){
            do {
                val id =cursor.getInt(0)
                val name =cursor.getString(1)
                val maxsulot =cursor.getString(2)
                val retsep =cursor.getString(3)
                list.add(Contact(name,maxsulot,retsep))
            } while (cursor.moveToNext())
        }
        return list
    }


}
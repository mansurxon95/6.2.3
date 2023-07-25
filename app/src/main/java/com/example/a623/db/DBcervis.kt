package com.example.a623.db

import com.example.a623.Contact

interface DBcervis {
    fun addcontact(contact: Contact)
    fun deletcontact(contact: Contact)
    fun updatecontact(contact: Contact):Int
    fun getallcontact():ArrayList<Contact>
}
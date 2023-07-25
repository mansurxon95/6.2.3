package com.example.a623

import java.io.Serializable

class Contact:Serializable{

    var id:Int?=null
    var name:String?=null
    var maxsulot:String?=null
    var retsep:String?=null

    constructor(id: Int?, name: String?, maxsulot: String?, retsep: String?) {
        this.id = id
        this.name = name
        this.maxsulot = maxsulot
        this.retsep = retsep
    }

    constructor(name: String?, maxsulot: String?, retsep: String?) {
        this.name = name
        this.maxsulot = maxsulot
        this.retsep = retsep
    }


}
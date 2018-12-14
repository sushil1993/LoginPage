package sushillogin.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "loginDetail")
data class LoginDetailEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "role_id")
    var role_id:String,
    @ColumnInfo(name="first_name")
    var first_name:String,
    @ColumnInfo(name="last_name")
    var last_name:String,
    @ColumnInfo(name ="email" )
    var email:String,
    @ColumnInfo(name = "username")
    var username:String,
    @ColumnInfo(name = "gender")
    var gender:String,
    @ColumnInfo(name = "phone_no")
    var phone_no:String


)
/*
id: 8,
role_id: 2,
first_name: "Kannan",
last_name: "Maravar",
email: "Kannan.Maravar@wwindia.com",
username: "KannanMaravar",
profile_pic: null,
country_id: null,
gender: "M",
phone_no: 77150200100,
dob: null,
is_active: true,
created: "2015-08-21T04:35:46+0000",
modified: "2015-08-21T04:35:46+0000",
access_token: "55d6aaa2cf556"*/

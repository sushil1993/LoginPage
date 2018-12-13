package sushillogin.models

import com.google.gson.annotations.SerializedName



class LoginModel() {


    @SerializedName("status")
    var status: String? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("user_msg")
    var user_msg: String? = null

    @SerializedName("data")
    var data: Data? = null


    //object
    open inner class Data {

        @SerializedName("id")
        var id: String? = null

        @SerializedName("role_id")
        var role_id: String? = null

        @SerializedName("first_name")
        var first_name: String? = null

        @SerializedName("last_name")
        var last_name: String? = null

        @SerializedName("email")
        var email: String? = null

        @SerializedName("username")
        var username: String? = null

        @SerializedName("profile_pic")
        var profile_pic: String? = null

        @SerializedName("country_id")
        var country_id: String? = null

        @SerializedName("gender")
        var gender: String? = null

        @SerializedName("phone_no")
        var phone_no: String? = null

        @SerializedName("dob")
        var dob: String? = null

        @SerializedName("is_active")
        var is_active: String? = null

        @SerializedName("created")
        var created: String? = null

        @SerializedName("modified")
        var modified: String? = null

        @SerializedName("access_token")
        var access_token: String? = null

    }



}
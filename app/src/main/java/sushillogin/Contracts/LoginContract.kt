package sushillogin.Contracts

import android.content.Context
import android.text.Editable
import com.example.webwerks.loginpage.R
import sushillogin.view.LoginActivity

interface LoginContract {

    interface LoginView{
        fun showErrorMessage()
        fun showSuccessMessage()
        fun onLoginBtnCLicked()


    }

    interface LoginPresenter{

        fun validation(email:String,password:String)
        fun doLogin(email:String,password:String)

    }


}
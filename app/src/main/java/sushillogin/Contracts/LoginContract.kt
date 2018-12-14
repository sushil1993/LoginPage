package sushillogin.Contracts

import sushillogin.models.LoginModel

interface LoginContract {

    interface LoginView{
        fun showErrorMessage()
        fun showSuccessMessage()
        fun onLoginBtnCLicked()
        fun onDataInserted()



    }

    interface LoginPresenter{

        fun validation(email:String,password:String)
        fun doLogin(email:String,password:String)
        fun insetdb(model: LoginModel)


    }


}
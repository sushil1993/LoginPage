package sushillogin.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.webwerks.loginpage.R
import kotlinx.android.synthetic.main.activity_login.*
import sushillogin.Contracts.LoginContract
import sushillogin.database.LoginDao
import sushillogin.database.LoginDetailEntity
import sushillogin.database.RoomSingleton
import sushillogin.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val db = RoomSingleton.getInstance(this)
        val mPresenter = LoginPresenter(this,db)
        btn_submit.setOnClickListener {
            mPresenter.validation(edt_emailid.text.toString(), edt_password.text.toString())

        }

    }


    override fun showErrorMessage() {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

    override fun showSuccessMessage() {
        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

    }

    override fun onLoginBtnCLicked() {

    }


    override fun onDataInserted() {
        Toast.makeText(this, "data inserted Success", Toast.LENGTH_LONG).show()
    }
}

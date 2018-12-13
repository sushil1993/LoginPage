package sushillogin.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.webwerks.loginpage.R
import sushillogin.Contracts.LoginContract
import sushillogin.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var button: Button


    val mPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email=findViewById<EditText>(R.id.edt_emailid)
        pass=findViewById<EditText>(R.id.edt_password)
        button=findViewById<Button>(R.id.btn_submit)
        button.setOnClickListener {
            mPresenter.validation(email.text.toString(), pass.text.toString())
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



}

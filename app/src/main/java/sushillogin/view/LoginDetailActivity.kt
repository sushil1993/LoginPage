package sushillogin.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.webwerks.loginpage.R
import kotlinx.android.synthetic.main.activity_login_detail.*

class LoginDetailActivity : AppCompatActivity() {
    //lateinit var first_name: TextView
    lateinit var last_name: TextView
    lateinit var userName:TextView
    lateinit var email:TextView
    lateinit var phoneNumber:TextView
    lateinit var gender:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_detail)
        //first_name=findViewById(R.id.first_name)

    }
}

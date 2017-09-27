package com.example.devpartnerssoftware.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        loginButton.onClick {

            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()

            validate(email, password)
        }
    }
    fun validate(email: String, password: String){
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            alert("Invalid email", "Err or"){
                okButton { return@okButton }
            }.show()

        } else if(email.isEmpty() || password.isEmpty()){
            alert("Please input","Error"){
                okButton { return@okButton }
            }.show()
        } else if(email.equals("veah@yahoo.com") && password.equals("veah")){
            val store = SessionStore()
            store.saveEmail(email,this)
            finish()
            startActivity<WelcomeActivity>()
        }else{
            alert("Na wrong ka","Error"){
                okButton { return@okButton }
            }.show()
        }
    }
}

package com.example.devpartnerssoftware.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        logoutButton.onClick {
            logout()

        }
    }
        fun logout(){
            SessionStore().clearEmail(this)
            startActivity<SplashActivity>()
            finish()
        }
    }


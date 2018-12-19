package com.bayanadam.videosappwithfirebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Login_activity : AppCompatActivity() {




    var user_email:EditText? = null
    var user_passwrd:EditText? = null
    var login_btn:Button? = null
    var firebaseAuth:FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)

        user_email = findViewById(R.id.user_lgoinEamil)
        user_passwrd = findViewById(R.id.user_loginPassword)
        login_btn = findViewById(R.id.login)
        firebaseAuth = FirebaseAuth.getInstance()

        login_btn?.setOnClickListener {


            LoginUser()

        }

    }



    private fun LoginUser() {


        var email = user_email?.text.toString().trim()
        var password = user_passwrd?.text.toString().trim()






        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {

            Toast.makeText(applicationContext,"This Field can not be Empty",Toast.LENGTH_SHORT).show()
        }

        else {


            firebaseAuth?.signInWithEmailAndPassword(email,password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                override fun onComplete(auth: Task<AuthResult>) {


                    if (auth.isSuccessful) {

                        Toast.makeText(applicationContext,"Your are Logedin Successfly",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@Login_activity,Dashborad_activity::class.java))


                    }else {

                        var error = auth.exception?.message
                        Toast.makeText(applicationContext,"Error " + error,Toast.LENGTH_SHORT).show()
                    }

                }


            })




        }

    }
}

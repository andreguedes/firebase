package br.com.andreguedes.authentication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.*
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        callbackManager = CallbackManager.Factory.create()

        btn_facebook_login.setReadPermissions("email", "public_profile")
        btn_facebook_login.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                Log.i("Facebook Lib", "Sucesso")
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {
                Log.i("Facebook Lib", "Cancelado")
            }

            override fun onError(error: FacebookException) {
                Log.i("Facebook Lib", "Erro")
            }
        })
    }

    override fun onStart() {
        super.onStart()

        val firebaseUser = auth.currentUser
        showUserInfo(firebaseUser)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        showUserInfo(auth.currentUser)
                    } else {
                        showUserInfo(null)
                    }
                }
    }

    private fun showUserInfo(firebaseUser: FirebaseUser?) {
        if (firebaseUser != null) {
            Toast.makeText(this, firebaseUser.displayName, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Nao logou o usuario", Toast.LENGTH_LONG).show()
        }
    }

}

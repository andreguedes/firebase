package br.com.andreguedes.firebaseremoteconfig

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firebase.ui.storage.images.FirebaseImageLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        FirebaseUtils.fetchFirebase(this)

        val paymentSaturday = FirebaseUtils.getConfigString(this, FirebaseUtils.TESTE)
        txt.text = paymentSaturday ?: "Deu errado!!!"

        val imageReference = FirebaseUtils.getImage(this)
        Glide.with(this).using(FirebaseImageLoader()).load(imageReference).diskCacheStrategy(DiskCacheStrategy.NONE).into(img)
    }

}
package br.com.andreguedes.listaedetalhes_firebase

import android.app.Application
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by andreguedes on 30/10/17.
 */
class ListaEDetalhesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }

}
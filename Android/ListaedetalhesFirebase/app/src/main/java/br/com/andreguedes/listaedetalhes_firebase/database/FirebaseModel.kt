package br.com.andreguedes.listaedetalhes_firebase.database

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by andreguedes on 30/10/17.
 */
class FirebaseModel : FirebaseContract {

    private var firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()

    override fun getFirebaseItems(): DatabaseReference {
        return firebaseDatabase.getReference("lista")
    }

    override fun getFirebaseDetalhe(itemId: Int): DatabaseReference {
        return getFirebaseItems().child(itemId.toString()).child("detalhe")
    }

}
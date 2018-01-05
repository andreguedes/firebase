package br.com.andreguedes.listaedetalhes_firebase.database

import com.google.firebase.database.DatabaseReference

/**
 * Created by andreguedes on 30/10/17.
 */
interface FirebaseContract {

    fun getFirebaseItems(): DatabaseReference
    fun getFirebaseDetalhe(itemId: Int): DatabaseReference

}
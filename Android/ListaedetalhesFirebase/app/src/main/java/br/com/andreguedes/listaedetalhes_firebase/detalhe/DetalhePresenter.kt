package br.com.andreguedes.listaedetalhes_firebase.detalhe

import br.com.andreguedes.listaedetalhes_firebase.database.FirebaseContract
import br.com.andreguedes.listaedetalhes_firebase.database.FirebaseModel
import br.com.andreguedes.listaedetalhes_firebase.model.Detalhe
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

/**
 * Created by andreguedes on 30/10/17.
 */
class DetalhePresenter(var view: DetalheContract.DetalheView) : DetalheContract.DetalhePresenter {

    private var firebaseModel: FirebaseContract = FirebaseModel()

    override fun getDetalhe(itemId: Int) {
        firebaseModel.getFirebaseDetalhe(itemId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                val detalheDS = dataSnapshot?.getValue(Detalhe::class.java)
                detalheDS?.let {
                    view.setDetalhe(detalheDS.nome)
                }
            }

            override fun onCancelled(p0: DatabaseError?) {}
        })
    }

}
package br.com.andreguedes.listaedetalhes_firebase.items

import android.view.View
import br.com.andreguedes.listaedetalhes_firebase.database.FirebaseContract
import br.com.andreguedes.listaedetalhes_firebase.database.FirebaseModel
import br.com.andreguedes.listaedetalhes_firebase.model.Item
import com.google.firebase.database.*

/**
 * Created by andreguedes on 30/10/17.
 */
class ItemsPresenter(var view: ItemsContract.ItemsView) : ItemsContract.ItemsPresenter {

    private var firebaseModel: FirebaseContract = FirebaseModel()

    override fun getItems() {
        view.statusLoading(View.VISIBLE)

        firebaseModel.getFirebaseItems().addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                val itemList: MutableList<Item> = ArrayList()

                for (ds in dataSnapshot?.children!!) {
                    val itemDS = ds.getValue(Item::class.java)
                    itemDS?.let {
                        val item = Item()
                        item.id = itemDS.id
                        item.nome = itemDS.nome
                        item.detalhe = itemDS.detalhe
                        itemList.add(item)
                    }
                }

                view.updateItemsList(itemList)
                view.statusLoading(View.GONE)
            }

            override fun onCancelled(p0: DatabaseError?) {
                view.statusLoading(View.GONE)
            }
        })
    }

}
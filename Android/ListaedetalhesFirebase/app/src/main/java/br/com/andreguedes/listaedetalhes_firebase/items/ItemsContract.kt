package br.com.andreguedes.listaedetalhes_firebase.items

import br.com.andreguedes.listaedetalhes_firebase.model.Item

/**
 * Created by andreguedes on 30/10/17.
 */
interface ItemsContract {

    interface ItemsView {
        fun statusLoading(visibility: Int)
        fun updateItemsList(items: List<Item>)
    }

    interface ItemsPresenter {
        fun getItems()
    }

}
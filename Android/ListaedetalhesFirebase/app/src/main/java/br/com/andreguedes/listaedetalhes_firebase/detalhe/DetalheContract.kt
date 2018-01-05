package br.com.andreguedes.listaedetalhes_firebase.detalhe

/**
 * Created by andreguedes on 30/10/17.
 */
interface DetalheContract {

    interface DetalheView {
        fun setDetalhe(detalhe: String)
    }

    interface DetalhePresenter {
        fun getDetalhe(itemId: Int)
    }

}
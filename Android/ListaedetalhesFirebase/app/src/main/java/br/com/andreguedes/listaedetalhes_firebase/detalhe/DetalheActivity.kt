package br.com.andreguedes.listaedetalhes_firebase.detalhe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.andreguedes.listaedetalhes_firebase.R
import kotlinx.android.synthetic.main.activity_detalhe.*

class DetalheActivity : AppCompatActivity(), DetalheContract.DetalheView {

    lateinit var mPresenter: DetalheContract.DetalhePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        mPresenter = DetalhePresenter(this)

        initUi()
    }

    private fun initUi() {
        mPresenter.getDetalhe(intent.getIntExtra(ITEM_ID, 0))
    }

    override fun setDetalhe(detalhe: String) {
        txt_detalhe.text = detalhe
    }

    companion object {
        var ITEM_ID = "item_id"
    }

}
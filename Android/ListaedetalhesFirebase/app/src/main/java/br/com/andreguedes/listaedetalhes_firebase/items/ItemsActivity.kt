package br.com.andreguedes.listaedetalhes_firebase.items

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.andreguedes.listaedetalhes_firebase.R
import br.com.andreguedes.listaedetalhes_firebase.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class ItemsActivity : AppCompatActivity(), ItemsContract.ItemsView {

    lateinit var mPresenter: ItemsContract.ItemsPresenter

    var itemList: MutableList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = ItemsPresenter(this)

        initUi()
    }

    private fun initUi() {
        mPresenter.getItems()

        rv_items.layoutManager = LinearLayoutManager(this)
        rv_items.adapter = ItemsAdapter(this, itemList)
    }

    override fun updateItemsList(items: List<Item>) {
        itemList.clear()
        itemList.addAll(items)
        rv_items.adapter.notifyDataSetChanged()
    }

    override fun statusLoading(visibility: Int) {
        progress.visibility = visibility
    }

}
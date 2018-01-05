package br.com.andreguedes.listaedetalhes_firebase.items

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.andreguedes.listaedetalhes_firebase.R
import br.com.andreguedes.listaedetalhes_firebase.detalhe.DetalheActivity
import br.com.andreguedes.listaedetalhes_firebase.model.Item
import kotlinx.android.synthetic.main.rv_detalhe_item.view.*

/**
 * Created by andreguedes on 30/10/17.
 */
class ItemsAdapter(private var context: Context, private var items: MutableList<Item>) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        val item = items.get(position)
        holder?.let {
            it.itemTitle.text = item.nome
            it.itemView.setOnClickListener {
                val intent = Intent(context, DetalheActivity::class.java)
                intent.putExtra(DetalheActivity.ITEM_ID, position)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.rv_detalhe_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTitle = view.txtItem
    }

}
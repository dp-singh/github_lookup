package com.dpsingh.githublookup.ui.home.adapter.view_holders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dpsingh.githublookup.GlideApp
import com.dpsingh.githublookup.R
import com.dpsingh.githublookup.domain.model.User
import kotlinx.android.synthetic.main.item_search_history.view.*

class HistoryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search_history, parent, false)) {

    fun bind(previousSearch: User?, listener: (user: User, historyViewHolder: HistoryViewHolder) -> Unit) {
        previousSearch?.run {
            itemView.tv_item_content.text = previousSearch.name
            itemView.tvGithubHandle.text = previousSearch.login
            itemView.setOnClickListener {
                listener.invoke(previousSearch, this@HistoryViewHolder)
            }
            GlideApp.with(itemView).load(previousSearch.avatar_url).circleCrop().into(itemView.img_avatar)
        }
    }

    fun getImage(): ImageView {
        return itemView.img_avatar
    }

    fun  getTextView():TextView{
        return itemView.tv_item_content
    }
}
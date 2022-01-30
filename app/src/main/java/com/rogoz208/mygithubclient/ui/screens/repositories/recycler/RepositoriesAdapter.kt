package com.rogoz208.mygithubclient.ui.screens.repositories.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogoz208.mygithubclient.domain.entities.RepositoryEntity

class RepositoriesAdapter : RecyclerView.Adapter<RepositoryViewHolder>() {

    var data: List<RepositoryEntity> = ArrayList()
        get() = ArrayList(field)

    private var clickListener: OnRepositoryClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(parent, clickListener!!)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getItem(position: Int): RepositoryEntity {
        return data[position]
    }

    fun setOnItemClickListener(listener: OnRepositoryClickListener) {
        clickListener = listener
    }
}
package com.example.num1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.num1.databinding.ItemRepositoryListBinding

class RePositoryAdapter : RecyclerView.Adapter<RePositoryAdapter.RePositoryViewHolder>() {
    val repoList = mutableListOf<repoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RePositoryViewHolder {
        val binding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RePositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RePositoryViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    override fun getItemCount(): Int = repoList.size

    class RePositoryViewHolder(
        private val binding: ItemRepositoryListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: repoData) {
            binding.tvTitle.text = data.repotitle
            binding.tvReposource.text = data.reposource
        }
    }
}
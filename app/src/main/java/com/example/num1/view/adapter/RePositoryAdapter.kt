package com.example.num1.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.num1.data.RepoData
import com.example.num1.databinding.ItemRepositoryListBinding

class RePositoryAdapter : RecyclerView.Adapter<RePositoryAdapter.RePositoryViewHolder>() {
    val repoList = mutableListOf<RepoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RePositoryViewHolder {
        val binding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RePositoryViewHolder(binding)
    }

    //viewHolder와 position의 데이터를 결합시키는 함수
    override fun onBindViewHolder(holder: RePositoryViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    override fun getItemCount(): Int = repoList.size

    class RePositoryViewHolder(
        private val binding: ItemRepositoryListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RepoData) {
            binding.tvTitle.text = data.repotitle
            binding.tvReposource.text = data.reposource
        }
    }
}
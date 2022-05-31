package com.example.num1.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.num1.data.UserData
import com.example.num1.databinding.ItemFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val userList = mutableListOf<UserData>()

    interface OnItemClickListener {
        fun onItemClick(v: View, data: UserData, position: Int)
    }

    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    //viewHolder와 position의 데이터를 결합시키는 함수
    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(userList[position])

        //view에 onclicklisgner를 달고, 그 안에서 직접 만든 itemClickListener를 연결시킨다.
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int = userList.size
    // = { return userlist.size} 이거를 위에처럼 줄여서 쓸 수 있다. recyclerview로 보여줄 전체 데이터 개수 반환


    class FollowerViewHolder(
        private val binding: ItemFollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: UserData) {
            with(binding){
                ivProfile.setImageResource(data.image)
                tvName.text = data.name
                tvIntroduce.text = data.introduction
            }

        }
    }

    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭 리스너 선언
    private lateinit var itemClickListener: ItemClickListener

    //클릭리스너 등록 메소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

}

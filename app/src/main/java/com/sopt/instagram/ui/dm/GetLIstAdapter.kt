package com.sopt.instagram.ui.dm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.instagram.data.model.response.DmListResponseDto
import com.sopt.instagram.databinding.ItemDmMessageBinding

class GetLIstAdapter : ListAdapter<DmListResponseDto, GetLIstAdapter.GetListViewHolder>(
    GetListCallback,
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetListViewHolder {
        val binding =
            ItemDmMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GetListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GetListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class GetListViewHolder(private val binding: ItemDmMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DmListResponseDto) {
            with(binding) {
                tvDmMsgName.text = item.memberName
                tvDmMsg.text = item.latestMessage
                Glide.with(root)
                    .load(item.memberImageUrl).circleCrop()
                    .into(btnDmMsgPhoto)
            }
        }
    }

    companion object {
        private val GetListCallback = object : DiffUtil.ItemCallback<DmListResponseDto>() {
            override fun areItemsTheSame(
                oldItem: DmListResponseDto,
                newItem: DmListResponseDto,
            ): Boolean {
                return oldItem.memberId == newItem.memberId
            }

            override fun areContentsTheSame(
                oldItem: DmListResponseDto,
                newItem: DmListResponseDto,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

package com.sopt.instagram.ui.story.tag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.instagram.databinding.ItemTagMemberBinding
import com.sopt.instagram.domain.entity.Tag
import com.sopt.instagram.ui.story.tag.TagAdapter.TagViewHolder
import com.sopt.instagram.util.DiffCallback
import timber.log.Timber

class TagAdapter : ListAdapter<Tag, TagViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        Timber.d("onCreateViewHolder")
        return TagViewHolder(
            ItemTagMemberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        Timber.d("onBindViewHolder($position)")
        holder.setTag(getItem(position))
    }

    class TagViewHolder(private val binding: ItemTagMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setTag(tag: Tag) {
            Timber.d("set tag : $tag")
            binding.data = tag
        }
    }

    companion object {
        private val diffUtil = DiffCallback<Tag>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}

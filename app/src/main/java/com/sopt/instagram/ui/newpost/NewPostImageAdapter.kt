package com.sopt.instagram.ui.newpost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.instagram.databinding.ItemNewpostImageBinding
import com.sopt.instagram.util.DiffCallback
import timber.log.Timber

class NewPostImageAdapter :
    ListAdapter<String, NewPostImageAdapter.NewPostImageViewHolder>(diffUtil),
    ItemTouchHelperListener {
    class NewPostImageViewHolder(private val binding: ItemNewpostImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(image: String) {
            Glide.with(binding.root).load(image).into(binding.ivNewpostItemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewPostImageViewHolder {
        return NewPostImageViewHolder(
            ItemNewpostImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: NewPostImageViewHolder, position: Int) {
        holder.onBind(getItem(position))
        Timber.tag("onbindviewholder").d(currentList.toString())
    }

    override fun onItemMove(from: Int, to: Int) {
        val newList = currentList.toMutableList()
        Timber.tag("getItemFrom").d(newList.toString())
//        Collections.swap(newList, from, to)
//        submitList(newList)
    }

    companion object {
        private val diffUtil = DiffCallback<String>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}

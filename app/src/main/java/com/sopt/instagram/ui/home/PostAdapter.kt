package com.sopt.instagram.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ItemHomeRecommendFriendBinding
import com.sopt.instagram.databinding.ItemPostBinding
import com.sopt.instagram.domain.entity.Member
import com.sopt.instagram.domain.entity.Post
import com.sopt.instagram.domain.entity.type.StoryState
import com.sopt.instagram.ui.story.StoryActivity
import com.sopt.instagram.ui.story.StoryActivity.Companion.EXTRA_MEMBER_LIST
import com.sopt.instagram.util.DiffCallback

class PostAdapter : ListAdapter<Post, RecyclerView.ViewHolder>(diffUtil) {
    class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBindPost(post: Post) {
            with(binding) {
                data = post
                vpHomePostImage.adapter = PostImagesAdapter().apply {
                    submitList(post.imageUrlList)
                }
                spiHomeImageIndicator.attachToPager(vpHomePostImage)
                onClickMemberImage(binding, post)
            }
        }

        private fun onClickMemberImage(binding: ItemPostBinding, post: Post) {
            binding.ivHomeUserProfileImage.setOnClickListener {
                if (post.storyState == StoryState.NONE) return@setOnClickListener

                with(binding) {
                    val intent = Intent(root.context, StoryActivity::class.java)
                    intent.putExtra(
                        EXTRA_MEMBER_LIST,
                        arrayListOf(
                            Member(
                                post.memberId,
                                post.memberImageUrl,
                                post.memberName,
                            ),
                        ),
                    )
                    ContextCompat.startActivity(root.context, intent, null)
                    // TODO: 뷰 리스트 원소도 READ 처리
                    viewPostProfileStroke.background = AppCompatResources.getDrawable(
                        root.context,
                        R.drawable.bg_story_profile_read,
                    )
                }
            }
        }
    }

    class RecommendFriendViewHolder(private val binding: ItemHomeRecommendFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBindRecommendFriend() {
            binding.layoutRecommendFriendList.adapter = PostRecommendFriendAdapter().apply {
                submitList(
                    listOf(
                        R.drawable.img_recommend_friend,
                        R.drawable.img_recommend_friend,
                        R.drawable.img_recommend_friend,
                        R.drawable.img_recommend_friend,
                    ),
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_POST -> PostViewHolder(
                ItemPostBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                ),
            )

            VIEW_TYPE_RECOMMEND_FRIEND -> RecommendFriendViewHolder(
                ItemHomeRecommendFriendBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                ),
            )

            else -> throw ClassCastException(
                parent.context.getString(
                    R.string.view_type_error_msg,
                    viewType,
                ),
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PostViewHolder) {
            holder.onBindPost(getItem(position))
        } else if (holder is RecommendFriendViewHolder) {
            holder.onBindRecommendFriend()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            1 -> VIEW_TYPE_RECOMMEND_FRIEND
            else -> VIEW_TYPE_POST
        }
    }

    companion object {
        private val diffUtil = DiffCallback<Post>(
            onItemsTheSame = { old, new -> old.memberId == new.memberId },
            onContentsTheSame = { old, new -> old == new },
        )

        private const val RECOMMEND_FRIEND_COUNT = 1

        const val VIEW_TYPE_RECOMMEND_FRIEND = 0
        const val VIEW_TYPE_POST = 1
    }
}

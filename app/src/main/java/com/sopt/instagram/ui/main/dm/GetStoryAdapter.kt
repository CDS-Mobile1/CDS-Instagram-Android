import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.instagram.data.model.response.DmstoryResponseDto
import com.sopt.instagram.databinding.ItemDmStarredBinding

class GetStoryAdapter : ListAdapter<DmstoryResponseDto,GetStoryAdapter.GetStoryViewHolder>(
    GetStoryCallback){
    class GetStoryViewHolder(private val binding: ItemDmStarredBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: DmstoryResponseDto){
            with(binding){
                tvDmStarredName.text=item.memberName
                Glide.with(root)
                    .load(item.memberImageUrl)
                    .into(ibDmStarredProfile)

            }
        }
    }

    companion object{
        private val GetStoryCallback=object :DiffUtil.ItemCallback<DmstoryResponseDto>(){
            override fun areItemsTheSame(oldItem: DmstoryResponseDto, newItem: DmstoryResponseDto): Boolean {
                return oldItem.hashCode()==newItem.hashCode()
            }

            override fun areContentsTheSame(
                oldItem: DmstoryResponseDto,
                newItem: DmstoryResponseDto
            ): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetStoryViewHolder {
        val binding=ItemDmStarredBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GetStoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GetStoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
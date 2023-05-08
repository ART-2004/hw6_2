package com.example.hw6_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw6_2.databinding.ItemImageBinding

class ImageAdapter(
    private var imageList: ArrayList<ImageModel>,
    private val clickListener: (ImageModel) -> Unit,
    private val deleteItem: (ImageModel) -> Unit
) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: ImageModel) {
            val imageView = binding.ivImage
            Glide.with(itemView.context).load(image.imageURL).centerCrop().into(imageView)
            binding.vSelected.isVisible = image.isSelected
            itemView.setOnClickListener {
                if (image.isSelected){
                    deleteItem(image)
                    image.isSelected = false
                    notifyItemChanged(adapterPosition)
                } else {
                    clickListener(image)
                    image.isSelected = true
                    notifyItemChanged(adapterPosition)
                }

            }
        }
    }
}
package com.example.lovecalculat.viewmodel.onboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculat.R
import com.example.lovecalculat.databinding.ItemOnboardBinding

class OnBoardAdapter(private val context: Context, private val onClick: ()-> Unit)
    :RecyclerView.Adapter<OnBoardAdapter.onBoardingViewHolder>() {
    private val model = arrayListOf<OnBoardModel>(
        OnBoardModel(R.raw.lc_onboard1, ""),
        OnBoardModel(R.raw.lc_onboard2,""),
        OnBoardModel(R.raw.lc_onboard3,""),
        OnBoardModel(R.raw.lc_onboard4,"")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolder {
        return onBoardingViewHolder(ItemOnboardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: onBoardingViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount(): Int {
        return model.size
    }
    inner class onBoardingViewHolder(private val binding: ItemOnboardBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(OnBoardModel: OnBoardModel) {
            binding.imgBoarding.setAnimation(OnBoardModel.image)
            binding.tvTitles.text = OnBoardModel.titles
            if (adapterPosition == model.lastIndex){
                binding.skip.text = "Next"
            }else binding.skip.text = "Skip"
            binding.skip.setOnClickListener {
                onClick()
            }

        }

    }
}
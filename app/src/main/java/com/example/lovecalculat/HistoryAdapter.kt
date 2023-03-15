package com.example.lovecalculat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.lovecalculat.databinding.ItemResultBinding
import com.example.lovecalculat.remote.LoveModel

class HistoryAdapter(): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    var models = arrayListOf<LoveModel>()
    fun addLoves(list: List<LoveModel>) {
        models.clear()
        models.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(models[position])
    }

    fun setItem(list: List<LoveModel>) {
        models.clear()
        models.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class HistoryViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            with(binding) {
                fnameTv.text = loveModel.firstName
                snameTv.text = loveModel.secondName
                percentageTv.text = loveModel.percentage
            }
        }
    }
}

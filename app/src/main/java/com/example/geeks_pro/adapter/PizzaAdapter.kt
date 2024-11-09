package com.example.geeks_pro.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geeks_pro.databinding.ItemPizzaBinding
import com.example.geeks_pro.ext.loadImage
import com.example.geeks_pro.ext.model.PizzaModel


class PizzaAdapter(
    private var characterList: List<PizzaModel>,
    private val onClick: (model: PizzaModel) -> Unit) :
    RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPizzaBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    inner class ViewHolder(private var binding: ItemPizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(car: PizzaModel) {
            binding.apply {
                tvCarName.text = car.name
                tvCarYear.text = car.year
                imgCars.loadImage(car.image)
                itemView.setOnClickListener() {
                    onClick(car)
                }
            }
        }
    }
}
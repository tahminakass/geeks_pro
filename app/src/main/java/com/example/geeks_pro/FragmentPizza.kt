package com.example.geeks_pro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.geeks_pro.adapter.PizzaAdapter
import com.example.geeks_pro.databinding.FragmentPizzaBinding
import com.example.geeks_pro.ext.model.PizzaModel
import com.example.geeks_pro.utils.keys.Keys


class FragmentPizza : Fragment() {

    private lateinit var binding: FragmentPizzaBinding
    private val pizzaList = arrayListOf(
        PizzaModel("Peperoni","2024","https://atsloanestable.com/wp-content/uploads/2023/06/new-york-style-pizza2.jpg"),
        PizzaModel("Margarita","2024","https://images.ctfassets.net/j8tkpy1gjhi5/5OvVmigx6VIUsyoKz1EHUs/b8173b7dcfbd6da341ce11bcebfa86ea/Salami-pizza-hero.jpg?w=768&fm=webp&q=80"),
        PizzaModel("Mexico","2024","https://images.ctfassets.net/j8tkpy1gjhi5/2sqzajlrYF2lTJZ0VGlocB/8a7ae2bbd2fa8593dc133c0b7c70d8c1/breakfast-pizza-hero.jpg?w=768&fm=webp&q=80"),
        PizzaModel("Papa Jons","2024","https://images.ctfassets.net/j8tkpy1gjhi5/2sqzajlrYF2lTJZ0VGlocB/8a7ae2bbd2fa8593dc133c0b7c70d8c1/breakfast-pizza-hero.jpg?w=768&fm=webp&q=80"),
        PizzaModel("Vegan","2024","https://images.ctfassets.net/j8tkpy1gjhi5/2sqzajlrYF2lTJZ0VGlocB/8a7ae2bbd2fa8593dc133c0b7c70d8c1/breakfast-pizza-hero.jpg?w=768&fm=webp&q=80"),
        PizzaModel("Meat Pizza","2024","https://images.ctfassets.net/j8tkpy1gjhi5/2sqzajlrYF2lTJZ0VGlocB/8a7ae2bbd2fa8593dc133c0b7c70d8c1/breakfast-pizza-hero.jpg?w=768&fm=webp&q=80"),
        PizzaModel("The best Pizza","2024","https://images.ctfassets.net/j8tkpy1gjhi5/2sqzajlrYF2lTJZ0VGlocB/8a7ae2bbd2fa8593dc133c0b7c70d8c1/breakfast-pizza-hero.jpg?w=768&fm=webp&q=80")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPizzaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = PizzaAdapter(pizzaList, this::onClick)
    }
    private fun onClick(model: PizzaModel) {
        findNavController().navigate(R.id.fragmentPizzaDetail, bundleOf(Keys.KEY_FOR_PIZZA to model))
    }
}
@file:Suppress("DEPRECATION")

package com.example.geeks_pro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geeks_pro.databinding.FragmentPizzaDetailBinding
import com.example.geeks_pro.ext.loadImage
import com.example.geeks_pro.ext.model.PizzaModel
import com.example.geeks_pro.utils.keys.Keys

class FragmentPizzaDetail : Fragment() {

    private lateinit var binding: FragmentPizzaDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPizzaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        val model = arguments?.getSerializable(Keys.KEY_FOR_PIZZA) as PizzaModel
        binding.apply {
            tvPizzaName.text = model.name
            tvPizzaYear.text = model.year
            imgPizza.loadImage(model.image)
        }
    }

}
package com.polware.foodrecipes.view.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.polware.foodrecipes.data.models.ResultRecipe
import com.polware.foodrecipes.data.utils.Constants.Companion.ARGS_KEY
import com.polware.foodrecipes.databinding.FragmentIngredientPageBinding
import com.polware.foodrecipes.view.adapters.IngredientAdapter

class IngredientPageFragment : Fragment() {
    private var _bindingIngredient: FragmentIngredientPageBinding? = null
    private val bindingIngredient get() = _bindingIngredient!!
    private val ingredientAdapter: IngredientAdapter by lazy { IngredientAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _bindingIngredient = FragmentIngredientPageBinding.inflate(inflater, container, false)
        return bindingIngredient.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val myBundle = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            args?.getParcelable(ARGS_KEY, ResultRecipe::class.java)
            }
        else {
            args?.getParcelable(ARGS_KEY) as ResultRecipe?
        }

        bindingIngredient.rvIngredients.adapter = ingredientAdapter
        bindingIngredient.rvIngredients.layoutManager = LinearLayoutManager(requireContext())
        myBundle?.extendedIngredients?.let {
            list ->
            ingredientAdapter.setIngredientsData(list)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        // For avoid memory leaks
        _bindingIngredient = null
    }

}
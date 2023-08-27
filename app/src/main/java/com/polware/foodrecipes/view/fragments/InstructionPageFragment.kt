package com.polware.foodrecipes.view.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.polware.foodrecipes.R
import com.polware.foodrecipes.data.models.ResultRecipe
import com.polware.foodrecipes.data.utils.Constants
import com.polware.foodrecipes.databinding.FragmentInstructionPageBinding

class InstructionPageFragment : Fragment() {
    private var _bindingInstruction: FragmentInstructionPageBinding? = null
    private val bindingInstruction get() = _bindingInstruction!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _bindingInstruction = FragmentInstructionPageBinding.inflate(inflater, container, false)
        return bindingInstruction.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val myBundle = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            args?.getParcelable(Constants.ARGS_KEY, ResultRecipe::class.java)
        }
        else {
            args?.getParcelable(Constants.ARGS_KEY) as ResultRecipe?
        }
        bindingInstruction.webViewInstructions.webViewClient = object : WebViewClient() {

        }
        val webSiteUrl: String = myBundle!!.sourceUrl
        bindingInstruction.webViewInstructions.loadUrl(webSiteUrl)
    }

    override fun onDestroy() {
        super.onDestroy()
        // For avoid memory leaks
        _bindingInstruction = null
    }

}
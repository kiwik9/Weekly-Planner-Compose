package io.kiwik.weeklyplanner.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.kiwik.weeklyplanner.ComposableInXml
import io.kiwik.weeklyplanner.R
import io.kiwik.weeklyplanner.databinding.FragmentExampleBinding

class ExampleFragment : Fragment() {

    private lateinit var binding: FragmentExampleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExampleBinding.inflate(layoutInflater)
        binding.myComposeView.setContent {
            ComposableInXml()
        }
        return binding.root
    }

    fun setText(text: String) {
        binding.text.text = text
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExampleFragment()
    }
}
package io.kiwik.weeklyplanner.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.kiwik.weeklyplanner.R

class ContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContainerFragment()
    }
}
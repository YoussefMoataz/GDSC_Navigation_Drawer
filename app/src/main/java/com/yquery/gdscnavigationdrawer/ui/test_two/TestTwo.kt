package com.yquery.gdscnavigationdrawer.ui.test_two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yquery.gdscnavigationdrawer.databinding.FragmentTestTwoBinding

class TestTwo : Fragment() {

    private lateinit var testTwoViewModel: TestTwoViewModel
    private var _binding: FragmentTestTwoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testTwoViewModel =
            ViewModelProvider(this).get(TestTwoViewModel::class.java)

        _binding = FragmentTestTwoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        testTwoViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
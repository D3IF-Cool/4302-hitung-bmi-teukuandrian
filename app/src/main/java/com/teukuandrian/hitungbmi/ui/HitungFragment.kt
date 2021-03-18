package com.teukuandrian.hitungbmi.ui
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation.findNavController
import org.d3if2090.hitungbmi.R
import org.d3if2090.hitungbmi.databinding.FragmentHitungBinding

class HitungFragment : Fragment() {
    private lateinit var binding: FragmentHitungBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHitungBinding.inflate(
                layoutInflater, container, false)
        binding.button.setOnClickListener { hitungBmi() }
        return binding.root

        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            super.onCreateOptionsMenu(menu, inflater)
            inflater.inflate(R.menu.options_menu, menu)

        }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == R.id.menu_about) {
                findNavController().navigate(
                        R.id.action_hitungFragment_to_aboutFragment)
                return true
            }
            return super.onOptionsItemSelected(item)
        }

    }
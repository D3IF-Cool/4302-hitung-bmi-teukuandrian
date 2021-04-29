package com.teukuandrian.hitungbmi.ui

import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation.findNavController
import org.d3if2090.hitungbmi.R
import org.d3if2090.hitungbmi.databinding.FragmentHitungBinding
import ui.HitungViewModel

class HitungFragment : Fragment() {
    private val viewModel: HitungViewModel by viewModels()
    private val viewModel: HitungViewModel by lazy {
        val db = BmiDb.getInstance(requireContext())
        val factory = HitungViewModelFactory(db.dao)
        ViewModelProvider(this, factory).get(HitungViewModel::class.java)
    }
}
    private val viewModel: HitungViewModel by viewModels()
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
            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                viewModel.getHasilBmi().observe(viewLifecycleOwner, {
                    if (it == null) return@observe
                    binding.bmiTextView.text = getString(R.string.bmi_x, it.bmi)
                    binding.kategoriTextView.text = getString(R.string.kategori_x,
                            getKategori(it.kategori))
                    binding.buttonGroup.visibility = View.VISIBLE
                })
                viewModel.data.observe(viewLifecycleOwner, {
                    if (it == null) return@observe
                    Log.d("HitungFragment", "Data tersimpan. ID = ${it.id}")
                })
            }

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
package com.teukuandrian.hitungbmi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.teukuandrian.hitungbmi.ui.KategoriBmi
import org.d3if2090.hitungbmi.R
import org.d3if2090.hitungbmi.databinding.FragmentSaranBinding

class SaranFragment : Fragment() {
    private val args: SaranFragmentArgs by navArgs()
    private lateinit var binding: FragmentSaranBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSaranBinding.inflate(
            layoutInflater, container, false)
        updateUI(args.kategori)
        return binding.root
    }
    private fun updateUI(kategori: KategoriBmi) {
        val actionBar = (requireActivity() as AppCompatActivity)
            .supportActionBar
        when (kategori) {
            KategoriBmi.KategoriBmi.KURUS -> {
                actionBar?.title = getString(R.string.judul_kurus)
                binding.imageView.setImageResource(R.drawable.kurus)
                binding.textView.text = getString(R.string.saran_kurus)
            }
            KategoriBmi.KategoriBmi.IDEAL -> {
                actionBar?.title = getString(R.string.judul_ideal)
                binding.imageView.setImageResource(R.drawable.ideal)
                binding.textView.text = getString(R.string.saran_ideal)
            }
            KategoriBmi.KategoriBmi.GEMUK -> {
                actionBar?.title = getString(R.string.judul_gemuk)
                binding.imageView.setImageResource(R.drawable.gemuk)
                binding.textView.text = getString(R.string.saran_gemuk)

            }
        }
        else {
            val bmi
            when {
                bmi < 18.5 -> KategoriBmi.KategoriBmi.KURUS
                bmi >= 25.0 -> KategoriBmi.KategoriBmi.GEMUK
                else -> KategoriBmi.KategoriBmi.IDEAL
            }
        }
        val stringRes = when (kategoriBmi) {
            KategoriBmi.KURUS -> R.string.kurus
            KategoriBmi.IDEAL -> R.string.ideal
            KategoriBmi.GEMUK -> R.string.gemuk
        }
        return getString(stringRes)
    }
}


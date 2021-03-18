import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import org.d3if2090.hitungbmi.R
import org.d3if2090.hitungbmi.databinding.FragmentHitungBinding

class HitungFragment {
    private lateinit var binding: FragmentHitungBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHitungBinding.inflate(
            layoutInflater, container, false)
        binding.shareButton.setOnClickListener { shareData() }
        setHasOptionsMenu(true)
        return binding.root

        private fun shareData() {
            val selectedId = binding.radioGroup.checkedRadioButtonId
            val gender = if (selectedId == R.id.priaRadioButton)
                getString(R.string.pria)
            else
                getString(R.string.wanita)
            val message = getString(R.string.bagikan_template,
                    binding.beratEditText.text,
                    binding.tinggiEditText.text,
                    gender,
                    binding.bmiTextView.text,
                    binding.kategoriTextView.text
            )
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
            if (shareIntent.resolveActivity(
                            requireActivity().packageManager) != null) {
                startActivity(shareIntent)
    }

}
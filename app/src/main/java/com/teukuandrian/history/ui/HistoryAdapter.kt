package com.teukuandrian.history.ui

import androidx.recyclerview.widget.RecyclerView
import com.teukuandrian.hitungbmi.db.BmiEntity

class HistoriAdapter : RecyclerView.Adapter<HistoriAdapter.ViewHolder>() {
    private val data = mutableListOf<BmiEntity>()
    fun updateData(newData: List<BmiEntity>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(
            private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
                Locale("id", "ID"))
        fun bind(item: BmiEntity) = with(binding) {
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            val hasilBmi = HitungBmi.hitung(item)
            kategoriTextView.text = hasilBmi.kategori.toString()
            bmiTextView.text = root.context.getString(R.string.bmi_x,
                    hasilBmi.bmi)
            beratTextView.text = root.context.getString(R.string.berat_x,
                    item.berat)
            tinggiTextView.text = root.context.getString(R.string.tinggi_x,
                    item.tinggi)
            val stringRes = if (item.isMale) R.string.pria else R.string.wanita
            genderTextView.text = root.context.getString(stringRes)
        }
    }
}
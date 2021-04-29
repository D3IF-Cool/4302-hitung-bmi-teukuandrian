package ui

import androidx.lifecycle.MutableLiveData
import com.teukuandrian.hitungbmi.data.HasilBmi
import com.teukuandrian.hitungbmi.db.BmiDao
import com.teukuandrian.hitungbmi.ui.KategoriBmi

class HitungViewModel {
    private val hasilBmi = MutableLiveData<HasilBmi?>()
    private val navigasi = MutableLiveData<KategoriBmi?>()

    fun hitungBmi(berat: String, tinggi: String, isMale: Boolean) {

            class HitungViewModel(private val db: BmiDao) : ViewModel() {
            fun selesaiNavigasi() {
                navigasi.value = null
            }

        }

        else {
            when {
                bmi < 18.5 -> KategoriBmi.KategoriBmi.KURUS
                bmi >= 25.0 -> KategoriBmi.KategoriBmi.GEMUK
                else -> KategoriBmi.KategoriBmi.IDEAL
            }
        }
        hasilBmi.value = HasilBmi(bmi, kategori)
    }
    fun getHasilBmi() : LiveData<HasilBmi?> = hasilBmi
    fun getNavigasi() : LiveData<KategoriBmi?> = navigasi
}
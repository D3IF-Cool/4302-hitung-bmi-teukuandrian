package com.teukuandrian.hitungbmi.data

import com.teukuandrian.hitungbmi.db.BmiEntity
import com.teukuandrian.hitungbmi.ui.KategoriBmi

object HitungBmi {
    fun hitung(data: BmiEntity): HasilBmi {
        val tinggiCm = data.tinggi / 100
        val bmi = data.berat / (tinggiCm * tinggiCm)
        val kategori = if (data.isMale) {
            when {
                bmi < 20.5 -> KategoriBmi.KategoriBmi.KURUS
                bmi >= 27.0 -> KategoriBmi.KategoriBmi.GEMUK
                else -> KategoriBmi.KategoriBmi.IDEAL
            }
        } else {
            when {
                bmi < 18.5 -> KategoriBmi.KategoriBmi.KURUS
                bmi >= 25.0 -> KategoriBmi.KategoriBmi.GEMUK
                else -> KategoriBmi.KategoriBmi.IDEAL
            }
        }
        return HasilBmi(bmi, kategori)
    }
}

package com.teukuandrian.hitungbmi.db

@Dao
interface BmiDao {
    @Insert
    fun insert(bmi: BmiEntity)
    @Query("SELECT * FROM bmi ORDER BY id DESC")
    fun getLastBmi(): LiveData<List<BmiEntity>>
    @Query("DELETE FROM bmi")
    fun clearData()
}
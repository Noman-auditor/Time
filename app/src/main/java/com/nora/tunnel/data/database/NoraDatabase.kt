package com.nora.tunnel.data.database
import androidx.room.*
import com.nora.tunnel.core.model.TunnelProfile
import kotlinx.coroutines.flow.Flow
@Database(entities = [TunnelProfile::class], version = 1, exportSchema = false)
abstract class NoraDatabase : RoomDatabase() { abstract fun profileDao(): ProfileDao }
@Dao
interface ProfileDao {
@Query("SELECT * FROM profiles ORDER BY updatedAt DESC") fun observeAll(): Flow<List>
@Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun upsert(profile: TunnelProfile)
@Delete suspend fun delete(profile: TunnelProfile)
}

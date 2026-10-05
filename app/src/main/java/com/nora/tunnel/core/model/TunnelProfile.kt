package com.nora.tunnel.core.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.UUID
@Serializable
@Entity(tableName = "profiles")
data class TunnelProfile(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String, val protocol: Protocol, val core: Core, val transport: Transport, val security: Security,
    val serverAddress: String, val port: Int, val username: String? = null,
    val createdAt: Long = System.currentTimeMillis(), val updatedAt: Long = System.currentTimeMillis()
) : java.io.Serializable

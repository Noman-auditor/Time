package com.nora.tunnel.tunnel
import com.nora.tunnel.core.model.TunnelProfile
import kotlinx.coroutines.flow.Flow
interface TunnelAdapter {
    suspend fun validate(profile: TunnelProfile): Result<Unit>
    suspend fun prepare(profile: TunnelProfile): Result<Unit>
    suspend fun connect(profile: TunnelProfile, vpnService: NoraVpnService): Result<ConnectionState>
    suspend fun disconnect()
    fun status(): Flow<ConnectionState>
}
enum class ConnectionState { IDLE, VALIDATING, PREPARING, CONNECTING, CONNECTED, ERROR }

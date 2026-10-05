package com.nora.tunnel.tunnel
import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import com.nora.tunnel.core.model.TunnelProfile
import com.nora.tunnel.data.datastore.*
import kotlinx.coroutines.*
class NoraVpnService : VpnService() {
    private var vpnInterface: ParcelFileDescriptor? = null
    companion object {
        const val ACTION_CONNECT = "com.nora.tunnel.CONNECT"
        const val ACTION_DISCONNECT = "com.nora.tunnel.DISCONNECT"
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == ACTION_CONNECT) {
            val profile = intent.getSerializableExtra("profile") as? TunnelProfile
            if (profile != null) establishVpn(profile)
        }
        return START_NOT_STICKY
    }
    private fun establishVpn(profile: TunnelProfile) {
        val builder = Builder().addAddress("10.8.0.2", 32).addRoute("0.0.0.0", 0).setSession(profile.name)
        vpnInterface = builder.establish()
    }
    override fun onDestroy() { vpnInterface?.close(); super.onDestroy() }
}

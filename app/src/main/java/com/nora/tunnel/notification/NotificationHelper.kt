package com.nora.tunnel.notification
import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import com.nora.tunnel.core.model.TunnelProfile
object NotificationHelper {
    fun createChannel(context: Context) {}
    fun build(context: Context, profile: TunnelProfile, any: Any): Notification {
        return NotificationCompat.Builder(context, "nora_vpn").setContentTitle(profile.name).build()
    }
}

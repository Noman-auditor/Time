package com.nora.tunnel.data.datastore
enum class Mode { ALL, SELECTED, EXCLUDED }
data class AppRoutingPrefs(val mode: Mode, val apps: List<String>)
object DataStoreManager {
    fun getAppRoutingMode(): AppRoutingPrefs = AppRoutingPrefs(Mode.ALL, emptyList())
}

package com.nora.tunnel.core
import com.nora.tunnel.core.model.*
object CapabilityRegistry {
    data class Capability(val core: Core, val protocols: Set<Protocol>, val transports: Set<Transport>)
    val registry = listOf(
        Capability(Core.XRAY, setOf(Protocol.VLESS, Protocol.VMess, Protocol.TROJAN, Protocol.SHADOWSOCKS), setOf(Transport.TCP, Transport.WS, Transport.GRPC, Transport.QUIC, Transport.TLS)),
        Capability(Core.WIREGUARD, setOf(Protocol.WIREGUARD), setOf(Transport.UDP))
    )
    fun getTransports(protocol: Protocol, core: Core): Set<Transport> {
        return registry.find { it.core == core && protocol in it.protocols }?.transports ?: emptySet()
    }
    fun isValid(p: Protocol, c: Core, t: Transport) = t in getTransports(p,c)
}

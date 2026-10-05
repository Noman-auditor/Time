package com.nora.tunnel.core.model
enum class Protocol { VLESS, VMess, TROJAN, SHADOWSOCKS, HYSTERIA2, TUIC, WIREGUARD, OPENVPN, SSH }
enum class Core { XRAY, SINGBOX, WIREGUARD, OPENVPN, SSH }
enum class Transport { TCP, UDP, WS, GRPC, QUIC, TLS }
enum class Security { NONE, TLS, REALITY }

package com.vitamin.challenge.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration

@ConstructorBinding
@Configuration
@ConfigurationProperties(prefix = "services.fmp")
data class FmpProperties(
    var apiHost: String = "",
    var apiKey: String = "",
)

package com.cognifide.gradle.sling.pkg.deploy

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper

@JsonIgnoreProperties(ignoreUnknown = true)
class UninstallResponse : PackageResponse() {

    override val success: Boolean
        get() =  (operation == "uninstallation" && status == "done")

    @JsonProperty("package")
    lateinit var pkg: Package

    companion object {
        fun fromJson(json: String): UninstallResponse {
            return ObjectMapper().readValue(json, UninstallResponse::class.java)
        }
    }
}
val kotlinVersion: String by project
val logbackVersion: String by project
val koinVersion: String by project
val ktorVersion: String by project

plugins {
    kotlin("jvm") version "1.9.10" // 與 Kotlin 版本一致
    id("io.ktor.plugin") version "2.3.1" // 與 Ktor 版本一致
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10" // 與 Kotlin 版本一致
}


group = "com.purplestudio"
version = "0.0.1"

application {
    // 設置 Ktor 的主類
    mainClass.set("io.ktor.server.netty.EngineMain")

    // 檢查是否處於開發模式
    val isDevelopment: Boolean = project.hasProperty("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-server-call-logging")
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation("io.ktor:ktor-server-default-headers:$ktorVersion")
    implementation("io.ktor:ktor-server-netty")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    implementation("io.ktor:ktor-server-status-pages:$ktorVersion")
    implementation("io.ktor:ktor-server-call-logging:$ktorVersion")
    implementation("io.insert-koin:koin-ktor:$koinVersion")
    implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")

}

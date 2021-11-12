plugins {
    kotlin("jvm") version "1.5.31"
    java
    application
}

group = "com.giathuan.examples.fibonacci"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.giathuan.examples.fibonacci.FibonacciServer")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    // grpc-java (with protos)
    implementation("com.google.protobuf:protobuf-java:3.19.1")
    implementation("com.google.api.grpc:proto-google-common-protos:2.6.0")
    implementation("io.grpc:grpc-netty-shaded:1.42.0")
    implementation("io.grpc:grpc-protobuf:1.42.0")
    implementation("io.grpc:grpc-stub:1.42.0")
    implementation("io.grpc:grpc-services:1.42.0")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53") // necessary for Java 9+

    //
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

val majorJdkVersion = "16"
kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(majorJdkVersion)) // "8"
    }
}

sourceSets {
    main {
        java.srcDir("src/gen/java")
    }
}
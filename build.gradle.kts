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

/**
 * This is a single standard snippet for generating a fat jar using Gradle and the default `jar task` which is part of
 * the build process. Hence, to generate a jar, simply run:
 *     ./gradlew build
 *
 * Then you can run the jar file by running:
 *     java -jar build/libs/${project.name}-${project.version}.jar
;
 * By default, without this configuration, the `jar task` will still generate a jar file but without (1) "Main-Class"
 * attribute and (2) dependencies.
 * */
tasks.jar {
    // [optional]
    // We can rename the jar file to build/libs/${project.name}.jar for convenience.
    archiveFileName.set(project.name + ".jar")

    // Since there is no "Main-Class" by default, we need to add it.
    manifest {
        attributes("Main-Class" to "com.giathuan.examples.fibonacci.FibonacciServer")
    }

    // Since there is no dependencies included by default, we need to add them.
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
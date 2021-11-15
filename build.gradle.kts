plugins {
  kotlin("jvm") version "1.5.31"
  java
  application
  id("com.palantir.docker") version "0.30.0"
}

group = "com.giathuan.examples.fibonacci"

version = "1.0-SNAPSHOT"

application { mainClass.set("com.giathuan.examples.fibonacci.FibonacciServer") }

repositories { mavenCentral() }

dependencies {
  implementation("com.google.flogger:flogger:0.7.1")
  runtimeOnly("com.google.flogger:flogger-system-backend:0.7.1")
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

  // grpc-kotlin
  implementation("io.grpc:grpc-kotlin-stub:1.2.0")

  // test-containers
  testImplementation("org.testcontainers:testcontainers:1.16.2")
  testImplementation("org.testcontainers:junit-jupiter:1.16.2")
}

tasks.getByName<Test>("test") { useJUnitPlatform() }

val majorJdkVersion = "16"

kotlin {
  jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(majorJdkVersion)) // "8"
  }
}

sourceSets { main { java.srcDirs("src/gen/java", "src/gen/kotlin") } }

/**
 * This is a single standard snippet for generating a fat jar using Gradle and the default `jar
 * task` which is part of the build process. Hence, to generate a jar, simply run:
 * ```
 *     ./gradlew build
 * ```
 * Then you can run the jar file by running:
 * ```
 *     java -jar build/libs/${project.name}-${project.version}.jar
 * ```
 * By default, without this configuration, the `jar task` will still generate a jar file but without
 * (1) "Main-Class" attribute and (2) dependencies.
 */
tasks.jar {
  // [optional]
  // We can rename the jar file to build/libs/${project.name}.jar for convenience.
  archiveFileName.set(project.name + ".jar")

  // Since there is no "Main-Class" by default, we need to add it.
  manifest { attributes("Main-Class" to "com.giathuan.examples.fibonacci.FibonacciServer") }

  // Since there is no dependencies included by default, we need to add them.
  from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
  duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

/**
 * This is a single standard snippet for generating a docker image using com.palantir.docker plugin.
 * To generate the image, run:
 * ```
 *     ./gradlew docker
 * ```
 * After that the image will be available in the local docker registry and can be viewed by running:
 * ```
 *     docker ps
 * ```
 * Then we can run the image by running:
 * ```
 *     docker run -it -p 9999:9999 hub.docker.com/duckladydinh/fibonacci-jvm-server:1.0-SNAPSHOT
 * ```
 * where -it = interactive and -p = mapping from host port to container port.
 */
docker {
  // Since the jar file won't be generated before the build, we have to depend on it.
  val buildTask = tasks.build.get()
  dependsOn(buildTask)

  // The name of your image.
  name = "hub.docker.com/duckladydinh/${project.name}:${project.version}"

  // Files that will be available when building the docker image.
  // This command will copy build/libs/${project.name}.jar into ${project.name}.jar in docker build
  // environment.
  files("build/libs/${project.name}.jar")
}

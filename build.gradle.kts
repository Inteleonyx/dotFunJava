plugins {
    id("java")
}

group = "dev.inteleonyx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //Antlr
    compileOnly("org.antlr:antlr4-runtime:4.13.2")

    //Lombok
    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
    testCompileOnly("org.projectlombok:lombok:1.18.42")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.42")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
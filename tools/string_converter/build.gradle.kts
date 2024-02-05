@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    kotlin("jvm") version "1.9.20"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.opencsv:opencsv:5.9")
    //  implementation("org.redundent:kotlin-xml-builder:1.9.1")
    implementation("org.jdom:jdom2:2.0.6")
}

/**
 * CSV-XML conversion task.
 */
val convertString by tasks.registering(JavaExec::class) {
    group = "tools"
    classpath = java.sourceSets["main"].runtimeClasspath
    mainClass.set("com.wa2c.android.cifsdocumentsprovider.tools.string_converter.CsvXmlConversion")
    args(
        File(projectDir, "strings.csv").canonicalPath,
        File(projectDir, "../../presentation/src/main/res/").canonicalPath,
        "https://docs.google.com/spreadsheets/d/1y71DyM31liwjcAUuPIk3CuIqxJD2l9Y2Q-YZ0I0XE_E/export?format=csv#gid=0"
    )
}

/*
repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compile 'com.opencsv:opencsv:5.9'
    compile 'org.jdom:jdom2:2.0.6'
}

task convertString(type: JavaExec) {
    group = 'tools'
    classpath = sourceSets.main.runtimeClasspath
    main = 'com.wa2c.android.cifsdocumentsprovider.tools.string_converter.CsvXmlConversion'
    args(
            new File(projectDir, 'strings.csv').canonicalPath,
            new File(projectDir, '../../presentation/src/main/res/').canonicalPath,
            'https://docs.google.com/spreadsheets/d/1y71DyM31liwjcAUuPIk3CuIqxJD2l9Y2Q-YZ0I0XE_E/export?format=csv#gid=0'
    )
}
 */

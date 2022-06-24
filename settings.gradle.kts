dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        maven { url = uri("https://jitpack.io") }
    }
}
rootProject.name = "The Movie DB"
include (":app")

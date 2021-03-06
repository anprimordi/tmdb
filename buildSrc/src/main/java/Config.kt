object Config {

    const val SDK_MINIMUM_VERSION: Int = 25
    const val SDK_TARGET_VERSION: Int = 32
    const val SDK_COMPILE_VERSION: Int = 32

    const val BUILD_TOOLS_VERSION: String = "30.0.3"

    const val APP_ID: String = "com.tmdb.app"
    const val APP_VERSION_CODE: Int = 1
    const val APP_VERSION_NAME: String = "0.0.1"

    const val KEYSTORE_PATH: String = "/app/release_keystore.jks"
    const val KEYSTORE_ALIAS: String = "key_tmdb"
    const val KEYSTORE_PASSWORD: String = "tmdb23062022"

    object BuildType {
        const val DEBUG: String = "debug"
        const val RELEASE: String = "release"
    }

}
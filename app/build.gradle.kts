import AppProperty.Field
import AppProperty.TYPE_NUMBER
import AppProperty.TYPE_RES_STRING
import AppProperty.TYPE_TEXT

plugins {
    id(Plugin.ANDROID)
    id(Plugin.KOTLIN_ANDROID)
    id(Plugin.KOTLIN_PARCELIZE)
    id(Plugin.KOTLIN_KAPT)
//    id(Plugin.GOOGLE_SERVICES)
//    id(Plugin.FIREBASE_CRASHLYTICS)
    id(Plugin.JETPACK_NAVIGATION)
    id(Plugin.JETPACK_HILT)
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Config.SDK_COMPILE_VERSION
    buildToolsVersion = Config.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = Config.SDK_MINIMUM_VERSION
        targetSdk = Config.SDK_TARGET_VERSION

        applicationId = Config.APP_ID
        versionCode = Config.APP_VERSION_CODE
        versionName = Config.APP_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create(Config.BuildType.RELEASE) {
            storeFile = file("${rootProject.rootDir}${Config.KEYSTORE_PATH}")
            storePassword = Config.KEYSTORE_PASSWORD
            keyAlias = Config.KEYSTORE_ALIAS
            keyPassword = Config.KEYSTORE_PASSWORD
        }
    }

    buildTypes {
        getByName(Config.BuildType.DEBUG) {
            applicationIdSuffix = Field.Debug.APP_ID_SUFFIX
            versionNameSuffix = Field.Debug.APP_VERSION_NAME_SUFFIX

            resValue(TYPE_RES_STRING, AppProperty.APP_NAME, Field.Debug.APP_NAME)
            buildConfigField(TYPE_TEXT, AppProperty.PREF_NAME, Field.Debug.PREF_NAME)
            buildConfigField(TYPE_TEXT, AppProperty.DB_NAME, Field.Debug.DB_NAME)
            buildConfigField(TYPE_NUMBER, AppProperty.DB_VERSION, Field.Debug.DB_VERSION)
            buildConfigField(TYPE_TEXT, AppProperty.SERVER_URL, Field.Debug.SERVER_URL)
            buildConfigField(TYPE_TEXT, AppProperty.IMAGE_URL, Field.Debug.IMAGE_URL)
            buildConfigField(TYPE_TEXT, AppProperty.API_KEY, Field.Debug.API_KEY)
        }

        getByName(Config.BuildType.RELEASE) {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName(Config.BuildType.RELEASE)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            resValue(TYPE_RES_STRING, AppProperty.APP_NAME, Field.Release.APP_NAME)
            buildConfigField(TYPE_TEXT, AppProperty.PREF_NAME, Field.Release.PREF_NAME)
            buildConfigField(TYPE_TEXT, AppProperty.DB_NAME, Field.Release.DB_NAME)
            buildConfigField(TYPE_NUMBER, AppProperty.DB_VERSION, Field.Release.DB_VERSION)
            buildConfigField(TYPE_TEXT, AppProperty.SERVER_URL, Field.Release.SERVER_URL)
            buildConfigField(TYPE_TEXT, AppProperty.IMAGE_URL, Field.Debug.IMAGE_URL)
            buildConfigField(TYPE_TEXT, AppProperty.API_KEY, Field.Debug.API_KEY)
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    kapt(Dependency.Jetpack.HILT_COMPILER)
    kapt(Dependency.Jetpack.ROOM_COMPILER)
    kapt(Dependency.GLIDE_COMPILER)

    implementation(Dependency.Kotlin.LANG)
    implementation(Dependency.Kotlin.COROUTINES)
    implementation(Dependency.Kotlin.COROUTINES_ANDROID)
    implementation(Dependency.Kotlin.COROUTINES_PLAY_SERVICES)

    implementation(Dependency.Jetpack.BROWSER)
    implementation(Dependency.Jetpack.CORE)
    implementation(Dependency.Jetpack.HILT)
    implementation(Dependency.Jetpack.HILT_NAVIGATION)
    implementation(Dependency.Jetpack.LEGACY)
    implementation(Dependency.Jetpack.LIFECYCLE)
    implementation(Dependency.Jetpack.LIVE_DATA)
    implementation(Dependency.Jetpack.MULTI_DEX)
    implementation(Dependency.Jetpack.NAVIGATION_FRAGMENT)
    implementation(Dependency.Jetpack.NAVIGATION_UI)
    implementation(Dependency.Jetpack.PAGING)
    implementation(Dependency.Jetpack.ROOM)
    implementation(Dependency.Jetpack.ROOM_RUNTIME)
    implementation(Dependency.Jetpack.VIEW_MODEL)

    implementation(Dependency.Jetpack.UI.APP_COMPAT)
    implementation(Dependency.Jetpack.UI.ACTIVITY)
    implementation(Dependency.Jetpack.UI.FRAGMENT)

    implementation(Dependency.Jetpack.UI.MATERIAL)
    implementation(Dependency.Jetpack.UI.CARD_VIEW)
    implementation(Dependency.Jetpack.UI.CONSTRAINT_LAYOUT)
    implementation(Dependency.Jetpack.UI.RECYCLER_VIEW)

//    implementation(Dependency.GoogleService.AUTH)
//    implementation(Dependency.GoogleService.LOCATION)
//    implementation(Dependency.GoogleService.MAPS)

//    implementation(platform(Dependency.Firebase.BOM))
//    implementation(Dependency.Firebase.AUTH)
//    implementation(Dependency.Firebase.MESSAGING)
//    implementation(Dependency.Firebase.CRASHLYTICS)
//    implementation(Dependency.Firebase.ANALYTICS)

    implementation(Dependency.COMPRESSOR)
    implementation(Dependency.GLIDE)
    implementation(Dependency.HTTP_INTERCEPTOR)
    implementation(Dependency.IMAGE_PICKER)
    implementation(Dependency.IMAGE_VIEWER)
    implementation(Dependency.RETROFIT)
    implementation(Dependency.RETROFIT_CONVERTER)
    implementation(Dependency.TIMBER)
    implementation(Dependency.SHIMMER)
    implementation(Dependency.SIGNATURE_PAD)

//    implementation(Dependency.PIN_VIEW)
//    implementation(Dependency.CODE_SCANNER)

    debugImplementation(Dependency.CHUCKER_DEBUG)
    releaseImplementation(Dependency.CHUCKER_RELEASE)

    testImplementation(Dependency.Testing.JUNIT)
    androidTestImplementation(Dependency.Testing.ESPRESSO)
    androidTestImplementation(Dependency.Testing.JUNIT_EXT)
}
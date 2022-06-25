object AppProperty {

    //region Property Types
    const val TYPE_TEXT: String = "String"
    const val TYPE_NUMBER: String = "int"
    const val TYPE_RES_STRING: String = "string"
    //endregion Property Types

    //region Property Names
    const val APP_NAME: String = "app_name"
    const val PREF_NAME: String = "PREF_NAME"
    const val DB_NAME: String = "DB_NAME"
    const val DB_VERSION: String = "DB_VERSION"
    const val SERVER_URL: String = "SERVER_URL"
    const val IMAGE_URL: String = "IMAGE_URL"
    const val API_KEY: String = "API_KEY"
    //endregion Property Names

    object Field {
        const val APP_NAME: String = "The Movie DB"

        object Debug {
            const val APP_ID_SUFFIX: String = ".debug"
            const val APP_NAME: String = "${Field.APP_NAME} Debug"
            const val APP_VERSION_NAME_SUFFIX: String = "-debug"
            const val PREF_NAME: String = "\"tmdb_shared_pref-debug\""
            const val DB_NAME: String = "\"tmdb_database-debug\""
            const val DB_VERSION: String = "2"
            const val SERVER_URL: String = "\"https://api.themoviedb.org\""
            const val IMAGE_URL: String = "\"https://image.tmdb.org/t/p/w500\""
            const val API_KEY: String = "\"0da556d084d606d8ba7d1140c7c9a69a\""
        }

        object Release {
            const val APP_NAME: String = Field.APP_NAME
            const val PREF_NAME: String = "\"tmdb_shared_pref\""
            const val DB_NAME: String = "\"tmdb_database\""
            const val DB_VERSION: String = "1"
            const val SERVER_URL: String = "\"https://api.themoviedb.org\""
            const val IMAGE_URL: String = "\"https://image.tmdb.org/t/p/w500\""
            const val API_KEY: String = "\"0da556d084d606d8ba7d1140c7c9a69a\""
        }
    }

}
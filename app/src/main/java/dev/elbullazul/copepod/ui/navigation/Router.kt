package dev.elbullazul.copepod.ui.navigation

class Router {
    private val routes = LinkedHashMap<String, String>()
    private val remote_routes = LinkedHashMap<String, String>()

    constructor() {
        // TODO: how to process groups on other servers?
        // more specific regexes before the more general ones

        // groups
        // kbin
        remote_routes["/c/.*@.*"] = "group/$1/$2"   // ex. /c/linux@lemmy.world
        routes["/c/.*"] = "group/$1"                // ex. /c/linux

        // lemmy
        remote_routes["/m/.*@.*"] = "group/$1/$2"   // ex. /m/linux@fedia.io
        routes["/m/.*"] = "group/$1"                // ex. /m/linux

        // users
        // kbin
        remote_routes["/u/@.*@.*"] = "user/$1/$2"   // ex. /u/@user@fedia.io
        routes["/u/.*"] = "user/$1"                 // ex. /u/@user

        // lemmy
        remote_routes["/u/.*@.*"] = "user/$1/$2"    // ex. /u/user@lemmy.world
        routes["/u/.*"] = "user/$1"                 // ex. /u/user

        // calckey, misskey, mastodon, etc.
        remote_routes["/@.*@.*"] = "user/$1/$2"     // ex. /@user@calckey.world
        routes["/@.*"] = "user/$1"                  // ex. /@user
    }

    fun Route(path: String): String {
        // TODO: match path with regex on routes
        for ((key, value) in routes) {

        }

        // if route matches key, return the value route with replaced arguments
        var destRoute = ""

        return destRoute
    }
}
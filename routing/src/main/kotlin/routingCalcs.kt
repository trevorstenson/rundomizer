import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

const val EARTH_RADIUS = 6_371_000

const val DOCKER_URL = "http://127.0.0.1"
const val DOCKER_PORT = 5000

fun main() {
    val totalDistance = 5.0
    val totalMeters = totalDistance * 1_609.344
    val lat = 42.329129
    val long = -71.086484

    val test = runBlocking {
        calculateRoute(
            totalMeters,
            totalMeters * .2,
            Coordinates(lat, long),
            Coordinates(lat, long)
        )
    }

    println(test)
}

suspend fun calculateRoute(
    remainingDistance: Double,
    cutoffDistance: Double,
    location: Coordinates,
    startLocation: Coordinates
): List<RouteInfo> {
    val halfDistance = remainingDistance / 2
    val lat = location.lat * Math.PI / 180
    val lon = location.long * Math.PI / 180

    val maxDistance = halfDistance * .25
    val minDistance = halfDistance * .1


    val distance = sqrt(Random.nextDouble() * (maxDistance.pow(2) - minDistance.pow(2) + minDistance.pow(2)))
    val deltaLat = cos(Random.nextDouble() * Math.PI) * distance / EARTH_RADIUS
    val sign = (Random.nextDouble() * 2) * 2 - 1
    val deltaLon = sign * acos(((cos(distance / EARTH_RADIUS) - cos(deltaLat)) / (cos(lat) * cos(deltaLat + lat))) + 1)

    val newLocation = Coordinates((lat + deltaLat) * 180 / Math.PI, (lon + deltaLon) * 180 / Math.PI)

    val route = mutableListOf<RouteInfo>()

    val client = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }


    route += client.getRouteLeg(location, newLocation)

    //FIXME: What should be done if this distance is null?
    val restDistance = remainingDistance - route.last().routes.first().distance!!
    println("Remaining: $restDistance")

    //FIXME: Taken from the python code, does not completely make sense
    if (cutoffDistance >= restDistance) {
        route += client.getRouteLeg(newLocation, startLocation)
    } else {
        route += calculateRoute(restDistance, cutoffDistance, newLocation, startLocation)
    }

    client.close()

    return route
}

suspend fun HttpClient.getRouteLeg(start: Coordinates, end: Coordinates): RouteInfo {
    val url =
        "$DOCKER_URL:$DOCKER_PORT" +
                "/route/v1/foot/" +
                "${start.long},${start.lat};" +
                "${end.long},${end.lat}" +
                "?steps=true&annotations=true"

    return get(url)
}

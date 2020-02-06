import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class RouteInfo(
    val code: String? = null,
    val routes: List<Route> = emptyList(),
    val waypoints: List<Waypoint> = emptyList()
)

@Serializable
data class Intersection(
    val bearings: List<Double> = emptyList(),
    val entry: List<Boolean> = emptyList(),
    @SerialName("in")
    val inX: Double? = null,
    @SerialName("out")
    val outX: Double? = null,
    val location: List<Double> = emptyList(),
    val lanes: List<Lane>? = emptyList(),
    val classes: List<String>? = emptyList()
)

@Serializable
data class Lane (
    val valid: Boolean? = null,
    val indications: List<String> = emptyList()
)

@Serializable
data class Annotation(
    val datasources: List<Double> = emptyList(),
    val distance: List<Double> = emptyList(),
    val duration: List<Double> = emptyList(),
    val metadata: Metadata? = null,
    val nodes: List<Double> = emptyList(),
    val speed: List<Double> = emptyList(),
    val weight: List<Double> = emptyList()
)

@Serializable
data class Maneuver(
    @SerialName("bearing_after")
    val bearingAfter: Double? = null,
    @SerialName("bearing_before")
    val bearingBefore: Double? = null,
    private val location: List<Double> = emptyList(),
    val type: String? = null,
    val modifier: String? = null,
    val exit: String? = null
) {
    @Transient
    val coordinates = Coordinates(location[1], location[0])
}

@Serializable
data class Route(
    val distance: Double? = null,
    val duration: Double? = null,
    val geometry: String? = null,
    val legs: List<Leg> = emptyList(),
    val weight: Double? = null,
    @SerialName("weight_name")
    val weightName: String? = null
)

@Serializable
data class Metadata(
    @SerialName("datasource_names")
    val datasourceNames: List<String> = emptyList()
)

@Serializable
data class Leg(
    @SerialName("annotation")
    val `annotation`: Annotation?,
    val distance: Double? = null,
    val duration: Double? = null,
    val steps: List<Step> = emptyList(),
    val summary: String? = null,
    val weight: Double? = null
)

@Serializable
data class Waypoint(
    val distance: Double? = null,
    val hint: String? = null,
    val location: List<Double> = emptyList(),
    val name: String? = null
)

@Serializable
data class Step(
    val distance: Double? = null,
    @SerialName("driving_side")
    val drivingSide: String? = null,
    val duration: Double? = null,
    val geometry: String? = null,
    val intersections: List<Intersection> = emptyList(),
    val maneuver: Maneuver? = null,
    val mode: String? = null,
    val name: String? = null,
    val weight: Double? = null,
    val ref: String? = null,
    val destinations: String? = null,
    val exits: String? = null
)

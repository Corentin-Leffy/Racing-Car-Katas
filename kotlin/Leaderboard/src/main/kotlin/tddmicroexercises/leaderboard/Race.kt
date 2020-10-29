package tddmicroexercises.leaderboard

class Race(private val name: String, vararg drivers: Driver) {
    val results: List<Driver> = arrayListOf(*drivers)
    private val driverNames: MutableMap<Driver, String> = HashMap()

    init {
        for (driver in results) {
            driverNames[driver] = driver.name
        }
    }

    private fun position(driver: Driver): Int = results.indexOf(driver)

    fun getPoints(driver: Driver): Int = POINTS[position(driver)]

    fun getDriverName(driver: Driver): String? = driverNames[driver]

    override fun toString(): String = name

    companion object {
        private val POINTS = arrayOf(25, 18, 15)
    }
}

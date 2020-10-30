package tddmicroexercises.leaderboard

class Race(private val name: String, vararg drivers: Driver) {
    private val results: List<Driver> = arrayListOf(*drivers)
    private val driverNames: MutableMap<Driver, String> = results.associateByTo(mutableMapOf(), { it }, Driver::name)

    private fun position(driver: Driver): Int = results.indexOf(driver)

    private fun getPoints(driver: Driver): Int = POINTS[position(driver)]

    private fun getDriverName(driver: Driver): String = driverNames[driver] ?: error("Driver ${driver.name} not found")

    override fun toString(): String = name

    fun getResults(): Results = results.associateBy(this@Race::getDriverName, this@Race::getPoints)

    companion object {
        private const val FIRST_PLACE = 25
        private const val SECOND_PLACE = 18
        private const val THIRD_PLACE = 15
        private val POINTS = arrayOf(
            FIRST_PLACE,
            SECOND_PLACE,
            THIRD_PLACE
        )
    }
}

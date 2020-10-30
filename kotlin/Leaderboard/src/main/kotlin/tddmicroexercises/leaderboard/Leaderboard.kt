package tddmicroexercises.leaderboard

import java.util.*
import kotlin.collections.ArrayList

typealias Results = Map<String, Int>
typealias DriversName = List<String>

class Leaderboard(vararg races: Race) {

    private val races: Races = Races(*races)

    fun driverResults(): Results {
        return races.map(Race::getResults)
            .asSequence()
            .flatMap { it.asSequence() }
            .groupBy({ it.key }) { it.value }
            .mapValues { it.value.sum() }
    }

    fun driverRankings(): DriversName {
        val results = driverResults()
        val driversName = ArrayList(results.keys)
        driversName.sortWith(DriverByPointsDescendingComparator(results))
        return driversName
    }

    private class DriverByPointsDescendingComparator(
        private val results: Results
    ) : Comparator<String> {

        override fun compare(aDriverName: String, anotherDriverName: String): Int =
            -pointFor(aDriverName).compareTo(pointFor(anotherDriverName))

        private fun pointFor(driverName: String) = results[driverName] ?: error("$driverName does not exist")
    }
}

package tddmicroexercises.leaderboard

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import tddmicroexercises.leaderboard.TestData.driver1
import tddmicroexercises.leaderboard.TestData.driver2
import tddmicroexercises.leaderboard.TestData.driver3

class LeaderboardTest {

    @Test
    fun `Should sum the points`() {
        // setup

        // act
        val results = TestData.sampleLeaderboard1.driverResults()

        // verify
        assertTrue("results $results", results.containsKey("Lewis Hamilton"))
        assertEquals((18 + 18 + 25).toLong(), (results["Lewis Hamilton"] as Int).toLong())
    }

    @Test
    fun `Should find the winner`() {
        // setup

        // act
        val result = TestData.sampleLeaderboard1.driverRankings()

        // verify
        assertEquals("Lewis Hamilton", result[0])
    }

    @Test
    fun `Should keep all drivers when same points`() {
        // setup
        // bug, drops drivers with same points
        val winDriver1 = Race("Australian Grand Prix", driver1, driver2, driver3)
        val winDriver2 = Race("Malaysian Grand Prix", driver2, driver1, driver3)
        val exEquoLeaderBoard = Leaderboard(winDriver1, winDriver2)

        // act
        val rankings = exEquoLeaderBoard.driverRankings()

        // verify
        assertEquals(arrayListOf(driver1.name, driver2.name, driver3.name), rankings)
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}

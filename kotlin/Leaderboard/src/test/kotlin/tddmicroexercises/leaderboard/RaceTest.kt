package tddmicroexercises.leaderboard

import org.junit.Assert.assertEquals
import org.junit.Test

class RaceTest {

    @Test
    fun `should calculate driver points`() {
        // setup

        // act

        // verify
        assertEquals(25, TestData.race1.getPoints(TestData.driver1))
        assertEquals(18, TestData.race1.getPoints(TestData.driver2))
        assertEquals(15, TestData.race1.getPoints(TestData.driver3))
    }

}

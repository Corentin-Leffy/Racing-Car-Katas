package tddmicroexercises.leaderboard

import org.junit.Assert.assertEquals
import org.junit.Test

class RaceTest {

    @Test
    fun `should calculate driver points`() {
        // setup

        // act

        // verify
        assertEquals(TestData.resultForRace1, TestData.race1.getResults())
    }

}

package tddmicroexercises.leaderboard

object TestData {

    val driver1: Driver = CountryDriver("Nico Rosberg", "DE")
    val driver2: Driver = CountryDriver("Lewis Hamilton", "UK")
    val driver3: Driver = CountryDriver("Sebastian Vettel", "DE")
    val driver4: Driver = AutomaticDriver("1.3", "Acme")

    val race1: Race = Race("Australian Grand Prix", driver1, driver2, driver3)
    val race2: Race = Race("Malaysian Grand Prix", driver3, driver2, driver1)
    val race3: Race = Race("Chinese Grand Prix", driver2, driver1, driver3)
    val race4: Race = Race("Fictional Grand Prix 1", driver1, driver2, driver4)
    val race5: Race = Race("Fictional Grand Prix 2", driver4, driver2, driver1)
    val race6: Race = Race("Fictional Grand Prix 3", driver2, driver1, driver4)

    val resultForRace1: Results = hashMapOf("Nico Rosberg" to 25, "Lewis Hamilton" to 18, "Sebastian Vettel" to 15)

    val sampleLeaderboard1: Leaderboard = Leaderboard(race1, race2, race3)
    val sampleLeaderboard2: Leaderboard = Leaderboard(race4, race5, race6)
}

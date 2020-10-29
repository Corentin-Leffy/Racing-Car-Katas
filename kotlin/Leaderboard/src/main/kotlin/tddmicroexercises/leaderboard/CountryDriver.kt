package tddmicroexercises.leaderboard

data class CountryDriver(
    override val name: String,
    private val country: String
) : Driver
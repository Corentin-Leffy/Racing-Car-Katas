package tddmicroexercises.leaderboard

class AutomaticDriver(
    var algorithmVersion: String,
    company: String,
    override val name: String = "Self Driving Car - $company ($algorithmVersion)"
) : Driver

package tddmicroexercises.leaderboard

class Races(vararg races: Race) : List<Race> by arrayListOf(*races)
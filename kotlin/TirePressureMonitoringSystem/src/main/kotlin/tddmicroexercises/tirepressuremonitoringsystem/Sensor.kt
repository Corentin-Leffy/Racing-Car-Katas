package tddmicroexercises.tirepressuremonitoringsystem

interface Sensor {
    fun popNextPressurePsiValue(): Double
}
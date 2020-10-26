package tddmicroexercises.tirepressuremonitoringsystem

class SafetyRange(
        private val lowThreshold: Double,
        private val highThreshold: Double
) {
    fun isNotSafe(value: Double) =
            value < lowThreshold || highThreshold < value
}

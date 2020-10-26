package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(
        private var sensor: Sensor = SimulatedSensor()
) {
    private val safetyRange = SafetyRange(LowPressureThreshold, HighPressureThreshold)
    var isAlarmOn = false
        internal set

    fun check() {
        val psiPressureValue = sensor.popNextPressurePsiValue()

        if (psiPressureValue.isNotSafe()) {
            isAlarmOn = true
        }
    }

    private fun Double.isNotSafe() = safetyRange.isNotSafe(this)

    companion object {
        private const val LowPressureThreshold = 17.0
        private const val HighPressureThreshold = 21.0
    }
}

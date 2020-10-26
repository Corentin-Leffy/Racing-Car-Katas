package tddmicroexercises.tirepressuremonitoringsystem

import java.util.*

// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

class SimulatedSensor : Sensor {

    override fun popNextPressurePsiValue(): Double = OFFSET + samplePressure()

    companion object {
        const val OFFSET = 16.0

        private fun samplePressure(): Double {
            // placeholder implementation that simulate a real sensor in a real tire
            val basicRandomNumbersGenerator = Random()
            return 6.0 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble()
        }
    }
}

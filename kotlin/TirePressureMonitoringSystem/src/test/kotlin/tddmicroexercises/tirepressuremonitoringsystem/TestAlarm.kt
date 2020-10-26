package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TestAlarm {

    private val sensorWithHighPressure = TestableSensor(22.0)
    private val sensorWithNormalPressure = TestableSensor(20.0)
    private val sensorWithLowPressure = TestableSensor(16.0)

    @Test
    fun `Alarm is off at first`() {
        val alarm = Alarm()
        assertFalse(alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is on when pressure is too low`() {
        val alarm = Alarm(sensorWithLowPressure)
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is on when pressure is too high`() {
        val alarm = Alarm(sensorWithHighPressure)
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is off when pressure is normal`() {
        val alarm = Alarm(sensorWithNormalPressure)
        alarm.check()
        assertFalse(alarm.isAlarmOn)
    }
}

class TestableSensor(
    private val pressureValue: Double
) : Sensor {
    override fun popNextPressurePsiValue(): Double = pressureValue
}

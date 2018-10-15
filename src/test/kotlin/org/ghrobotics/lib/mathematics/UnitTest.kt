package org.ghrobotics.lib.mathematics

import org.ghrobotics.lib.mathematics.units.feet
import org.ghrobotics.lib.mathematics.units.inch
import org.ghrobotics.lib.mathematics.units.meter
import org.ghrobotics.lib.mathematics.units.nativeunits.*
import org.ghrobotics.lib.mathematics.units.second
import org.junit.Test

class UnitTest {

    private val settings = NativeUnitLengthModel(
        1440.STU,
        3.0.inch
    )

    @Test
    fun testNativeUnits() {
        val nativeUnits = 360.STU.toModel(settings)

        assert(nativeUnits.inch.asDouble epsilonEquals 4.71238898038469)
    }

    @Test
    fun testVelocitySTU() {
        val one = 1.meter per 1.second

        val two = one.fromModel(settings)

        assert(two.STUPer100ms.asDouble epsilonEquals 30076.52467878338)
    }

    @Test
    fun testAccelerationSTU() {
        val one = 1.meter per 1.second per 1.second

        val two = one.fromModel(settings)

        assert(two.STUPer100msPerSecond.asDouble epsilonEquals 30076.52467878338)
    }

    @Test
    fun testFeetToMeter() {
        val one = 1.feet

        assert(one.meter.asDouble epsilonEquals 0.3048)
    }

}
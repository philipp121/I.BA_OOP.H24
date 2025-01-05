package U10_EX_Eventhandling.switchable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void testInitialState() {
        assertTrue(car.isOff(), "Car should initially be off");
        assertFalse(car.isOn(), "Car should initially not be on");
    }

    @Test
    void testSwitchOn() {
        car.switchOn();
        assertTrue(car.isOn(), "Car should be on after switchOn()");
        assertTrue(car.getMotor().isOn(), "Motor should be on after car is switched on");
        assertTrue(car.getLightFrontLeft().isOn(), "Front-left light should be on after car is switched on");
        assertTrue(car.getLightFrontRight().isOn(), "Front-right light should be on after car is switched on");
    }

    @Test
    void testSwitchOff() {
        car.switchOn();
        car.switchOff();
        assertTrue(car.isOff(), "Car should be off after switchOff()");
        assertFalse(car.getMotor().isOn(), "Motor should be off after car is switched off");
        assertFalse(car.getLightFrontLeft().isOn(), "Front-left light should be off after car is switched off");
        assertFalse(car.getLightFrontRight().isOn(), "Front-right light should be off after car is switched off");
    }

    @Test
    void testComponentIndependence() {
        car.getLightFrontLeft().switchOn();
        assertTrue(car.getLightFrontLeft().isOn(), "Front-left light should be on");
        assertFalse(car.isOn(), "Car should not be fully on if only one light is on");
    }

    @Test
    void testMotorListener() {
        car.getMotor().switchOn();
        car.getMotor().switchOff();
        // Ensure that property change listener in car logs correctly.
        // Mock or log verification can be done if necessary.
    }
}
package U10_EX_Eventhandling.switchable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {

    private Light light;

    @BeforeEach
    void setUp() {
        light = new Light();
    }

    @Test
    void testInitialState() {
        assertFalse(light.isOn(), "Light should initially be off");
    }

    @Test
    void testSwitchOn() {
        light.switchOn();
        assertTrue(light.isOn(), "Light should be on after switchOn()");
    }

    @Test
    void testSwitchOff() {
        light.switchOn();
        light.switchOff();
        assertFalse(light.isOn(), "Light should be off after switchOff()");
    }
}
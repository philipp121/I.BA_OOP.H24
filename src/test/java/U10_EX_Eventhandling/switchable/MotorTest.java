package U10_EX_Eventhandling.switchable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MotorTest {
    private Motor motor;

    @BeforeEach
    void setUp() {
        motor = new Motor();
    }

    @Test
    void testInitialState() {
        assertFalse(motor.isOn(), "Motor should initially be off");
        assertEquals(0, motor.getRpm(), "Motor RPM should initially be 0");
    }

    @Test
    void testSwitchOn() {
        motor.switchOn();
        assertTrue(motor.isOn(), "Motor should be on after switchOn()");
        assertEquals(1000, motor.getRpm(), "Motor RPM should be 1000 after switchOn()");
    }

    @Test
    void testSwitchOff() {
        motor.switchOn();
        motor.switchOff();
        assertFalse(motor.isOn(), "Motor should be off after switchOff()");
        assertEquals(0, motor.getRpm(), "Motor RPM should be 0 after switchOff()");
    }

    @Test
    void testPropertyChangeEvent() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        motor.addPropertyChangeListener(listener);

        motor.switchOn();
        verify(listener).propertyChange(argThat(event -> event.getPropertyName().equals("running") &&
                !((boolean) event.getOldValue()) &&
                ((boolean) event.getNewValue())));

        motor.switchOff();
        verify(listener).propertyChange(argThat(event -> event.getPropertyName().equals("running") &&
                ((boolean) event.getOldValue()) &&
                !((boolean) event.getNewValue())));
    }

    @Test
    void testAddRemoveListeners() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);

        // Add listener and verify it works
        motor.addPropertyChangeListener(listener);
        motor.switchOn();
        verify(listener, times(1)).propertyChange(any()); // Verify the listener received 1 event

        // Remove listener
        motor.removePropertyChangeListener(listener);

        // Clear the listener's invocation history after removal
        clearInvocations(listener);

        // Verify no more interactions occur after the listener is removed
        motor.switchOff();
        verify(listener, never()).propertyChange(any()); // No new interactions should occur
    }

    @Test
    void testPreventNullListener() {
        assertThrows(IllegalArgumentException.class, () -> motor.addPropertyChangeListener(null));
        assertThrows(IllegalArgumentException.class, () -> motor.removePropertyChangeListener(null));
    }
}
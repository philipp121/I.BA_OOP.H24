package U10_EX_Eventhandling.temperatur;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the TemperatureHistory class.
 * <p>
 * Overview:
 * 1. **Basic Functionality**:
 *    - `addTemperature_single`: Verifies adding a single temperature.
 *    - `addTemperature_multiple`: Verifies adding multiple temperatures in order.
 *    - `addTemperature_duplicate`: Verifies handling of duplicate temperatures.
 *    - `addTemperature_nullThrowsException`: Ensures null values are not allowed.
 *    - `addTemperature_TriggersMinimumEvent()`: Tests the behavior of adding temperatures to the TemperatureHistory and
 *                                               the corresponding events triggered for minimum temperatures.
 *    - `addTemperature_TriggersMaximumEvent()`: Tests the behavior of adding temperatures to the TemperatureHistory and
 *                                               the corresponding events triggered for maximum temperatures.
 *    - `addTemperature_FirstTemperatureTriggersBothEvents()`: Tests the Event behavior when the first temperature is
 *                                                             added to the TemperatureHistory.
 *    - `addTemperature_NoEventForNonMinMax()`: Tests that no events are triggered when a temperature is added that is
 *                                              neither a new minimum nor a new maximum
 * <p>
 * 2. **Immutable List**:
 *    - `getTemperatures_immutableList`: Verifies the returned list is immutable.
 * <p>
 * 3. **Replace Functionality**:
 *    - `replaceTemperatures_emptyList`: Ensures the history is cleared when replacing with an empty list.
 *    - `replaceTemperatures_singleElement`: Verifies replacing with a single element.
 *    - `replaceTemperatures_multipleElements`: Verifies replacing with multiple elements.
 *    - `replaceTemperatures_nullThrowsExceptionDoesNotModify`: Ensures replacing with null does not modify the history.
 * <p>
 * 4. **Clearing History**:
 *    - `clear_emptyHistory`: Ensures clearing an already empty history does not cause issues.
 *    - `clear_singleElementHistory`: Verifies clearing a history with one element.
 *    - `clear_multipleElementsHistory`: Verifies clearing a history with multiple elements.
 *    - `clear_andAddNewTemperatures`: Ensures new temperatures can be added after clearing.
 * <p>
 * 5. **Counting Elements**:
 *    - `getCount_emptyHistory`: Ensures count is zero for an empty history.
 *    - `getCount_singleElement`: Verifies count for a single element.
 *    - `getCount_multipleElements`: Verifies count for multiple elements.
 * <p>
 * 6. **Finding Maximum Temperatures**:
 *    - `getMax_Temperature_emptyHistory`: Ensures max temperature is null for an empty history.
 *    - `getMax_Temperature_singleElement`: Verifies max temperature for a single element.
 *    - `getMax_Temperature_multipleElements`: Verifies max temperature for multiple elements.
 *    - `getMax_Temperature_withNegativeTemperatures`: Verifies max temperature with negative values.
 *    - `getMax_Temperature_withDuplicates`: Verifies max temperature with duplicate maximum values.
 *    - `getMax_Temperature_withEdgeCases`: Verifies max temperature with extreme values.
 *    - `getMax_Temperature_largeList`: Ensures max temperature works with a large dataset.
 * <p>
 * 7. **Finding Minimum Temperatures**:
 *    - `getMin_Temperature_emptyHistory`: Ensures min temperature is null for an empty history.
 *    - `getMin_Temperature_singleElement`: Verifies min temperature for a single element.
 *    - `getMin_Temperature_multipleElements`: Verifies min temperature for multiple elements.
 *    - `getMin_Temperature_withNegativeTemperatures`: Verifies min temperature with negative values.
 *    - `getMin_Temperature_withDuplicates`: Verifies min temperature with duplicate minimum values.
 *    - `getMin_Temperature_withEdgeCases`: Verifies min temperature with extreme values.
 *    - `getMin_Temperature_largeList`: Ensures min temperature works with a large dataset.
 * <p>
 * 8. **Calculating Average Temperatures**:
 *    - `getAverageTemperature_emptyHistory`: Ensures average temperature is null for an empty history.
 *    - `getAverageTemperature_singleElement`: Verifies average temperature for a single element.
 *    - `getAverageTemperature_multipleElements`: Verifies average temperature for multiple elements.
 *    - `getAverageTemperature_negativeValues`: Verifies average temperature with negative values.
 *    - `getAverageTemperature_largeList()`: Verify that getAverageTemperature() works correctly with a large dataset
 * <p>
 * 9. **Equality and HashCode**:
 *    - `testEqualsContract`: Verifies the equals and hashCode contract using EqualsVerifier.
 *    - `equals_sameObjects`: Ensures equality for two histories with the same data.
 *    - `equals_differentObjects`: Ensures inequality for two histories with different data.
 *    - `hashCode_consistency`: Ensures consistent hashCode values for equal histories.
 */
class TemperatureHistoryTest {

    private TemperatureHistory temperatureHistory;
    @BeforeEach
    void setUp() {
        // Initialize a new TemperatureHistory instance before each test
        temperatureHistory = new TemperatureHistory();
    }

    @AfterEach
    void tearDown() {
        // Clean up the reference after each test
        temperatureHistory = null;
    }

    @SuppressWarnings({"ImmutableObjectIsModified", "DataFlowIssue"})
    @Test
    void getTemperatures_immutableList() {
        // Verify that the list returned by getTemperatures() is immutable
        temperatureHistory.addTemperature(new Temperature(10));
        List<Temperature> temps = temperatureHistory.getTemperatures();
        assertThrows(UnsupportedOperationException.class, () -> temps.add(new Temperature(20)));
    }

    @Test
    void addTemperature_single() {
        // Verify that a single temperature is added correctly
        temperatureHistory.addTemperature(new Temperature(25));
        assertEquals(1, temperatureHistory.getCount());
        assertEquals(new Temperature(25), temperatureHistory.getTemperatures().getFirst());
    }

    @Test
    void addTemperature_multiple() {
        // Verify that multiple temperatures are added in the correct order
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.addTemperature(new Temperature(20));
        assertEquals(2, temperatureHistory.getCount());
        assertEquals(new Temperature(10), temperatureHistory.getTemperatures().get(0));
        assertEquals(new Temperature(20), temperatureHistory.getTemperatures().get(1));
    }

    @Test
    void addTemperature_duplicate() {
        // Verify that duplicate temperatures can be added
        Temperature temp = new Temperature(30);
        temperatureHistory.addTemperature(temp);
        temperatureHistory.addTemperature(temp);
        assertEquals(2, temperatureHistory.getCount());
        assertEquals(temp, temperatureHistory.getTemperatures().get(0));
        assertEquals(temp, temperatureHistory.getTemperatures().get(1));
    }

    @Test
    void addTemperature_nullThrowsException() {
        // Verify that adding a null temperature throws a NullPointerException
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> temperatureHistory.addTemperature(null)
        );
        assertEquals("Temperature cannot be null", exception.getMessage());
    }

    /**
     * Tests the behavior when the first temperature is added to the TemperatureHistory.
     * <p>
     * - The first temperature should trigger both a MINIMUM and MAXIMUM event,
     *   as it is simultaneously the smallest and largest value in the history.
     * <p>
     * Validations:
     * - Ensures that the MINIMUM event is triggered with the correct first temperature.
     * - Ensures that the MAXIMUM event is triggered with the same first temperature.
     * - Verifies that both events are detected by the registered listener.
     */
    @Test
    public void addTemperature_FirstTemperatureTriggersBothEvents() {
        TemperatureHistory history = new TemperatureHistory();
        Temperature temp1 = new Temperature(25.0); // First temperature

        // Flags to track whether MINIMUM and MAXIMUM events are triggered
        AtomicBoolean minEventTriggered = new AtomicBoolean(false);
        AtomicBoolean maxEventTriggered = new AtomicBoolean(false);

        // Register a listener to capture and validate the events
        history.addTemperatureEventListener(event -> {
            if (event.getType() == TemperatureEventType.MINIMUM) {
                minEventTriggered.set(true);
                // Validate that the MINIMUM event is triggered with the correct temperature
                assertEquals(temp1, event.getTemperature());
            } else if (event.getType() == TemperatureEventType.MAXIMUM) {
                maxEventTriggered.set(true);
                // Validate that the MAXIMUM event is triggered with the correct temperature
                assertEquals(temp1, event.getTemperature());
            }
        });

        // Add the first temperature - should trigger both MINIMUM and MAXIMUM events
        history.addTemperature(temp1);

        // Verify that both events are triggered
        assertTrue(minEventTriggered.get());
        assertTrue(maxEventTriggered.get());
    }


    /**
     * Tests the behavior of adding temperatures to the TemperatureHistory and the corresponding
     * events triggered. Specifically:
     * <p>
     * - The first temperature added should trigger both a MINIMUM and MAXIMUM event, as it is
     *   simultaneously the smallest and largest value in the history at that point.
     * - Subsequent temperatures should trigger a MINIMUM or MAXIMUM event only if they represent
     *   a new minimum or maximum value.
     * <p>
     * Validations:
     * - Ensures that the correct Temperature object is passed with each triggered event.
     * - Verifies that both MINIMUM and MAXIMUM events are triggered for the first temperature.
     * - Confirms that only a MINIMUM event is triggered when a smaller temperature is added.
     */
    @Test
    public void addTemperature_TriggersMinimumEvent() {
        TemperatureHistory history = new TemperatureHistory();
        Temperature temp1 = new Temperature(30.0); // First temperature
        Temperature temp2 = new Temperature(20.0); // New minimum

        // Flags to track whether MINIMUM and MAXIMUM events are triggered
        AtomicBoolean minEventTriggered = new AtomicBoolean(false);
        AtomicBoolean maxEventTriggered = new AtomicBoolean(false);

        // Register a listener to capture and validate the events
        history.addTemperatureEventListener(event -> {
            if (event.getType() == TemperatureEventType.MINIMUM) {
                minEventTriggered.set(true);
                if (event.getTemperature().equals(temp1)) {
                    // First temperature should trigger a MINIMUM event
                    assertEquals(temp1, event.getTemperature());
                } else if (event.getTemperature().equals(temp2)) {
                    // Second temperature should trigger a new MINIMUM event
                    assertEquals(temp2, event.getTemperature());
                }
            } else if (event.getType() == TemperatureEventType.MAXIMUM) {
                maxEventTriggered.set(true);
                // First temperature should trigger a MAXIMUM event
                assertEquals(temp1, event.getTemperature());
            }
        });

        // Add the first temperature - should trigger both MINIMUM and MAXIMUM events
        history.addTemperature(temp1);

        // Add the second temperature - should trigger only a MINIMUM event
        history.addTemperature(temp2);

        // Assert that both MINIMUM and MAXIMUM events were triggered
        assertTrue(minEventTriggered.get());
        assertTrue(maxEventTriggered.get());
    }

    /**
     * Tests the behavior of adding temperatures to the TemperatureHistory and the corresponding
     * events triggered for maximum temperatures. Specifically:
     * <p>
     * - The first temperature added should trigger both a MINIMUM and MAXIMUM event, as it is
     *   simultaneously the smallest and largest value in the history at that point.
     * - Subsequent temperatures should trigger a MAXIMUM event only if they represent a new maximum value.
     * <p>
     * Validations:
     * - Ensures that the correct Temperature object is passed with each triggered event.
     * - Verifies that both MINIMUM and MAXIMUM events are triggered for the first temperature.
     * - Confirms that only a MAXIMUM event is triggered when a larger temperature is added.
     */
    @Test
    public void addTemperature_TriggersMaximumEvent() {
        TemperatureHistory history = new TemperatureHistory();
        Temperature temp1 = new Temperature(20.0); // First temperature
        Temperature temp2 = new Temperature(30.0); // New maximum

        // Flags to track whether MINIMUM and MAXIMUM events are triggered
        AtomicBoolean minEventTriggered = new AtomicBoolean(false);
        AtomicBoolean maxEventTriggered = new AtomicBoolean(false);

        // Register a listener to capture and validate the events
        history.addTemperatureEventListener(event -> {
            if (event.getType() == TemperatureEventType.MINIMUM) {
                minEventTriggered.set(true);
                // First temperature should trigger a MINIMUM event
                assertEquals(temp1, event.getTemperature());
            } else if (event.getType() == TemperatureEventType.MAXIMUM) {
                maxEventTriggered.set(true);
                if (event.getTemperature().equals(temp1)) {
                    // First temperature should trigger a MAXIMUM event
                    assertEquals(temp1, event.getTemperature());
                } else if (event.getTemperature().equals(temp2)) {
                    // Second temperature should trigger a new MAXIMUM event
                    assertEquals(temp2, event.getTemperature());
                }
            }
        });

        // Add the first temperature - should trigger both MINIMUM and MAXIMUM events
        history.addTemperature(temp1);

        // Add the second temperature - should trigger only a MAXIMUM event
        history.addTemperature(temp2);

        // Assert that both MINIMUM and MAXIMUM events were triggered
        assertTrue(minEventTriggered.get());
        assertTrue(maxEventTriggered.get());
    }

    /**
     * Tests that no events are triggered when a temperature is added that is
     * neither a new minimum nor a new maximum, while accounting for the behavior
     * where:
     * <p>
     * - The first temperature added always triggers both a MINIMUM and MAXIMUM event.
     * - Subsequent temperatures trigger events only if they establish a new minimum or maximum.
     * - Temperatures that fall between the current minimum and maximum do not trigger any events,
     *   but are still added to the history.
     * <p>
     * Validations:
     * - Ensures the first temperature triggers both MINIMUM and MAXIMUM events.
     * - Ensures a new maximum temperature triggers a MAXIMUM event.
     * - Confirms that no event is triggered for intermediate temperatures.
     */
    @Test
    public void addTemperature_NoEventForNonMinMax() {
        TemperatureHistory history = new TemperatureHistory();
        Temperature temp1 = new Temperature(20.0); // First temperature (MINIMUM and MAXIMUM)
        Temperature temp2 = new Temperature(30.0); // New maximum
        Temperature temp3 = new Temperature(25.0); // Not a new minimum or maximum

        // Flags to track whether any events are triggered
        AtomicBoolean minEventTriggered = new AtomicBoolean(false);
        AtomicBoolean maxEventTriggered = new AtomicBoolean(false);

        // Register a listener to track triggered events
        history.addTemperatureEventListener(event -> {
            if (event.getType() == TemperatureEventType.MINIMUM) {
                minEventTriggered.set(true);
            } else if (event.getType() == TemperatureEventType.MAXIMUM) {
                maxEventTriggered.set(true);
            }
        });

        // Add the first temperature - should trigger both MINIMUM and MAXIMUM events
        history.addTemperature(temp1);

        // Reset the flags for further validation
        minEventTriggered.set(false);
        maxEventTriggered.set(false);

        // Add the second temperature - triggers a MAXIMUM event
        history.addTemperature(temp2);

        // Assert that only the MAXIMUM event is triggered
        assertFalse(minEventTriggered.get());
        assertTrue(maxEventTriggered.get());

        // Reset the flags again
        minEventTriggered.set(false);
        maxEventTriggered.set(false);

        // Add the third temperature - should not trigger any event
        history.addTemperature(temp3);

        // Assert that no events are triggered for the third temperature
        assertFalse(minEventTriggered.get());
        assertFalse(maxEventTriggered.get());

        // Assert that all temperatures are added to the history
        assertEquals(3, history.getTemperatures().size());
        assertTrue(history.getTemperatures().contains(temp1));
        assertTrue(history.getTemperatures().contains(temp2));
        assertTrue(history.getTemperatures().contains(temp3));
    }

    @Test
    void replaceTemperatures_nullThrowsExceptionDoesNotModify() {
        // Verify that replaceTemperatures() with null throws an exception
        // and does not modify the original history
        temperatureHistory.addTemperature(new Temperature(10));
        assertThrows(NullPointerException.class, () -> temperatureHistory.replaceTemperatures(null));
        assertEquals(1, temperatureHistory.getCount());
        assertEquals(new Temperature(10), temperatureHistory.getTemperatures().getFirst());
    }

    @Test
    void addTemperatures_largeList() {
        // Verify that a large list of temperatures can be added efficiently
        List<Temperature> largeList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            largeList.add(new Temperature(i));
        }
        temperatureHistory.addTemperatures(largeList);
        assertEquals(1_000_000, temperatureHistory.getCount());
        assertEquals(new Temperature(999_999), temperatureHistory.getMaxTemperature());
    }

    @Test
    void clear_emptyHistory() {
        // Verify that clearing an already empty history results in no errors
        temperatureHistory.clear();
        assertEquals(0, temperatureHistory.getCount());
        assertTrue(temperatureHistory.getTemperatures().isEmpty());
    }

    @Test
    void clear_singleElementHistory() {
        // Verify that clearing a history with a single element works correctly
        temperatureHistory.addTemperature(new Temperature(15));
        temperatureHistory.clear();
        assertEquals(0, temperatureHistory.getCount());
        assertTrue(temperatureHistory.getTemperatures().isEmpty());
    }

    @Test
    void clear_multipleElementsHistory() {
        // Verify that clearing a history with multiple elements works correctly
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.addTemperature(new Temperature(20));
        temperatureHistory.addTemperature(new Temperature(30));
        temperatureHistory.clear();
        assertEquals(0, temperatureHistory.getCount());
        assertTrue(temperatureHistory.getTemperatures().isEmpty());
    }

    @Test
    void clear_andAddNewTemperatures() {
        // Verify that the history can be cleared and new temperatures added afterward
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.clear();
        temperatureHistory.addTemperature(new Temperature(20));
        assertEquals(1, temperatureHistory.getCount());
        assertEquals(new Temperature(20), temperatureHistory.getTemperatures().getFirst());
    }

    @Test
    void addTemperatures_emptyList() {
        // Verify that adding an empty list does not modify the history
        temperatureHistory.addTemperatures(new ArrayList<>());
        assertEquals(0, temperatureHistory.getCount());
    }

    @Test
    void addTemperatures_singleElement() {
        // Verify that adding a list with a single element works correctly
        List<Temperature> newTemps = List.of(new Temperature(15));
        temperatureHistory.addTemperatures(newTemps);
        assertEquals(1, temperatureHistory.getCount());
        assertEquals(new Temperature(15), temperatureHistory.getTemperatures().getFirst());
    }

    @Test
    void addTemperatures_multipleElements() {
        // Verify that adding a list with multiple elements works correctly
        List<Temperature> newTemps = List.of(new Temperature(10), new Temperature(20));
        temperatureHistory.addTemperatures(newTemps);
        assertEquals(2, temperatureHistory.getCount());
        assertEquals(new Temperature(10), temperatureHistory.getTemperatures().get(0));
        assertEquals(new Temperature(20), temperatureHistory.getTemperatures().get(1));
    }

    @Test
    void addTemperatures_nullListThrowsException() {
        // Verify that adding a null list throws a NullPointerException
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> temperatureHistory.addTemperatures(null)
        );
        assertEquals("Temperatures list cannot be null", exception.getMessage());
    }

    @Test
    void replaceTemperatures_emptyList() {
        // Verify that replacing the history with an empty list clears it
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.replaceTemperatures(new ArrayList<>());
        assertEquals(0, temperatureHistory.getCount());
    }

    @Test
    void replaceTemperatures_singleElement() {
        // Verify that replacing the history with a list containing a single element works correctly
        List<Temperature> newTemps = List.of(new Temperature(15));
        temperatureHistory.replaceTemperatures(newTemps);
        assertEquals(1, temperatureHistory.getCount());
        assertEquals(new Temperature(15), temperatureHistory.getTemperatures().getFirst());
    }

    @Test
    void replaceTemperatures_multipleElements() {
        // Verify that replacing the history with a list containing multiple elements works correctly
        List<Temperature> newTemps = List.of(new Temperature(10), new Temperature(20));
        temperatureHistory.replaceTemperatures(newTemps);
        assertEquals(2, temperatureHistory.getCount());
        assertEquals(new Temperature(10), temperatureHistory.getTemperatures().get(0));
        assertEquals(new Temperature(20), temperatureHistory.getTemperatures().get(1));
    }

    @Test
    void replaceTemperatures_nullListThrowsException() {
        // Verify that replacing the history with a null list throws a NullPointerException
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> temperatureHistory.replaceTemperatures(null)
        );
        assertEquals("Temperatures list cannot be null", exception.getMessage());
    }

    @Test
    void getCount_emptyHistory() {
        // Verify that the count is zero for an empty history
        assertEquals(0, temperatureHistory.getCount());
    }

    @Test
    void getCount_singleElement() {
        // Verify that the count is correctly updated for a single element
        temperatureHistory.addTemperature(new Temperature(15));
        assertEquals(1, temperatureHistory.getCount());
    }

    @Test
    void getCount_multipleElements() {
        // Verify that the count is correctly updated for multiple elements
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.addTemperature(new Temperature(20));
        assertEquals(2, temperatureHistory.getCount());
    }

    @Test
    void getMax_Temperature_emptyHistory() {
        // Verify that getMaxTemperature() returns null for an empty history
        assertNull(temperatureHistory.getMaxTemperature());
    }

    @Test
    void getMax_Temperature_singleElement() {
        // Verify that getMaxTemperature() returns the single element in the history
        temperatureHistory.addTemperature(new Temperature(15));
        assertEquals(new Temperature(15), temperatureHistory.getMaxTemperature());
    }

    @Test
    void getMax_Temperature_multipleElements() {
        // Verify that getMaxTemperature() correctly identifies the maximum value in the history
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.addTemperature(new Temperature(20));
        temperatureHistory.addTemperature(new Temperature(5));
        assertEquals(new Temperature(20), temperatureHistory.getMaxTemperature());
    }

    @Test
    void getMax_Temperature_withNegativeTemperatures() {
        // Verify that getMaxTemperature() works correctly with negative temperatures
        temperatureHistory.addTemperature(new Temperature(-100));
        temperatureHistory.addTemperature(new Temperature(-273));
        temperatureHistory.addTemperature(new Temperature(0));
        assertEquals(new Temperature(0), temperatureHistory.getMaxTemperature());
    }

    @Test
    void getMax_Temperature_withDuplicates() {
        // Verify that getMaxTemperature() works correctly with duplicate maximum values
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.addTemperature(new Temperature(10));
        assertEquals(new Temperature(10), temperatureHistory.getMaxTemperature());
    }

    @Test
    void getMax_Temperature_withEdgeCases() {
        // Verify that getMaxTemperature() works correctly with extreme values
        temperatureHistory.addTemperature(new Temperature(Temperature.KELVIN_OFFSET));
        temperatureHistory.addTemperature(new Temperature(Integer.MAX_VALUE));
        assertEquals(new Temperature(Integer.MAX_VALUE), temperatureHistory.getMaxTemperature());
    }

    @Test
    void getMax_Temperature_largeList() {
        // Verify that getMaxTemperature() works correctly with a large dataset
        for (int i = 1; i <= 1_000_000; i++) {
            temperatureHistory.addTemperature(new Temperature(i));
        }
        assertEquals(new Temperature(1_000_000), temperatureHistory.getMaxTemperature());
    }

    @Test
    void getMin_Temperature_emptyHistory() {
        // Verify that getMinTemperature() returns null for an empty history
        assertNull(temperatureHistory.getMinTemperature());
    }

    @Test
    void getMin_Temperature_singleElement() {
        // Verify that getMinTemperature() returns the single element in the history
        temperatureHistory.addTemperature(new Temperature(15));
        assertEquals(new Temperature(15), temperatureHistory.getMinTemperature());
    }

    @Test
    void getMin_Temperature_multipleElements() {
        // Verify that getMinTemperature() correctly identifies the minimum value in the history
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.addTemperature(new Temperature(20));
        temperatureHistory.addTemperature(new Temperature(5));
        assertEquals(new Temperature(5), temperatureHistory.getMinTemperature());
    }

    @Test
    void getMin_Temperature_withNegativeTemperatures() {
        // Verify that getMinTemperature() works correctly with negative temperatures
        temperatureHistory.addTemperature(new Temperature(-100));
        temperatureHistory.addTemperature(new Temperature(-273));
        temperatureHistory.addTemperature(new Temperature(0));
        assertEquals(new Temperature(-273), temperatureHistory.getMinTemperature());
    }

    @Test
    void getMin_Temperature_withDuplicates() {
        // Verify that getMinTemperature() works correctly with duplicate minimum values
        temperatureHistory.addTemperature(new Temperature(10));
        temperatureHistory.addTemperature(new Temperature(10));
        assertEquals(new Temperature(10), temperatureHistory.getMinTemperature());
    }

    @Test
    void getMin_Temperature_withEdgeCases() {
        // Verify that getMinTemperature() works correctly with extreme values
        temperatureHistory.addTemperature(new Temperature(Temperature.KELVIN_OFFSET));
        temperatureHistory.addTemperature(new Temperature(Integer.MAX_VALUE));
        assertEquals(new Temperature(Temperature.KELVIN_OFFSET), temperatureHistory.getMinTemperature());
    }

    @Test
    void getMin_Temperature_largeList() {
        // Verify that getMinTemperature() works correctly with a large dataset
        for (int i = 1; i <= 1_000_000; i++) {
            temperatureHistory.addTemperature(new Temperature(i));
        }
        assertEquals(new Temperature(1), temperatureHistory.getMinTemperature());
    }

    @Test
    void getAverageTemperature_emptyHistory() {
        // Verify that getAverageTemperature() returns null for an empty history
        TemperatureHistory history = new TemperatureHistory();
        assertNull(history.getAverageTemperature());
    }

    @Test
    void getAverageTemperature_singleElement() {
        // Verify that getAverageTemperature() returns the correct average for a single element
        TemperatureHistory history = new TemperatureHistory();
        history.addTemperature(new Temperature(25));
        assertEquals(new Temperature(25), history.getAverageTemperature());
    }

    @Test
    void getAverageTemperature_multipleElements() {
        // Verify that getAverageTemperature() calculates the average correctly for multiple elements
        TemperatureHistory history = new TemperatureHistory();
        history.addTemperature(new Temperature(10));
        history.addTemperature(new Temperature(20));
        history.addTemperature(new Temperature(30));
        assertEquals(new Temperature(20), history.getAverageTemperature());
    }

    @Test
    void getAverageTemperature_negativeValues() {
        // Verify that getAverageTemperature() calculates the average correctly with negative values
        TemperatureHistory history = new TemperatureHistory();
        history.addTemperature(new Temperature(-10));
        history.addTemperature(new Temperature(-20));
        history.addTemperature(new Temperature(-30));
        assertEquals(new Temperature(-20), history.getAverageTemperature());
    }

    @Test
    void getAverageTemperature_largeList() {
        // Verify that getAverageTemperature() works correctly with a large dataset
        for (int i = 1; i <= 1_000_000; i++) {
            temperatureHistory.addTemperature(new Temperature(i));
        }
        assertEquals(new Temperature(500_000.5), temperatureHistory.getAverageTemperature());
    }


    @Test
    void testEqualsContract() {
        // Verify that the equals() and hashCode() methods adhere to their contract
        EqualsVerifier.forClass(TemperatureHistory.class).withOnlyTheseFields("temperatures").verify();
    }

    @Test
    void equals_sameObjects() {
        // Verify that two histories with the same data are considered equal
        temperatureHistory.addTemperature(new Temperature(10));
        TemperatureHistory other = new TemperatureHistory();
        other.addTemperature(new Temperature(10));
        assertEquals(temperatureHistory, other);
    }

    @Test
    void equals_differentObjects() {
        // Verify that two histories with different data are not considered equal
        temperatureHistory.addTemperature(new Temperature(10));
        TemperatureHistory other = new TemperatureHistory();
        other.addTemperature(new Temperature(20));
        assertNotEquals(temperatureHistory, other);
    }

    @Test
    void hashCode_consistency() {
        // Verify that hashCode() produces consistent values for equal objects
        temperatureHistory.addTemperature(new Temperature(10));
        TemperatureHistory other = new TemperatureHistory();
        other.addTemperature(new Temperature(10));
        assertEquals(temperatureHistory.hashCode(), other.hashCode());
    }
}
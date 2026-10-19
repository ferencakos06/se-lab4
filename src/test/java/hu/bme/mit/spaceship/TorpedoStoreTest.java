package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Fail() {
        TorpedoStore store = new TorpedoStore(0);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
    }

    @Test 
    void fire_Multiple_Fail() {
        TorpedoStore store = new TorpedoStore(2);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(3);
        });
    }

    @Test 
    void fire_Multiple_Success() {
        TorpedoStore store = new TorpedoStore(2);
        boolean result = store.fire(2);
        assertEquals(true, result);
        assertEquals(0, store.getTorpedoCount());
    }

    @Test 
    void fire_Rate_Fail() {
        TorpedoStore store = new TorpedoStore(1, 1.0);
        boolean result = store.fire(1);
        assertEquals(false, result);
        assertEquals(1, store.getTorpedoCount());
    }
}

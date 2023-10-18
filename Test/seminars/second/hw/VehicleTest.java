package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    private Car car;
    private Motorcycle motocycle;
    @BeforeEach
    void setUp() {
        car = new Car("Toyota", "Corolla", 2021);
        motocycle = new Motorcycle("Honda", "Shadow", 2009);

    }

    @Test
    void testCarInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    void testCarHaveFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void testMotorcycleHaveTwoWheels() {
        assertThat(motocycle.getNumWheels()).isEqualTo(2);
    }
    @Test
    void testCarTestDriveSpeed(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void testMotorcycleTestDriveSpeed() {
        motocycle.testDrive();
        assertThat(motocycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void testCarIsParking() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void testMotorcycleIsParking() {
        motocycle.testDrive();
        motocycle.park();
        assertThat(motocycle.getSpeed()).isEqualTo(0);
    }
}
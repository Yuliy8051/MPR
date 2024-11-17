import org.example.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void carTurnsOnWhenItHasButteryAndFuel(){
        Car car = new Car(20, 50, 50, 0.8);
        boolean result = car.turnOn();
        assertTrue(result);
    }
    @Test
    public void carDoesntTurnOnWhenItHasButteryAndNoFuel(){
        Car car = new Car(20, 0, 50, 0.8);
        boolean result = car.turnOn();
        assertFalse(result);
    }
    @Test
    public void carDoesntTurnOnWhenItHasNoButteryAndFuel(){
        Car car = new Car(0, 50, 50, 0.8);
        boolean result = car.turnOn();
        assertFalse(result);
    }
    @Test
    public void carDoesntTurnOnWhenItHasNoButteryAndNoFuel(){
        Car car = new Car(0, 0, 50, 0.8);
        boolean result = car.turnOn();
        assertFalse(result);
    }

    @Test
    public void carDoesntRefuelWhenFuelVolumeIsNegative(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean result = car.refuel(-1);
        assertFalse(result);
        assertEquals(10, car.getFuelAmount());
    }
    @Test
    public void carDoesntRefuelWhenFuelVolumeIsZero(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean result = car.refuel(0);
        assertFalse(result);
        assertEquals(10, car.getFuelAmount());
    }
    @Test
    public void carRefuelsWhenFuelVolumeIsPositiveAndLessThanAvailable(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean result = car.refuel(20);
        assertTrue(result);
        assertEquals(30, car.getFuelAmount());
    }
    @Test
    public void carRefuelsWhenFuelVolumeIsPositiveAndGreaterThanAvailable(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean result = car.refuel(45);
        assertTrue(result);
        assertEquals(50, car.getFuelAmount());
    }
    @Test
    public void carDoesntDriveWhenDistanceIsNegative(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean result = car.drive(-50);
        assertFalse(result);
        assertEquals(10, car.getFuelAmount());
        assertEquals(0, car.getDistanceTraveled());
    }
    @Test
    public void carDoesntDriveWhenDistanceIsZero(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean result = car.drive(0);
        assertFalse(result);
        assertEquals(10, car.getFuelAmount());
        assertEquals(0, car.getDistanceTraveled());
    }
    @Test
    public void carDrivesWhenDistanceIsPositiveAndCarHasEnoughFuel(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean result = car.drive(10);
        assertTrue(result);
        assertEquals(2, car.getFuelAmount());
        assertEquals(10, car.getDistanceTraveled());
    }
    @Test
    public void carDoesntDriveWhenDistanceIsPositiveAndCarDoesntHaveEnoughFuel(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean result = car.drive(15);
        assertFalse(result);
        assertEquals(10, car.getFuelAmount());
        assertEquals(0, car.getDistanceTraveled());
    }
    @Test
    public void carDrivesWhenDistanceIsPositiveAndCarHasEnoughFuelButDoesntWhenFuelEnds(){
        Car car = new Car(20, 10, 50, 0.8);
        boolean firstTryResult = car.drive(5);
        assertTrue(firstTryResult);
        assertEquals(6, car.getFuelAmount());
        assertEquals(5, car.getDistanceTraveled());
        boolean secondTryResult = car.drive(6);
        assertTrue(secondTryResult);
        assertEquals(1.2, car.getFuelAmount(), 0.001);
        assertEquals(11, car.getDistanceTraveled());
        boolean thirdTryResult = car.drive(15);
        assertFalse(thirdTryResult);
        assertEquals(1.2, car.getFuelAmount(), 0.001);
        assertEquals(11, car.getDistanceTraveled());
    }
}

package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GarageServiceTest {

    private FixingService fixingService;
    private JunkyardService junkyardService;
    private GarageService testedService; // klasa testowana NIGDY nie jest mockiem!!!!!!!!1111oneone

    @BeforeEach
    public void setUp() {
        this.fixingService = Mockito.mock(FixingService.class);
        this.junkyardService = Mockito.mock(JunkyardService.class);
        this.testedService = new GarageService(fixingService, junkyardService);
    }

    @Test
    public void workOnCarFixesCarIfItIsFixable() {
        Car car = new Car(true, true);

        testedService.workOnCar(car);

        verify(fixingService).fix(any());
        verify(fixingService, times(1)).generateReceipt();
        verify(junkyardService, times(0)).destroy(any());
        verify(junkyardService, times(0)).generateReceipt();
    }

    @Test
    public void workOnCarDestroysCarIfItIsNotFixable() {
        when(junkyardService.destroy(any())).thenReturn(true);
        Car car = new Car(true, false);

        testedService.workOnCar(car);

        verify(fixingService, times(0)).fix(any());
        verify(fixingService, times(0)).generateReceipt();
        verify(junkyardService, times(1)).destroy(any());
        verify(junkyardService, times(1)).generateReceipt();
    }

    @Test
    public void workOnCarDestroysCarIfItIsNotFixableWithoutReceiptIfDestroyFails() {
        when(junkyardService.destroy(any())).thenReturn(false);
        Car car = new Car(true, false);

        testedService.workOnCar(car);

        verify(fixingService, times(0)).fix(any());
        verify(fixingService, times(0)).generateReceipt();
        verify(junkyardService, times(1)).destroy(any());
        verify(junkyardService, times(0)).generateReceipt();
    }
}

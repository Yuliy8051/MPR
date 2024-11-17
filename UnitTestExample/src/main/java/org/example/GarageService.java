package org.example;

public class GarageService {

    private FixingService fixingService;
    private JunkyardService junkyardService;

    public GarageService(FixingService fixingService, JunkyardService junkyardService) {
        this.fixingService = fixingService;
        this.junkyardService = junkyardService;
    }

    public void workOnCar(Car car) {
        if (car.isBroken()) {
            if (car.isFixable()) {
                fixingService.fix(car);
                fixingService.generateReceipt();
            } else {
                if (junkyardService.destroy(car)) {
                    junkyardService.generateReceipt();
                }
            }
        }
    }
}

package org.example;

import java.util.Random;

public class JunkyardService {

    Random random = new Random();

    public boolean destroy(Car car) {
        car.setDestroyed(true);
        //if dsadsdsadsadsafsa
        if(random.nextInt(7) > 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void generateReceipt() {
        // some logic
    }
}

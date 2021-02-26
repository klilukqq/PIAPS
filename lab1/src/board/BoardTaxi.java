package board;

import drivers.Driver;
import passengers.Passenger;

import java.util.List;

public class BoardTaxi extends BoardAnyCar {

    public static final int pricePerKilometer = 25;
    int finalPrice;
    int distance;

    public int calculatePrice(int distance){
        return distance*pricePerKilometer;
    }

    @Override
    public void boardDriver(Driver driver) {
        if(driver.licenze == 'B')
            properDriver = true;
        else System.out.println("Водитель не компетентен");
    }

    @Override
    public void boardPassengers(List<? extends Passenger> passengers) {
        int p = calculatePrice(distance);
        for (Passenger passenger: passengers) {
            if(currentlyAmountOfPassengers >= 4) {
                System.out.println("Места кончились");
                break;
            }
            if(passenger.payForRide(p/4)){
                currentlyAmountOfPassengers++;
            }
            else {
                System.out.println("Пассажиру не хватило денег");
            }
        }
        enoughPassengers = currentlyAmountOfPassengers > 0;
        finalPrice = p;
    }
}

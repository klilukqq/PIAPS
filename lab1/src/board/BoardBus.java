package board;

import drivers.Driver;
import passengers.BusPassenger;
import passengers.Passenger;

import java.util.List;

public class BoardBus extends BoardAnyCar {


    @Override
    public void boardDriver(Driver driver) {
        if(driver.licenze == 'C') properDriver = true;
        else System.out.println("Водитель не компетентен");
    }

    @Override
    public void boardPassengers(List<? extends Passenger> passengers) {
        for (Passenger passenger: passengers) {
            if(currentlyAmountOfPassengers >= 30) {
                System.out.println("Места кончились");
                break;
            }
            switch (((BusPassenger)passenger).c){
                case STANDARD ->{
                    if(passenger.payForRide(50)) {
                        currentlyAmountOfPassengers++;
                        totalProfit  += 50;
                    } else {
                        System.out.println("Пассажиру не хватило денег");
                    }
                }
                case PRIVILEGED -> {
                        if(passenger.payForRide(25)){
                            currentlyAmountOfPassengers++;
                            totalProfit+=25;
                        } else {
                            System.out.println("Пассажиру не хватило денег");
                        }
                    }
                case FREE -> {
                    currentlyAmountOfPassengers++;
                }
            }
        }
        enoughPassengers = currentlyAmountOfPassengers > 0;
    }
}

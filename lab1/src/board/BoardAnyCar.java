package board;

import drivers.*;
import passengers.Passenger;

import java.util.List;

abstract class BoardAnyCar {

    int totalProfit;
    int currentlyAmountOfPassengers;
    boolean properDriver;
    boolean enoughPassengers;

    public void boardDriver(Driver driver){}
    public void boardPassengers(List<? extends Passenger> passenger){}
    public boolean startTheRide(){
     return (properDriver && enoughPassengers);
    }

}

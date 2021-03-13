package builders;

import drivers.Driver;
import drivers.TypeLicence;
import passengers.BusPassenger;
import passengers.TaxiPassenger;


import java.util.ArrayList;
import java.util.List;

public class BusBuilder implements Builder {

    private Driver driver = new Driver(TypeLicence.MISS);
    private int LimitPlace;
    private List<BusPassenger> busPassengers = new ArrayList<>();
    private boolean hasChildSeat = false;
    public int income = 0;


    @Override
    public void setLimitPlace() {
        this.LimitPlace = 30;
    }

    @Override
    public void setDriver(Driver driver) {
        if (this.driver.lt.equals(TypeLicence.D))
            System.out.println("Водитель уже сидит");
        else
            if(driver.lt.equals(TypeLicence.D))
                this.driver = driver;
            else
                System.out.println("У водителя другие права");
    }

    @Override
    public boolean addBusPassenger(BusPassenger passenger) {
        if(busPassengers.size() >= LimitPlace) {
            System.out.println("Места закончились");
            return false;
        }

        else {
            switch (passenger.pt) {
                case PRIVILEGED -> {
                    this.busPassengers.add(passenger);
                }
                case CHILD -> {
                    income =+25;
                    this.busPassengers.add(passenger);
                }
                case ADULT -> {
                    income += 50;
                    this.busPassengers.add(passenger);
                }
            }
            return true;
        }
    }

    @Override
    public boolean addTaxiPassenger(TaxiPassenger passenger) {
        System.out.println("Водитель отказывается посадить этих пассажиров");
        return true;
    }

    @Override
    public void addChildSeat() {
        this.hasChildSeat = true;
    }

    @Override
    public void startTrip() {
        if(driver.lt.equals(TypeLicence.MISS)){
            System.out.println("Необходим водитель");
        }
        else if((driver.lt.equals(TypeLicence.D) && busPassengers.size() == 0)){
            System.out.println("Необходимы пассажиры");
        }
        else {
            System.out.println("Поездка началась, общий доход: " + income);
        }
    }


    @Override
    public void clear(){
        driver = new Driver(TypeLicence.MISS);
        busPassengers.clear();
        income  = 0;
        hasChildSeat = false;
        LimitPlace = 0;
    }

}

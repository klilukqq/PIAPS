package builders;

import drivers.Driver;
import drivers.TypeLicence;
import passengers.BusPassenger;
import passengers.TaxiPassenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaxiBuilder implements Builder {

    private Driver driver = new Driver(TypeLicence.MISS);
    private int LimitPlace;
    private List<TaxiPassenger> taxiPassengers = new ArrayList<>();
    private boolean hasChildSeat = false;
    public int income = 0;


    @Override
    public void setLimitPlace() {
        this.LimitPlace = 4;
    }

    @Override
    public void setDriver(Driver driver) {
        if (this.driver.lt.equals(TypeLicence.B))
            System.out.println("Водитель уже сидит");
        else
            if(driver.lt.equals(TypeLicence.B))
                this.driver = driver;
            else
                System.out.println("У водителя другие права");
    }

    @Override
    public boolean addBusPassenger(BusPassenger passenger) {
        System.out.println("Водитель отказывается посадить этих пассажиров");
        return true;
    }

    @Override
    public boolean addTaxiPassenger(TaxiPassenger passenger) {
        if(taxiPassengers.size() >= LimitPlace) {
            System.out.println("Места кончились");
            return false;
        } else {
            if(passenger.isChild){
                addChildSeat();
                this.taxiPassengers.add(passenger);
            }
            else {
                income += 100;
                taxiPassengers.add(passenger);
            }
            return true;
        }

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
        else if( (driver.lt.equals(TypeLicence.B) && taxiPassengers.size() == 0) ){
            System.out.println("Необходимы пассажиры");
        }
        else if(income == 0){
            System.out.println("Поездка экономически невыгодна");
        }
        else {
            System.out.println("Поездка началась, доход: " + income);
        }
    }


    @Override
    public void clear(){
        driver = new Driver(TypeLicence.MISS);
        taxiPassengers.clear();
        income  = 0;
        hasChildSeat = false;
        LimitPlace = 0;
    }

}

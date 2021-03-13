package builders;

import drivers.Driver;
import passengers.BusPassenger;
import passengers.TaxiPassenger;

public interface Builder {

    void setLimitPlace();
    void setDriver(Driver driver);
    boolean addBusPassenger(BusPassenger passenger);
    boolean addTaxiPassenger(TaxiPassenger passenger);
    void addChildSeat();
    void startTrip();
    void clear();

}

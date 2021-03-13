import builders.Builder;
import drivers.Driver;
import drivers.TypeLicence;
import passengers.BusPassenger;
import passengers.TaxiPassenger;
import passengers.passengerType;

public class Director {

    public void createFullBusTrip(Builder builder){

        builder.setLimitPlace();
        builder.setDriver(new Driver(TypeLicence.D));
        boolean continueCycle = true;

        for (int i = 0; i < 40; i++) {
            if(i%5 == 0)
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.PRIVILEGED));
            else if(i%3==0)
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.CHILD));
            else
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.ADULT));

            if(!continueCycle) break;
        }

        builder.startTrip();

        builder.clear();

    }

    public void createFullBusWithTwoDrivers(Builder builder){

        builder.setLimitPlace();
        builder.setDriver(new Driver(TypeLicence.D));
        builder.setDriver(new Driver(TypeLicence.D));
        boolean continueCycle = true;

        for (int i = 0; i < 40; i++) {
            if(i%5 == 0)
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.PRIVILEGED));
            else if(i%3==0)
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.CHILD));
            else
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.ADULT));

            if(!continueCycle) break;
        }

        builder.startTrip();

        builder.clear();

    }

    public void createTaxiTripWithSixPassengers(Builder builder){

        builder.setLimitPlace();
        builder.setDriver(new Driver(TypeLicence.B));
        boolean continueCycle = true;

        for (int i = 0; i < 6; i++) {
            if (continueCycle == false)
                break;
            else if(i%3==0)
                continueCycle = builder.addTaxiPassenger(new TaxiPassenger(true));
            else
                continueCycle = builder.addTaxiPassenger(new TaxiPassenger(false));
        }

        builder.startTrip();

        builder.clear();

    }

    public void createBusTripWithDifferentDriver(Builder builder){

        builder.setLimitPlace();
        builder.setDriver(new Driver(TypeLicence.A));
        boolean continueCycle = true;

        for (int i = 0; i < 20; i++) {
            if (continueCycle == false)
                break;
            else if(i%5 == 0)
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.PRIVILEGED));
            else if(i%3==0)
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.CHILD));
            else
                continueCycle = builder.addBusPassenger(new BusPassenger(passengerType.ADULT));
        }

        builder.startTrip();

        builder.clear();

    }

    public void createBusTripNoPassengers(Builder builder){

        builder.setLimitPlace();
        builder.setDriver(new Driver(TypeLicence.D));

        builder.startTrip();

        builder.clear();

    }
}

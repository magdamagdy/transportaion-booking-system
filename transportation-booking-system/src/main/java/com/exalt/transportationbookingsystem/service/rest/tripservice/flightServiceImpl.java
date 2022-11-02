package com.exalt.transportationbookingsystem.service.rest.tripservice;

import com.exalt.transportationbookingsystem.dataaccess.persondao.UserDao;
import com.exalt.transportationbookingsystem.dataaccess.persondao.userDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.FlightDao;
import com.exalt.transportationbookingsystem.dataaccess.tripdao.flightDaoImpl;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.PlaneDao;
import com.exalt.transportationbookingsystem.dataaccess.vehicledao.planeDaoImpl;
import com.exalt.transportationbookingsystem.exception.AlreadyExistException;
import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.trip.dto.FlightDTO;
import com.exalt.transportationbookingsystem.models.trip.mapperinterfaces.FlightMapper;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class flightServiceImpl implements FlightService {

    private final String nullValueMsg = "Null object or Null id";
    private final String notFoundMsg = "Flight not found";
    private final String alreadyExistMsg = "Flight already exist";
    FlightDao flightDao = new flightDaoImpl();
    PlaneDao planeDao = new planeDaoImpl();
    UserDao userDao = new userDaoImpl();

    @Override
    public FlightDTO addFlight(FlightDTO flight) throws NullValueException, AlreadyExistException {
        if (flight.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        FlightDB flightDB = FlightMapper.INSTANCE.flightDtoToFlightDb(flight);
        PlaneDB plane = planeDao.readPlaneById(flight.getRefPlaneId());
        UserDB user = userDao.readUserById(flight.getRefUserId());
        flightDB.setPlane(plane);
        flightDB.setUser(user);
        flightDao.saveFlight(flightDB);

        //add the flight to the user flights list
        if (user.getFlights() !=null & user !=null) {
            //get user list of trips
            List<FlightDB> flights = new ArrayList<>(user.getFlights());

            for ( FlightDB i : flights) {
                if (i.getId() == flightDB.getId()){
                    //if the flight already found don't added to the list again
                    throw new AlreadyExistException(alreadyExistMsg);
                }
            }
            //if flight not found add it
            flights.add(flightDB);
            user.setFlights(flights);
        }
        else {
            List<FlightDB> flights = Arrays.asList(flightDB);
            user.setFlights(flights);
        }
        userDao.saveUser(user);
        return FlightMapper.INSTANCE.flightDbToFlightDto(flightDao.readFlightById(flight.getId()));

    }

    @Override
    public FlightDTO updateFlight(FlightDTO flight) throws NullValueException, NotFoundException {
        if (flight.getId()==0){
            throw new NullValueException(nullValueMsg);
        }
        FlightDB flightDB = FlightMapper.INSTANCE.flightDtoToFlightDb(flight);
        if (flightDao.readFlightById(flight.getId()) != null) {
            flightDao.updateFlight(flightDB);
            return FlightMapper.INSTANCE.flightDbToFlightDto(flightDao.readFlightById(flight.getId()));
        }
        else {
            throw new NotFoundException(notFoundMsg);
        }
    }
}

package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class flightDaoImplTest {
  FlightDao flightDao = new flightDaoImpl();
  DriverDB driver = new DriverDB(6,45,"male","012589367410","driver@gmail.com","dfb710",6,3.1F,7);
  PlaneDB plane = new PlaneDB(3,"wqv702","Germany","wf8-17","grey",250,driver,"Cairo Airport","Egypt Airlines");
  UserDB user = new UserDB(7,19,"female","01223699874","user@gmail.com");
  @Test
  void saveAndReadFlightById_NewFlight_NewSavedRecordIsConsistentWithRetrievedRecord(){
    FlightDB newRecord =  new FlightDB(2,"22-9-2010",5,"9:00","10:30","Cairo","Aswan",user,"class A",plane);
    flightDao.saveFlight(newRecord);
    FlightDB retrievedRecord = flightDao.readFlightById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getDate().equals(retrievedRecord.getDate()) &&
        newRecord.getSeatNo() == retrievedRecord.getSeatNo() &&
        newRecord.getDepartureTime().equals(retrievedRecord.getDepartureTime()) &&
        newRecord.getArrivalTime().equals(retrievedRecord.getArrivalTime()) &&
        newRecord.getStartLocation().equals(retrievedRecord.getStartLocation()) &&
        newRecord.getDestination().equals(retrievedRecord.getDestination()) &&
        newRecord.getUser().getId() == retrievedRecord.getUser().getId() &&
        newRecord.getPlane().getId() == retrievedRecord.getPlane().getId() &&
        newRecord.getFlightClass().equals(retrievedRecord.getFlightClass())
    );
    flightDao.deleteFlightById(newRecord.getId());
  }

  @Test
  void updateFlight_ExistingFlight_RetrievedRecordIsUpdated() {
    flightDao.saveFlight(
        new FlightDB(3,"22-9-2010",5,"9:00","10:30","Cairo","Aswan",user,"class A",plane));
    FlightDB ExistingFlight = flightDao.readFlightById(3);
    FlightDB updates = new FlightDB(3,"29-9-2010",60,"9:00","10:30","Cairo","Aswan",user,"class B",plane);
    flightDao.updateFlight(updates);
    FlightDB UpdatedFlight = flightDao.readFlightById(3);
    assertTrue(ExistingFlight.getId() == UpdatedFlight.getId() &&
        !ExistingFlight.getDate().equals(UpdatedFlight.getDate()) &&
        ExistingFlight.getSeatNo() != UpdatedFlight.getSeatNo() &&
        ExistingFlight.getDepartureTime().equals(UpdatedFlight.getDepartureTime()) &&
        ExistingFlight.getArrivalTime().equals(UpdatedFlight.getArrivalTime()) &&
        ExistingFlight.getStartLocation().equals(UpdatedFlight.getStartLocation()) &&
        ExistingFlight.getDestination().equals(UpdatedFlight.getDestination()) &&
        ExistingFlight.getUser().getId() == UpdatedFlight.getUser().getId() &&
        ExistingFlight.getPlane().getId() == UpdatedFlight.getPlane().getId() &&
        !ExistingFlight.getFlightClass().equals(UpdatedFlight.getFlightClass()));
    flightDao.deleteFlightById(ExistingFlight.getId());
  }

  @Test
  void readAllFlights_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<FlightDB> allRecords = new ArrayList<>(flightDao.readAllFlights());
    assertTrue(allRecords.size() > 0);
  }

  @Test
  void deleteFlightById_ExistingFlight_GettingNullObjectAfterDelete() {
    flightDao.saveFlight(new FlightDB(4,"1-9-2010",50,"9:00","10:30","Cairo","Aswan",user,"class A",plane));
    flightDao.deleteFlightById(4);
    assertEquals(flightDao.readFlightById(4), null);
  }
}
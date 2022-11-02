package com.exalt.transportationbookingsystem.dataaccess.tripdao;

import static org.junit.jupiter.api.Assertions.*;

import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import com.exalt.transportationbookingsystem.models.person.db.UserDB;
import com.exalt.transportationbookingsystem.models.trip.db.BusTripDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.BusDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class busTripDaoImplTest {

  BusTripDao busTripDao = new busTripDaoImpl();
  DriverDB driver = new DriverDB(6,45,"male","012589367410","driver@gmail.com","dfb710",6,3.1F,7);
  BusDB bus = new BusDB(3,"hop417","Germany","c80","blue",32,driver);
  UserDB user = new UserDB(7,19,"female","01223699874","user@gmail.com");
  @Test
  void saveAndReadBusTripById_NewBusTrip_NewSavedRecordIsConsistentWithRetrievedRecord(){
    BusTripDB newRecord =  new BusTripDB(2,"22-9-2010",5,"9:00","11:30","Cairo","Alex",user,bus);
    busTripDao.saveBusTrip(newRecord);
    BusTripDB retrievedRecord = busTripDao.readBusTripById(newRecord.getId());
    assertTrue(newRecord.getId() == retrievedRecord.getId() &&
        newRecord.getDate().equals(retrievedRecord.getDate()) &&
        newRecord.getSeatNo() == retrievedRecord.getSeatNo() &&
        newRecord.getDepartureTime().equals(retrievedRecord.getDepartureTime()) &&
        newRecord.getArrivalTime().equals(retrievedRecord.getArrivalTime()) &&
        newRecord.getStartLocation().equals(retrievedRecord.getStartLocation()) &&
        newRecord.getDestination().equals(retrievedRecord.getDestination()) &&
        newRecord.getUser().getId() == retrievedRecord.getUser().getId() &&
        newRecord.getBus().getId() == retrievedRecord.getBus().getId()
    );
    busTripDao.deleteBusTripById(newRecord.getId());
  }

  @Test
  void updateBusTrip_ExistingBusTrip_RetrievedRecordIsUpdated() {
    busTripDao.saveBusTrip(
        new BusTripDB(3, "22-9-2010", 9, "9:00", "11:30", "Cairo", "Alex", user, bus));
    BusTripDB ExistingBusTrip = busTripDao.readBusTripById(3);
    BusTripDB updates = new BusTripDB(3, "23-9-2010", 10, "9:00", "11:30", "Cairo", "Alex", user,
        bus);
    busTripDao.updateBusTrip(updates);
    BusTripDB UpdatedBusTrip = busTripDao.readBusTripById(3);
    assertTrue(ExistingBusTrip.getId() == UpdatedBusTrip.getId() &&
        !ExistingBusTrip.getDate().equals(UpdatedBusTrip.getDate()) &&
        ExistingBusTrip.getSeatNo() != UpdatedBusTrip.getSeatNo() &&
        ExistingBusTrip.getDepartureTime().equals(UpdatedBusTrip.getDepartureTime()) &&
        ExistingBusTrip.getArrivalTime().equals(UpdatedBusTrip.getArrivalTime()) &&
        ExistingBusTrip.getStartLocation().equals(UpdatedBusTrip.getStartLocation()) &&
        ExistingBusTrip.getDestination().equals(UpdatedBusTrip.getDestination()) &&
        ExistingBusTrip.getUser().getId() == UpdatedBusTrip.getUser().getId() &&
        ExistingBusTrip.getBus().getId() == UpdatedBusTrip.getBus().getId());
    busTripDao.deleteBusTripById(ExistingBusTrip.getId());
  }

  @Test
  void readAllBusTrips_ExistingNoOfRecords_ListOfRecordsNotNull() {
    List<BusTripDB> allRecords = new ArrayList<>(busTripDao.readAllBusTrips());
    assertTrue(allRecords.size() > 0);
  }

  @Test
  void deleteBusTripById_ExistingBusTrip_GettingNullObjectAfterDelete() {
    busTripDao.saveBusTrip(new BusTripDB(4, "30-9-2010", 20, "9:00", "11:30", "Cairo", "Alex", user, bus));
    busTripDao.deleteBusTripById(4);
    assertEquals(busTripDao.readBusTripById(4), null);
  }
}
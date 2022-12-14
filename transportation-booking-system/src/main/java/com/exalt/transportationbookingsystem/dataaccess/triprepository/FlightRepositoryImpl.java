package com.exalt.transportationbookingsystem.dataaccess.triprepository;

import com.exalt.transportationbookingsystem.dbconfiguration.Database;
import com.exalt.transportationbookingsystem.models.trip.db.FlightDB;
import java.util.List;

public class FlightRepositoryImpl implements FlightRepository {

  private final String date = "date";
  private final String seatNo ="seatNo";
  private final String flightClass ="flightClass";

  /**
   * The Aerospike Instance.
   */
  Database aerospike = Database.getInstance();

  @Override
  public void saveFlight(FlightDB flight){
      aerospike.mapper.save(flight);
  }

  @Override
  public void updateFlight(FlightDB flight){
      aerospike.mapper.update(flight,date, seatNo,flightClass);
  }

  @Override
  public FlightDB readFlightById(int id){
    return aerospike.mapper.read(FlightDB.class, id);
  }

  @Override
  public List<FlightDB> readAllFlights(){
    return aerospike.mapper.scan(FlightDB.class);
  }

  @Override
  public void deleteFlightById(int id){
      aerospike.mapper.delete(FlightDB.class, id);
  }

}

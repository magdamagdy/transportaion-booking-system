package com.exalt.transportationbookingsystem.dataaccess.vehicledao;

import com.exalt.transportationbookingsystem.dbconfiguration.database;
import com.exalt.transportationbookingsystem.models.vehicle.db.PlaneDB;
import com.exalt.transportationbookingsystem.models.vehicle.db.TrainDB;
import java.util.List;

public class trainDaoImpl implements TrainDao {

  private final String license = "license";
  private final String manifacCountry = "manifacCountry";
  private final String model = "model";
  private final String colour = "colour";
  private final String noOfSeats ="noOfSeats";
  private final String railwayStation = "railwayStation";

  database aerospike = database.getInstance();

  @Override
  public void saveTrain(TrainDB train){
      aerospike.mapper.save(train);
  }

  @Override
  public void updateTrain(TrainDB train){
      aerospike.mapper.update(train,license, manifacCountry,model,colour,noOfSeats,railwayStation);
  }

  @Override
  public TrainDB readTrainById(int id){
    return aerospike.mapper.read(TrainDB.class, id);
  }

  @Override
  public List<TrainDB> readAllTrains(){
    return aerospike.mapper.scan(TrainDB.class);
  }

  @Override
  public void deleteTrainById(int id){
      aerospike.mapper.delete(TrainDB.class, id);
  }

}

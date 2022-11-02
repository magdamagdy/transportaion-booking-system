package com.exalt.transportationbookingsystem.dataaccess.persondao;

import com.exalt.transportationbookingsystem.dbconfiguration.database;
import com.exalt.transportationbookingsystem.models.person.db.DriverDB;
import java.util.List;

public class driverDaoImpl implements DriverDao {

  private final String age = "age";
  private final String gender = "gender";
  private final String phone = "phone";
  private final String email = "email";
  private final String license = "license";
  private final String yearOfExp = "yearsOfExp";

  database aerospike = database.getInstance();

  @Override
  public void saveDriver(DriverDB driver) {
      aerospike.mapper.save(driver);
  }

  @Override
  public void updateDriver(DriverDB driver){
      aerospike.mapper.update(driver,age,gender ,phone ,email ,license ,yearOfExp);
  }

  @Override
  public DriverDB readDriverById(int id){
    return aerospike.mapper.read(DriverDB.class, id);
  }

  @Override
  public List<DriverDB> readAllDrivers(){
    return aerospike.mapper.scan(DriverDB.class);
  }

  @Override
  public void deleteDriverById(int id){
      aerospike.mapper.delete(DriverDB.class, id);
  }
}

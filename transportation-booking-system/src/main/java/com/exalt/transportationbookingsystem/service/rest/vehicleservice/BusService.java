package com.exalt.transportationbookingsystem.service.rest.vehicleservice;

import com.exalt.transportationbookingsystem.exception.NotFoundException;
import com.exalt.transportationbookingsystem.exception.NullValueException;
import com.exalt.transportationbookingsystem.models.vehicle.dto.BusDTO;

public interface BusService {
  BusDTO addBus(BusDTO bus) throws NullValueException;
  BusDTO updateBus(BusDTO bus) throws NullValueException, NotFoundException;

}
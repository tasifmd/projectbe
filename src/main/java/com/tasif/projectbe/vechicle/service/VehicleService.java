package com.tasif.projectbe.vechicle.service;

import java.util.List;

import com.tasif.projectbe.response.Response;
import com.tasif.projectbe.vechicle.dto.VehicleDto;
import com.tasif.projectbe.vechicle.model.Vehicle;

public interface VehicleService {

	public Response createVehicle(long userId, VehicleDto vehicleDto);
	
	public Response updateVehicle(long vehicleId,VehicleDto vehicleDto);
	
	public Response deleteVehicle(long vehicleId);
	
	public List<Vehicle> getAllVehiclesOfUser(long userId);
	
	public Vehicle getVehicleOfUser(long vehicleId);
}

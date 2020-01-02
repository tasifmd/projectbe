package com.tasif.projectbe.vechicle.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.projectbe.response.Response;
import com.tasif.projectbe.utility.ResponseHelper;
import com.tasif.projectbe.vechicle.dto.VehicleDto;
import com.tasif.projectbe.vechicle.model.Vehicle;
import com.tasif.projectbe.vechicle.repository.VehicleRepository;
import com.tasif.projectbe.vechicle.service.VehicleService;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Response createVehicle(long userId, VehicleDto vehicleDto) {
		Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
		vehicle.setUserId(userId);
		vehicleRepository.save(vehicle);
		Response response = ResponseHelper.statusInfo("Vehicle created successfully", 1000);
		return response;
	}

	@Override
	public Response updateVehicle(long vehicleId, VehicleDto vehicleDto) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new RuntimeException("No vehicle exist with vehicleId " + vehicleId));
		vehicle.setVehicleName(vehicleDto.getVehicleName());
		vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
		vehicleRepository.save(vehicle);
		Response response = ResponseHelper.statusInfo("Vehicle updated successfully", 1000);
		return response;
	}

	@Override
	public Response deleteVehicle(long vehicleId) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new RuntimeException("No vehicle exist with vehicleId " + vehicleId));
		vehicleRepository.delete(vehicle);
		Response response = ResponseHelper.statusInfo("Vehicle deleted successfully", 1000);
		return response;
	}

	@Override
	public List<Vehicle> getAllVehiclesOfUser(long userId) {
		return vehicleRepository.findByUserId(userId);
	}

	@Override
	public Vehicle getVehicleOfUser(long vehicleId) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new RuntimeException("No vehicle exist with vehicleId " + vehicleId));
		return vehicle;
	}

}

package com.tasif.projectbe.vechicle.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.projectbe.response.Response;
import com.tasif.projectbe.vechicle.dto.VehicleDto;
import com.tasif.projectbe.vechicle.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping
	public ResponseEntity<Response> createVehicle(@RequestBody VehicleDto vehicleDto) {
		Response response = vehicleService.createVehicle(vehicleDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/{vehicleId}")
	public ResponseEntity<Response> updateVehicle(@PathVariable long vehicleId, @RequestBody VehicleDto vehicleDto) {
		Response response = vehicleService.updateVehicle(vehicleId, vehicleDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{vehicleId}")
	public ResponseEntity<Response> deleteVehicle(@RequestHeader String token, @PathVariable long vehicleId) {
		Response response = vehicleService.deleteVehicle(vehicleId);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable long vehicleId) {
		Vehicle response = vehicleService.getVehicleOfUser(vehicleId);
		return new ResponseEntity<Vehicle>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Vehicle>> getAllVehicle() {
		List<Vehicle> response = vehicleService.getAllVehiclesOfUser();
		return new ResponseEntity<List<Vehicle>>(response, HttpStatus.OK);
	}
}

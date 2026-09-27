package com.krakedev.paqueadero.controladores;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.paqueadero.modelo.Auto;
import com.krakedev.paqueadero.modelo.Motocicleta;
import com.krakedev.paqueadero.modelo.Vehiculo;
import com.krakedev.paqueadero.servicios.ServicioVehiculos;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
	private final ServicioVehiculos servicioVehiculos;
	
	public VehiculoController(ServicioVehiculos servicioVehiculos) {
		this.servicioVehiculos = servicioVehiculos;
	}
	
	@PostMapping("/autos")
	public boolean ingresarAuto(@RequestBody Auto auto){
		return servicioVehiculos.ingresarVehiculo(auto);
	}
	
	@PostMapping("/autos")
	public boolean ingresarAuto(@RequestBody Motocicleta moto){
		return servicioVehiculos.ingresarVehiculo(moto);
	}
	
	@GetMapping
	public ArrayList<Vehiculo> listarVehiculo(){
		return servicioVehiculos.listarVehiculo();
	}
	
	@GetMapping("/{placa}")
	public Vehiculo buscarPorPlaca(@PathVariable String placa){
			return servicioVehiculos.buscarPorPlaca(placa);
	}
}

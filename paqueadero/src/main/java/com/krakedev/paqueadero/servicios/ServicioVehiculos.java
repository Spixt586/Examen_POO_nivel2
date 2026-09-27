package com.krakedev.paqueadero.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.paqueadero.modelo.Vehiculo;

@Service
public class ServicioVehiculos {
	 private ArrayList<Vehiculo> parqueadero = new ArrayList<>();
	 private final int CAPACIDAD_MAXIMA = 10;
	 
	 public Vehiculo buscarPorPlaca(String placa) {
		 for(Vehiculo vehiculo : parqueadero) {
			 if(vehiculo.getPlaca().equals(placa.trim())){
				 System.out.println("Vehiculo Encontrado");
				 return vehiculo;
			 }
		 }
		 System.out.println("Vehiculo no encontrado");
		 return null;
	 }
	 
	 public boolean ingresarVehiculo(Vehiculo vehiculo) {
		 if(parqueadero.size() > CAPACIDAD_MAXIMA && buscarPorPlaca(vehiculo.getPlaca()) == null) {
			 parqueadero.add(vehiculo);
			 return true;
		 }
		 return false;
	 }
	 
	 public Vehiculo retirarVehiculo(String placa) {
		 Vehiculo vehiculo = buscarPorPlaca(placa);
		 if(vehiculo != null) {
			 parqueadero.remove(vehiculo);
			 System.out.println("Vehiculo encontrado para retirara");
			 return vehiculo;
		 }
		 return null;
	 }
	 
	 public ArrayList<Vehiculo> listarVehiculo(){
		 return parqueadero;
	 }
	 
	 
}

package com.krakedev.paqueadero.servicios;

import java.time.LocalDate;
import java.util.ArrayList;

import com.krakedev.paqueadero.modelo.TicketCobro;
import com.krakedev.paqueadero.modelo.Vehiculo;

public class ServicioCobro {
	private final ServicioVehiculos servicioVehiculos;
	private ArrayList<TicketCobro> historicoTickets = new ArrayList<>();
	
	public ServicioCobro(ServicioVehiculos servicioVehiculos) {
	 this.servicioVehiculos = servicioVehiculos;
	}
	
	public TicketCobro procesarSalida(String placa, int horas) {
		Vehiculo vehiculo = servicioVehiculos.retirarVehiculo(placa);
		
		if(vehiculo == null) {
			return null;
		}
		double total = vehiculo.calcularTarifa(horas);
		String codigoTicket = "TCK" + (int)(Math.random() * 9000 + 100);
		TicketCobro ticket = new TicketCobro(codigoTicket, vehiculo, horas, total, LocalDate.now());
		historicoTickets.add(ticket);
		
		return ticket;
	}
	
	public double calcularTotalRecaudado() {
		double totalRecaudado = 0.0;
		for(TicketCobro ticket : historicoTickets) {
			totalRecaudado += ticket.getTotalPagar();
		}
		return totalRecaudado;
	}
	
	public ArrayList<TicketCobro> listarTickets(){
		return historicoTickets;
	}
}

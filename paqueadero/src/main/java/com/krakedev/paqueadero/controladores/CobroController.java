package com.krakedev.paqueadero.controladores;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.krakedev.paqueadero.modelo.TicketCobro;
import com.krakedev.paqueadero.servicios.ServicioCobro;

public class CobroController {
	private final ServicioCobro servicioCobro;
	
	public CobroController(ServicioCobro servicioCobro) {
		this.servicioCobro = servicioCobro;
	}
	
	@PostMapping("/cobros/procesar/{placa}/{horas}")
	public TicketCobro procesarSalida(@PathVariable String placa, @PathVariable int horas) {
		return servicioCobro.procesarSalida(placa, horas);
	}
	
	@GetMapping("/total")
	public double obtenerTotalRecaudado() {
		return servicioCobro.calcularTotalRecaudado();				
	}
	
	@GetMapping("/historial")
	public ArrayList<TicketCobro> listarHistorial(){
		return servicioCobro.listarTickets();
	}
}

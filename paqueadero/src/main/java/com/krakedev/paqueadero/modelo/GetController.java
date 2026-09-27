package com.krakedev.paqueadero.modelo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetController {
	@GetMapping("/prueba")
	public String obtener() {
		return "prueba de que funcione en postman y que muestre lo que se busca";
	}
}

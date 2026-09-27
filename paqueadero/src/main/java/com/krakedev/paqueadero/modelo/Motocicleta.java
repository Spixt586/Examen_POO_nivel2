package com.krakedev.paqueadero.modelo;

public class Motocicleta extends Vehiculo {
	private int cilindraje;

	public Motocicleta(String placa, String propietario, int cilindraje) {
		super(placa, propietario);
		this.cilindraje = cilindraje;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public double calcularTarifa(int horasPermanencia) {
		double valorPorHora = 0.75;
		double valorTotal = horasPermanencia * valorPorHora;
		if (cilindraje > 250) {
			valorPorHora = 1;
		}
		return valorTotal;
	}
}

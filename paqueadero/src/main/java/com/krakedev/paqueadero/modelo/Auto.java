package com.krakedev.paqueadero.modelo;

public class Auto extends Vehiculo{
	private int numeroPuertas;
	
	public Auto(String placa, String propietario, int numeroPuertas) {
		super(placa, propietario);
		this.numeroPuertas = numeroPuertas;
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	
	public double calcularTarifa(int horasPermanencia) {
		double valorPorHora = 1.50;
		double valorTotal = horasPermanencia * valorPorHora;
		if(horasPermanencia > 4) {
			valorTotal += 2;
		}
		return valorTotal;
	}
}

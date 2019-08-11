package com.juego.GoTo.model;

import javafx.scene.image.ImageView;

	public class Vehiculo {

	private ImageView[] imagenes;
	
	public Vehiculo() {
		imagenes = new ImageView[4];
		cargarImagenes();
	}
	
	private void cargarImagenes() {
		
		imagenes[0] = new ImageView("/imagenes/carroDerecha.png");
		imagenes[1] = new ImageView("/imagenes/carroIzquierda.png");
		imagenes[2] = new ImageView("/imagenes/carroFrente.png");
		imagenes[3] = new ImageView("/imagenes/carroAtras.png");
	}
	
	public ImageView getImageView(String poscicion) {
		
		switch (poscicion) {
		case "derecha":
			return imagenes[0];
		
		case "izquierda":
			return imagenes[1];
		
		case "frente": 
			return imagenes[2];
			
		case "atras":
			return imagenes[3];

		default:
			return null;
		}
	}
}

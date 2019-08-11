package com.juego.GoTo.model;

import javafx.scene.image.ImageView;

public class Personaje {

	private ImageView[] imagenes;
	
	public Personaje() {
		imagenes = new ImageView[4];
		cargarImagenes();
	}
	
	private void cargarImagenes() {
		
		imagenes[0] = new ImageView("/imagenes/personajeDerecha.png");
		imagenes[1] = new ImageView("/imagenes/personajeIzquierda.png");
		imagenes[2] = new ImageView("/imagenes/personajeFrente.png");
		imagenes[3] = new ImageView("/imagenes/personajeAtras.png");
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

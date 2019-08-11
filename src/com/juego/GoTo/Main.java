package com.juego.GoTo;

import com.juego.GoTo.model.Tablero;
import com.juego.GoTo.view.WebCamController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	private String nombreJugador;
	private int nivel = 1;
	private Tablero tablero;
	private Scene scene;
	private GridPane tableroJuego;
	private Label lbSegundos;
	
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			this.primaryStage = primaryStage;
			showMenu();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void showMenu() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/WebCamView.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Scene scene2 = new Scene(root);
		
			WebCamController webcamControlador = loader.getController();
			webcamControlador.setMain(this);
			primaryStage.setScene(scene2);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showPartida() {
		
		tablero = new Tablero();
		tablero.setMain(this);
		tablero.setNombreJugador(nombreJugador);
		tableroJuego = tablero.getTablero(nivel);
		
		Label lbTiempo = new Label("Tiempo :");
		lbTiempo.setTextFill(Color.BLACK);
		lbTiempo.setFont(new Font("Arial", 30));
		lbSegundos = new Label();
		lbSegundos.setFont(new Font("Arial", 30));
		
		HBox hBoxTiempo = new HBox();
		hBoxTiempo.setAlignment(Pos.CENTER);
		hBoxTiempo.setSpacing(40);
		hBoxTiempo.getChildren().addAll(lbTiempo, lbSegundos);
		
		AnchorPane pane = new AnchorPane();
		pane.getChildren().add(tableroJuego);
		AnchorPane.setLeftAnchor(tableroJuego, 15.00);
		AnchorPane.setRightAnchor(tableroJuego, 15.00);
		
		Button btnIntentar = new Button("Volver a Intentar");
		btnIntentar.setTextFill(Color.BLACK);
		cargarEstilo(btnIntentar);
		
		Button btnMenu = new Button("Menu");
		btnMenu.setTextFill(Color.BLACK);
		cargarEstilo(btnMenu);
		
		HBox hboxBotones = new HBox();
		hboxBotones.setAlignment(Pos.CENTER);
		hboxBotones.setSpacing(40);
		hboxBotones.getChildren().addAll(btnIntentar, btnMenu);
		
		VBox vBox = new VBox();			
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(hBoxTiempo, pane, hboxBotones);
		
		scene = new Scene(vBox);	
		cargarEvento();
	
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		btnIntentar.setOnMouseClicked( e->{
			tablero.detenerTiempo();
			showPartida();
		});
		
		btnMenu.setOnMouseClicked( e->{
			showMenu();
		});
	}
	
	private void cargarEstilo(Button btn) {
		
		btn.setStyle("-fx-background-color: \r\n" + 
				"        #090a0c,\r\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\r\n" + 
				"        linear-gradient(#20262b, #191d22),\r\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\r\n" + 
				"    -fx-background-radius: 5,4,3,5;\r\n" + 
				"    -fx-background-insets: 0,1,2,0;\r\n" + 
				"    -fx-text-fill: white;\r\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\r\n" + 
				"    -fx-font-family: \"Arial\";\r\n" + 
				"    -fx-text-fill: linear-gradient(white, #d0d0d0);\r\n" + 
				"    -fx-font-size: 12px;\r\n" + 
				"    -fx-padding: 10 20 10 20;");
	}
	
	private void cargarEvento() {
		
		scene.setOnKeyPressed((KeyEvent e)-> {
			
			tablero.eventoTablero(e);

		});
		
		tablero.iniciarTemporizador();
	}
	
	public void actualizarTiempo(int tiempo) {
		
		lbSegundos.setText(String.valueOf(tiempo));
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
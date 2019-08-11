package com.juego.GoTo.view;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.juego.GoTo.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WebCamController implements Initializable {
	
		private Main main;

	    @FXML
	    private ImageView iviewCamera;

	    @FXML
	    private ImageView iviewPhoto;
	    
	    @FXML
	    private TextField txtNombre;

	    @FXML
	    private Button btnJugar;
	    
	    @FXML
	    private ImageView iviewFondo;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			iviewPhoto.setImage(new Image("/imagenes/picture.png"));
			iviewFondo.setImage(new Image("/imagenes/fondoMenu.jpg"));
			
			
		}
		
		@FXML
		public void handleJugar(ActionEvent event) {
			   
			 main.setNombreJugador(txtNombre.getText());
			 main.showPartida();
			  
		}
		
		@FXML
		public void hadleFoto() {

			iviewPhoto.setOnMouseClicked(event ->{
				  
			Alert alert = new Alert (AlertType.CONFIRMATION);
			alert.setTitle("¡SONRIEEEEE!");
			alert.setHeaderText("¡SONRIEEEEE!");
			alert.setContentText("Entendido");
			ImageView imagen = new ImageView("/imagenes/camera2.png");
			imagen.setFitHeight(40);
			imagen.setFitWidth(40);
			alert.setGraphic(imagen);
					
			Optional<ButtonType> result = alert.showAndWait();
				if (result.get()== ButtonType.OK) {}
					
				else {}
				  
				 Webcam webCam = Webcam.getDefault();
				 webCam.open();
				    
				  try {
					  
					  File imagenFile = new File("D:/Eclipse - workSpace/GoTo/src/imagenes/jugador.png");
					  
					  if(imagenFile.exists()) {
						  imagenFile.delete();
						  imagenFile.createNewFile();
					  }
					  else {
						  imagenFile.createNewFile();
					  }
					  
					  ImageIO.write(webCam.getImage(), "PNG", new File("D:/Eclipse - workSpace/GoTo/src/imagenes/jugador.png"));
					  webCam.close();
					  iviewPhoto.setImage(new Image("file:/D:/Eclipse - workSpace/GoTo/src/imagenes/jugador.png"));
					  
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			  });
		    }
	 
		   public void setMain(Main main) {
			    this.main = main;
		   }
	    
	    
}

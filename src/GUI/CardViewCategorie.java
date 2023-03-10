/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categorie;
import Services.ServiceCategorie;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.control.Alert;
import Entities.Categorie;
import javafx.scene.paint.Color;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



public class CardViewCategorie extends Pane {
    
    
     
      private static final int WIDTH = 450
              ;
    private static final int HEIGHT = 400;
    private static final String BACKGROUND_COLOR = "white";
    private static final String BORDER_COLOR = "#2596be";
    private static final String TEXT_COLOR = "#2596be";
    private static final String TITLE_COLOR = "#2596be";
    private static final String DATE_COLOR = "#2596be";
    private static final String TYPE_COLOR = "#2596be";
        private final Categorie categorie;



    public CardViewCategorie(Categorie categorie) {
        
        
        this.categorie = categorie;

        setPrefSize(WIDTH, HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.web(BACKGROUND_COLOR), new CornerRadii(10), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.web(BORDER_COLOR), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
       



        Label titleLabel = new Label(categorie.getNom());
        titleLabel.setFont(Font.font("Arial", 18));
        titleLabel.setTextFill(Color.web(TITLE_COLOR));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPrefWidth(WIDTH - 20);
       // titleLabel.setLayoutY(20);
       titleLabel.setStyle("-fx-font-weight: bold;"); // pour assurer la police en gras


        Label descriptionLabel = new Label( categorie.getType());
        descriptionLabel.setFont(Font.font("Arial", 14));
        descriptionLabel.setTextFill(Color.web(TEXT_COLOR));
        descriptionLabel.setWrapText(true);
        
       //  descriptionLabel.setAlignment(Pos.TOP_LEFT);
          System.out.println(titleLabel.getAlignment());
        descriptionLabel.setPrefWidth(WIDTH - 20);
                titleLabel.setAlignment(Pos.CENTER);

    descriptionLabel.setLayoutX(-150);// Décalage horizontal vers la gauche
descriptionLabel.setLayoutY(150); // Décalage vertical vers le bas

        descriptionLabel.setTranslateX(175);

    
getChildren().addAll(titleLabel,descriptionLabel);

     





    
    
    
  }  }


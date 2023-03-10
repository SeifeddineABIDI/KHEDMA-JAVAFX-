/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categorie;
import Services.ServiceCategorie;
import javafx.event.ActionEvent;

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
import Entities.Evenement;
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import org.controlsfx.control.Rating;



public class CardViewEvenement extends Pane {
    
    
     
      private static final int WIDTH = 450
              ;
    private static final int HEIGHT = 400;
    private static final String BACKGROUND_COLOR = "white";
    private static final String BORDER_COLOR = "#2596be";
    private static final String TEXT_COLOR = "#2596be";
    private static final String TITLE_COLOR = "#2596be";
    private static final String DATE_COLOR = "#2596be";
    private static final String TYPE_COLOR = "#2596be";
        private final Evenement event;



    public CardViewEvenement(Evenement event) {
        
   
        
   
        
        
        this.event = event;

        setPrefSize(WIDTH, HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.web(BACKGROUND_COLOR), new CornerRadii(10), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.web(BORDER_COLOR), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
       


      //Setting the stage

        Label titleLabel = new Label(event.getTitre());
        titleLabel.setFont(Font.font("Arial", 18));
        titleLabel.setTextFill(Color.web(TITLE_COLOR));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPrefWidth(WIDTH - 20);
       // titleLabel.setLayoutY(20);
       titleLabel.setStyle("-fx-font-weight: bold;"); // pour assurer la police en gras


        Label descriptionLabel = new Label( event.getDescription());
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

        Label LieuLabel = new Label( event.getLieu());
        LieuLabel.setFont(Font.font("Arial", 14));
        LieuLabel.setTextFill(Color.web(TEXT_COLOR));
        LieuLabel.setWrapText(true);
       //  descriptionLabel.setAlignment(Pos.TOP_LEFT);
          System.out.println(titleLabel.getAlignment());
        LieuLabel.setPrefWidth(WIDTH - 50);
   LieuLabel.setLayoutY(100);
LieuLabel.setLayoutX(20);

        LieuLabel.setTranslateX(160);

        Label dateLabel = new Label(event.getDate21().toString());
        dateLabel.setFont(Font.font("Arial", 14));
        dateLabel.setTextFill(Color.web(TEXT_COLOR));
        dateLabel.setWrapText(true);
        dateLabel.setAlignment(Pos.CENTER);
        dateLabel.setPrefWidth(WIDTH - 40);
        dateLabel.setLayoutY(50);
        

        
        
        
        
        ServiceCategorie sc = new ServiceCategorie();
        Label idc = new Label(String.valueOf(sc.afficherById(event.getId_categorie())));
        idc.setFont(Font.font("Arial", 14));
        idc.setTextFill(Color.web(TEXT_COLOR));
        idc.setWrapText(true);
         descriptionLabel.setAlignment(Pos.TOP_LEFT);
          System.out.println(titleLabel.getAlignment());
        descriptionLabel.setPrefWidth(WIDTH - 100);
        
getChildren().addAll(titleLabel,descriptionLabel,LieuLabel,dateLabel,idc);


    QRCodeWriter QRCodeWriter;
    
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    String myWeb = "titre evenemment : " +event.getTitre()+"\n"+"description : "+event.getDescription()+"\n"+"Date : "+event.getDate21();
    int width = 150 ;
    int height = 150;
    String fileType = "png";
    
    BufferedImage bufferedImage = null;
    try {
        BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
        //BitMatrix byteMatrix = qrCodeWriter.encode(myData, BarcodeFormat.QR_CODE, width, height);
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.createGraphics();
        
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(java.awt.Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(java.awt.Color.BLACK);
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
       String picture ="file:" +  event.getImage().toString();
        Image image1 = new Image(picture, 110, 110, false, true);            
               

        ImageView img = new ImageView(picture);
        
        ImageView qrView = new ImageView();
        img.setPreserveRatio(false);
        img.setFitHeight(100);
        img.setFitWidth(160);
        img.setTranslateX(20);
        img.setTranslateY(280);
        qrView.setLayoutX(WIDTH - 160);
qrView.setLayoutY(HEIGHT - 160);
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

        
        Rating rating = new Rating(5);
        VBox layout = new VBox();
        layout.getChildren().add(rating);
        rating.setTranslateY(240);
        rating.setTranslateX(100);
        RatingController rc = new RatingController();
            rating.setRating(rc.afficherRatingById(event.getId()));
            System.out.println(rc.afficherRatingById(event.getId()));
        rating.setOnMouseClicked(ev -> {
    int newRating = (int) Math.ceil(ev.getX() / (rating.getWidth() / rating.getMax())); // calculate new rating based on mouse click position
    rating.setRating(newRating); 
    rc.add(newRating, event.getId());
            System.out.println("ok"+newRating);
            
});

        StackPane root = new StackPane();
        getChildren().add(qrView);
        getChildren().add(img);
        getChildren().add(layout);
        
    } catch (WriterException ex) {
        //Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
    }
}



 
    
    
    
    
    
  }  


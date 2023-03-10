/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import Entities.Annonce;
import Services.ServiceClassification;


public class CardViewAnnonce extends Pane {
      
      private static final int WIDTH = 450
              ;
    private static final int HEIGHT = 200;
    private static final String BACKGROUND_COLOR = "white";
    private static final String BORDER_COLOR = "#2596be";
    private static final String TEXT_COLOR = "#2596be";
    private static final String TITLE_COLOR = "#2596be";
    private static final String DATE_COLOR = "#2596be";
    private static final String TYPE_COLOR = "#2596be";
        private final Annonce annonce;



    public CardViewAnnonce(Annonce annonce) {
    
        this.annonce = annonce;

        setPrefSize(WIDTH, HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.web(BACKGROUND_COLOR), new CornerRadii(10), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.web(BORDER_COLOR), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        


      //Setting the stage

        Label titleLabel = new Label(annonce.getTitre());
        titleLabel.setFont(Font.font("Arial",FontWeight.BOLD, 18));
        titleLabel.setTextFill(Color.web(TITLE_COLOR));
        titleLabel.setStyle("-fx-underline: true;");
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPrefWidth(WIDTH - 20);
       // titleLabel.setLayoutY(20);

        Label nomLabel = new Label( annonce.getNom_client());
        System.out.println(annonce.getNom_client());
       nomLabel.setFont(Font.font("Arial", 14));
        nomLabel.setTextFill(Color.web(TEXT_COLOR));
        nomLabel.setWrapText(true);
        nomLabel.setAlignment(Pos.CENTER);

        nomLabel.setPrefWidth(WIDTH - 40);
        nomLabel.setLayoutY(40);



        Label dateLabel = new Label(annonce.getDate().toString());
        dateLabel.setFont(Font.font("Arial", 14));
        dateLabel.setTextFill(Color.web(TEXT_COLOR));
        dateLabel.setWrapText(true);
        dateLabel.setAlignment(Pos.CENTER);

        dateLabel.setPrefWidth(WIDTH - 40);
        dateLabel.setLayoutY(75);
        ServiceClassification sc = new ServiceClassification();
        Label idc = new Label(String.valueOf(sc.afficherById(annonce.getId_c())));
        idc.setFont(Font.font("Arial Black",FontWeight.BOLD, 14));
        idc.setTextFill(Color.web(TEXT_COLOR));
        idc.setAlignment(Pos.CENTER);
        idc.setWrapText(true);
        idc.setPrefWidth(WIDTH - 55);
        idc.setLayoutY(90);
       //  descriptionLabel.setAlignment(Pos.TOP_LEFT);
          System.out.println(titleLabel.getAlignment());
        nomLabel.setPrefWidth(WIDTH - 100);
        VBox labelsBox = new VBox(10, titleLabel, nomLabel, dateLabel, idc);
labelsBox.setAlignment(Pos.CENTER);
labelsBox.setPrefWidth(WIDTH - 40);
labelsBox.setLayoutY(50);

getChildren().add(labelsBox);
//getChildren().addAll(titleLabel,nomLabel,dateLabel,idc);

      



    
    
    }
}
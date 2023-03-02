/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Safe
 */
import Entities.Metier;
import java.text.SimpleDateFormat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


public class CardView extends Pane {
      
      private static final int WIDTH = 450
              ;
    private static final int HEIGHT = 250;
    private static final String BACKGROUND_COLOR = "white";
    private static final String BORDER_COLOR = "#2596be";
    private static final String TEXT_COLOR = "#2596be";
    private static final String TITLE_COLOR = "#2596be";
    private static final String DATE_COLOR = "#2596be";
    private static final String TYPE_COLOR = "#2596be";
        private final Metier metier;



    public CardView(Metier metier) {
    
        this.metier = metier;

        setPrefSize(WIDTH, HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.web(BACKGROUND_COLOR), new CornerRadii(10), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.web(BORDER_COLOR), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        


      //Setting the stage

        Label titleLabel = new Label(metier.getNom());
        titleLabel.setFont(Font.font("Arial", 18));
        titleLabel.setTextFill(Color.web(TITLE_COLOR));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPrefWidth(WIDTH - 20);
        titleLabel.setLayoutY(20);

        Label descriptionLabel = new Label( metier.getType());
        descriptionLabel.setFont(Font.font("Arial", 14));
        descriptionLabel.setTextFill(Color.web(TEXT_COLOR));
        descriptionLabel.setWrapText(true);
       //  descriptionLabel.setAlignment(Pos.TOP_LEFT);
          System.out.println(titleLabel.getAlignment());
        descriptionLabel.setPrefWidth(WIDTH - 100);
        descriptionLabel.setLayoutY(100);
        descriptionLabel.setLayoutX(500);
descriptionLabel.setTranslateX(175);



        Label paysLabel = new Label(metier.getDescription());
        paysLabel.setFont(Font.font("Arial", 14));
        paysLabel.setTextFill(Color.web(TEXT_COLOR));
        paysLabel.setWrapText(true);
        paysLabel.setAlignment(Pos.CENTER);

        paysLabel.setPrefWidth(WIDTH - 40);
        paysLabel.setLayoutY(75);
        
        
   String picture ="file:" +  metier.getImage().toString();
        Image image1 = new Image(picture, 110, 110, false, true);            
        
               ImageView im =new ImageView(image1);
             //  im.setLayoutX(50);
               im.setLayoutY(HEIGHT+100);
      



        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 20, 20, 020));
        borderPane.setTop(titleLabel);
        borderPane.setCenter(descriptionLabel);
       borderPane.setCenter(im);
        borderPane.setTop(descriptionLabel);
      
        im.setFitHeight(70  );
        im.setFitWidth(90);
        
      
        borderPane.setBottom(new Pane(titleLabel, paysLabel));
      //  borderPane.setTop(new Pane(im));


        getChildren().addAll(borderPane);
       
    
    
    
    
    }
}
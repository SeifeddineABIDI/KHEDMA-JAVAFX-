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
import Entities.SousMetier;
import Services.ServiceSousMetier;
import com.jfoenix.controls.JFXButton;
import java.text.SimpleDateFormat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


public class CardViewSousMetier extends Pane {
      
      private static final int WIDTH = 450
              ;
    private static final int HEIGHT = 250;
    private static final String BACKGROUND_COLOR = "white";
    private static final String BORDER_COLOR = "#2596be";
    private static final String TEXT_COLOR = "#2596be";
    private static final String TITLE_COLOR = "#2596be";
    private static final String DATE_COLOR = "#2596be";
    private static final String TYPE_COLOR = "#2596be";
        private final SousMetier sousmetier;



    public CardViewSousMetier(SousMetier sousmetier) {
    
        this.sousmetier = sousmetier;

        setPrefSize(WIDTH, HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.web(BACKGROUND_COLOR), new CornerRadii(10), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.web(BORDER_COLOR), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        


      //Setting the stage

        Label titleLabel = new Label(sousmetier.getLibelle());
        titleLabel.setFont(Font.font("Arial", 18));
        titleLabel.setTextFill(Color.web(TITLE_COLOR));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPrefWidth(WIDTH - 20);
        titleLabel.setLayoutY(20);





        Label paysLabel = new Label(sousmetier.getDomaine());
        paysLabel.setFont(Font.font("Arial", 14));
        paysLabel.setTextFill(Color.web(TEXT_COLOR));
        paysLabel.setWrapText(true);
        paysLabel.setAlignment(Pos.CENTER);

        paysLabel.setPrefWidth(WIDTH - 40);
        paysLabel.setLayoutY(75);
        
        




        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 20, 20, 020));
        borderPane.setTop(titleLabel);

      

      
        borderPane.setBottom(new Pane(titleLabel, paysLabel));
      //  borderPane.setTop(new Pane(im));
       
        getChildren().addAll(borderPane);

    
    
    
    
    } }
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
import Entities.User;
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


public class CardViewSousMetierUsers extends Pane {
      
      private static final int WIDTH = 450
              ;
    private static final int HEIGHT = 200;
    private static final String BACKGROUND_COLOR = "white";
    private static final String BORDER_COLOR = "#2596be";
    private static final String TEXT_COLOR = "#2596be";
    private static final String TITLE_COLOR = "#2596be";
    private static final String DATE_COLOR = "#2596be";
    private static final String TYPE_COLOR = "#2596be";
        private final User user;



    public CardViewSousMetierUsers(User user) {
    
        this.user = user;

        setPrefSize(WIDTH, HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.web(BACKGROUND_COLOR), new CornerRadii(10), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.web(BORDER_COLOR), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        


      //Setting the stage

        Label label_nom = new Label(user.getNom()+" "+user.getPrenom());
        label_nom.setFont(Font.font("Arial", 18));
        label_nom.setTextFill(Color.web(TITLE_COLOR));
        label_nom.setAlignment(Pos.CENTER);
        label_nom.setPrefWidth(WIDTH - 20);
        label_nom.setLayoutY(20);
        
      




 Label label_tel = new Label("Tel: "+user.getTelephone());
        label_tel.setFont(Font.font("Arial", 14));
        label_tel.setTextFill(Color.web(TEXT_COLOR));
        label_tel.setWrapText(true);
        label_tel.setAlignment(Pos.CENTER);

        label_tel.setPrefWidth(WIDTH - 40);
        label_tel.setLayoutY(75);
        
                Label label_email = new Label(user.getEmail());
        label_email.setFont(Font.font("Arial", 14));
        label_email.setTextFill(Color.web(TEXT_COLOR));
        label_email.setWrapText(true);
        label_email.setAlignment(Pos.CENTER);

        label_email.setPrefWidth(WIDTH - 40);
        label_email.setLayoutY(75);
        
        


        
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 20, 20, 20));
        borderPane.setTop(label_nom);
       

      

      
        borderPane.setBottom(new Pane(label_email,label_tel));
        borderPane.setTop(new Pane(label_nom));
       borderPane.setRight(label_tel);
        getChildren().addAll(borderPane);

    
    
    
    
    } }
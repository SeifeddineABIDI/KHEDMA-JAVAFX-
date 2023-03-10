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
import Entities.freelancer;
import Services.ServiceSousMetier;
import Utils.MyDB;
import com.jfoenix.controls.JFXButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;


public class CardViewSousMetier extends Pane {
      
      private static final int WIDTH = 450
              ;
    private static final int HEIGHT = 200;
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
        ServiceSousMetier ssm = new ServiceSousMetier();
        Button button = new JFXButton(ssm.countFreelancerBySousMetier(sousmetier.getId())+" Freelancers");
        button.setBackground(getBackground());
        //button.ripplerFillProperty().set(Color.web("#0077B6"));
        button.setTextFill(Color.web("#0077B6"));
        button.setPrefSize(100, 50);
       button.setFont(Font.font("family", FontWeight.BOLD, 12));
         
       
       
       button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                myFunction(event);
            }
        });
    
    //    button.setButtonType(JFXButton.ButtonType.FLAT);
      
        getChildren().add(button);



 button.setTranslateY(120);
        button.setTranslateX(120);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 20, 20, 020));
        borderPane.setTop(titleLabel);

      

      
        borderPane.setBottom(new Pane(titleLabel, paysLabel,button));
      //  borderPane.setTop(new Pane(im));
       
        getChildren().addAll(borderPane);

    
    
    
    
    }


    Connection cnx;
    int val;



       public void myFunction(ActionEvent event) {
             CurrentSousMetier csm =  new CurrentSousMetier();
         
      
        csm.CurrentSousMetier_id=sousmetier.getId();
             System.out.println(sousmetier.getId());
              
    try {
                  final Node source = (Node) event.getSource();

         
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SousMetierUsers.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
             
            stage.show();
           
    } catch(Exception e) {
        e.printStackTrace();
    }
}


}
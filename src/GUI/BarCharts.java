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
import Services.ServiceMetier;
import Services.ServiceSousMetier;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BarCharts extends Pane {

    
    public BarCharts() {
        // Create the x-axis and y-axis
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create the bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setPrefSize(850, 550);
        
        ServiceMetier sm = new ServiceMetier();
        ServiceSousMetier ssm =new ServiceSousMetier();
        List<String> names = new ArrayList<>();
        names= ssm.afficherAllNames();
        // Add data to the chart
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        //series1.setName("Sous Metiers");
       
          System.out.println(names);
        for (String item:names){
            
        series1.getData().add(new XYChart.Data<>(item,ssm.countFreelancerBySousMetier(ssm.getIdByNom(item))));
          
        }
       // XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        

        // Add the series to the chart
        barChart.getData().add(series1);
        for (int i=0;i<names.size();i++){
         series1.getData().get(i).getNode().setStyle("-fx-bar-fill:  #0077B6;");
        }
        //barChart.getData().add(series2);

        // Set chart properties
        barChart.setTitle("Nombre d'utilisateurs par Sous-Métier");
        xAxis.setLabel("Sous-Métiers");
        yAxis.setLabel("Nombre d'utilisateurs");
                // Create a scene and add the chart to it
                
                BorderPane borderPane = new BorderPane();
                borderPane.setLayoutX(8);
                borderPane.setCenter(barChart);
                getChildren().addAll(borderPane);

    }

 }
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressources;

import Utils.AlertMaker;
import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author donia
 */
public class Util {
     public String ImgPicker (){ 
        Stage secondStage = new Stage();
    ImageView imageView = new ImageView();
    FileChooser fc =new FileChooser() ;
     fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files (*.png)", "*.png"));
    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files (*.jpg)","*.jpg"));
    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files (*.jpeg)","*.jpeg"));
    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files (*.jfif)","*.jfif"));

    File f = fc.showOpenDialog(null);

    Image image = new Image(f.toURI().toString());
               FileChooser fileChooser = new FileChooser();
               fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images ","*.png"));
                fileChooser.setTitle("Save Image");
                
                File file = fileChooser.showSaveDialog(secondStage);
                
                if (file != null) {
                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(image,null), "png", file);
                    } catch (IOException ex) {
                        ex.getMessage() ;
                    }

                    }

         
    if (f != null ){
         
        System.out.println(f.getAbsolutePath());
                System.out.println("the file will be uploaded here"+ file.getAbsolutePath());

    }
    
String str = file.getAbsolutePath();
		System.out.println(" we are going to take the relative from here  "+ str);
		// find word in String
		String find = "\\ressources";
		int i = str.indexOf(find);
                
		if(i>0){
                    System.out.println(str.substring(i, str.length()));
                    
			return str.substring(i, str.length());}
		else {
                    System.out.println("string not found");
			return "string not found";
                }
    }
      public static void initPDFExprot(StackPane rootPane, Node contentPane, Stage stage, List<List> data) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as PDF");
        FileChooser.ExtensionFilter extFilter
                = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
        File saveLoc = fileChooser.showSaveDialog(stage);
        ListToPDF ltp = new ListToPDF();
        boolean flag = ltp.doPrintToPdf(data, saveLoc, ListToPDF.Orientation.LANDSCAPE);
        JFXButton okayBtn = new JFXButton("Okay");
        JFXButton openBtn = new JFXButton("View File");
        openBtn.setOnAction((ActionEvent event1) -> {
            try {
                Desktop.getDesktop().open(saveLoc);
            } catch (Exception exp) {
                AlertMaker.showErrorMessage("Could not load file", "Cant load file");
            }
        });
        if (flag) {
            AlertMaker.showMaterialDialog(rootPane, contentPane, Arrays.asList(okayBtn, openBtn), "Completed", "Member data has been exported.");
        }
    }  
}

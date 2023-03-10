/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categorie;
import Entities.Evenement;
import Services.ServiceCategorie;
import Services.ServiceEvenement;
import Utils.MyDB;
import com.jfoenix.controls.JFXButton;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Evenement_Controller implements Initializable {

    @FXML
    private AnchorPane anch;
    @FXML
    private TableView<Evenement> table;
    @FXML
    private TableColumn<Evenement, Integer> col_id;
    @FXML
    private TableColumn<Evenement, String> col_titre;
    @FXML
    private TableColumn<Evenement, Date> col_date;
    @FXML
    private TableColumn<Evenement, String> col_description;
    @FXML
    private TableColumn<Evenement, String> col_lieu;
    @FXML
    private TableColumn<Evenement, Integer> col_prix;
    @FXML
    private TableColumn<Evenement, Integer> col_Id_categorie;
    @FXML
    private TableColumn<Evenement, String> col_image;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ServiceCategorie sa = new ServiceCategorie();
    @FXML
    private TextField txt_titre;
    @FXML
    private TextField txt_description;
    @FXML
    private TextField txt_lieu;
    @FXML
    private TextField txt_id;
    @FXML
    private DatePicker inputdate;
    @FXML
    private TextField txt_prix;
    @FXML
    private TextField txt_Id_categorie;
    Evenement eve;
    @FXML
    private ComboBox<String> combo_c;

    @FXML
    private TextField txt_keyword;
    @FXML
    private ImageView image_view;
    @FXML
    private Label filr_path;
    @FXML
    private Label img_msg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxList();

        col_titre.prefWidthProperty().bind(table.widthProperty().divide(3)); // w * 1/4
        col_description.prefWidthProperty().bind(table.widthProperty().divide(3)); // w * 1/2
        col_lieu.prefWidthProperty().bind(table.widthProperty().divide(3));
        col_Id_categorie.prefWidthProperty().bind(table.widthProperty().divide(3));
        col_date.prefWidthProperty().bind(table.widthProperty().divide(3));

        updateTable();
    }

    public void clearTextField() {
        txt_id.clear();
        txt_titre.clear();
        txt_description.clear();
        txt_lieu.clear();
        txt_Id_categorie.clear();
        filr_path.setText(null);
        image_view.setImage(null);
    }

    @FXML
    public void add_evenment() {
        System.out.println(inputdate.getValue());
        if (txt_titre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Textfield can't be empty");

        } else if (txt_description.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Textfield can't be empty");
        } else if (combo_c.getValue() == null) {
            JOptionPane.showMessageDialog(null, "ComboBox can't be empty");
        } else if (inputdate.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Date can't be empty");
        } else if (txt_lieu.getText().toString().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Textfield can't be empty");
        } else {
            ZoneId defaultZoneId = ZoneId.systemDefault();

            java.util.Date date = java.util.Date.from(inputdate.getValue().atStartOfDay(defaultZoneId).toInstant());

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            conn = MyDB.getInstance().getCnx();

            String titre = txt_titre.getText();
            String descp = txt_description.getText();
            String pla = txt_lieu.getText();
            int prix = Integer.parseInt(txt_prix.getText());
            int ids = sa.getIdByNom(combo_c.getValue());
            String image = filr_path.getText();
            System.out.println(image);
            String qry = "Insert into evenement (titre,description,lieu,date,id_categorie,prix,image) values ('" + titre + "','" + descp + "','" + pla + "','" + sqlDate + "','" + ids + "','" + prix + "','" + image + "')";

            System.out.println(ids);
            try {
                pst = conn.prepareStatement(qry);
                //  pst.setString(1, null);

                pst.execute();
                UIManager.put("OptionPane.minimumSize", new Dimension(200, 200));
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                        "Arial", Font.BOLD, 30)));
                JOptionPane.showMessageDialog(null, "Evenement ajoutée avec succès");
                clearTextField();
                updateTable();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    @FXML
    public void edit(ActionEvent event) {
        try {
            boolean ok = true;
            int c;

            conn = MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
            String value2 = txt_titre.getText();
            String value3 = inputdate.getValue().toString();
            String value4 = txt_description.getText();
            String value5 = txt_lieu.getText();
            String value6 = txt_prix.getText();
            String value7 = txt_Id_categorie.getText();
            String value8 = filr_path.getText();
            String sql = "UPDATE `evenement` SET `titre`='" + value2 + "', `description`='" + value4 + "',`Lieu`='" + value5 + "',`date`='" + value3 + "',`prix`='" + value6 + "',`image`='" + value8 + "' WHERE `id`='" + value1 + "'";

            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modifié");
            clearTextField();
            updateTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    @FXML
    private void insertImage(Event event) {
        FileChooser open = new FileChooser();

        Stage stage = (Stage) anch.getScene().getWindow();

        File file = open.showOpenDialog(stage);

        if (file != null) {

            String path = file.getAbsolutePath();

            path = path.replace("\\", "\\\\");

            filr_path.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);

            image_view.setImage(image);
            img_msg.setVisible(false);
        } else {

            System.out.println("NO DATA EXIST!");

        }

    }

    @FXML
    public void supprimer(ActionEvent event) {
        try {
            conn = MyDB.getInstance().getCnx();
            String value1 = col_id.getCellData(index).toString();
            String sql = "UPDATE `evenement` SET `archive`='" + 1 + "' WHERE `id`='" + value1 + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Evenement supprimé");
            clearTextField();

            updateTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    @FXML
    public void updateTable() {
        String val = combo_c.getValue();

        ServiceEvenement se = new ServiceEvenement();
        List<Evenement> Evenements = se.afficherByNomCategorie(val);
        ObservableList<Evenement> listE = FXCollections.observableArrayList(Evenements);
        col_id.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("id"));
        col_titre.setCellValueFactory(new PropertyValueFactory<Evenement, String>("titre"));

        col_description.setCellValueFactory(new PropertyValueFactory<Evenement, String>("description"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<Evenement, String>("Lieu"));

        col_date.setCellValueFactory(new Callback<CellDataFeatures<Evenement, Date>, ObservableValue<Date>>() {

            @Override
            public ObservableValue<Date> call(CellDataFeatures<Evenement, Date> inpudate) {
                return new SimpleObjectProperty<Date>(inpudate.getValue().getDate21());
            }
        });
        col_image.setCellValueFactory(new PropertyValueFactory<Evenement, String>("image"));
        col_date.setCellFactory(col_date -> new TableCell<Evenement, Date>() {
            @Override
            protected void updateItem(Date item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = formatter.format(item);
                    setText(formattedDate);
                }
            }
        });

        col_prix.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("prix"));
        // col_Id_categorie.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("id_categorie"));

        // listE=se.afficherData();
        table.setItems(listE);
        FilteredList<Evenement> filteredData = new FilteredList<>(listE, b -> true);
        ObservableList<Evenement> newdata = listE.stream().filter(n -> n.getTitre().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getDescription().toLowerCase().contains(txt_keyword.getText().toLowerCase())
                || n.getLieu().toLowerCase().contains(txt_keyword.getText().toLowerCase()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        table.setItems(newdata);
    }

    @FXML
    void getSelected(MouseEvent event) {
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        img_msg.setVisible(false);
        txt_id.setText(col_id.getCellData(index).toString());
        txt_titre.setText(col_titre.getCellData(index));

        Date date_conv = (Date) table.getItems().get(index).getDate21();
        LocalDate localDate = date_conv.toLocalDate();
        inputdate.setValue(localDate);

        txt_description.setText(col_description.getCellData(index));
        txt_lieu.setText(col_lieu.getCellData(index).toString());
        txt_prix.setText(col_prix.getCellData(index).toString());
        //col_Id_categorie.setText(col_Id_categorie.getCellData(index).toString());
        String picture = "file:" + col_image.getCellData(index).toString();
        filr_path.setText(col_image.getCellData(index).toString());
        Image image1 = new Image(picture, 110, 110, false, true);
        image_view.setImage(image1);

    }

    @FXML
    public void redirectToCategorie(ActionEvent event) throws Exception {
        try {
            final Node source = (Node) event.getSource();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Categorie.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));

            stage.show();

        } catch (IOException e) {
        }
    }

    public void comboBoxList() {
        ServiceCategorie sa = new ServiceCategorie();
        List<Categorie> categories = sa.afficherAllNames();
        List<String> namesList = new ArrayList<>();
        namesList = categories.stream()
                .map(categorie -> categorie.getNom())
                .collect(Collectors.toList());
        ObservableList<String> observablec = FXCollections.observableArrayList(namesList);

        combo_c.setItems(observablec);
    }
 private Stage getStage() {
        return (Stage) txt_description.getScene().getWindow();
    }

    private void closeStage(ActionEvent event) {
        getStage().close();
    }
    @FXML
    private void retern(ActionEvent event) {
        
         try {
                  final Node source = (Node) event.getSource();

          
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FrontFreelancer.fxml"));
            Parent root = (Parent) fxmlLoader.load();
           final Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root)); 
            stage.show();
            closeStage( event);
    } catch(Exception e) {
        e.printStackTrace();
    } 
        
    }

}

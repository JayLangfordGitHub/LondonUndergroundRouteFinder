package com.example.londonundergroundassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public ComboBox<String> fromComboBox;
    @FXML
    public ComboBox<String> destinationComboBox;
    @FXML
    public Button searchButton;
    @FXML
    public ImageView mapImageView;
    @FXML
    public TableView routesTableView;
    @FXML
    private Canvas canvasImage;
    public String csvData = "Central Line,Notting Hill Gate,df002c,108,285\n" +
            "Central Line,Queensway,df002c,164,272\n" +
            "Central Line,Lancaster Gate,df002c,242,259\n" +
            "Central Line,Marble Arch,df002c,352,242\n" +
            "Central Line,Bond Street,df002c,410,236\n" +
            "Central Line,Oxford Circus,df002c,460,227\n" +
            "Central Line,Tottenham Court Road,df002c,527,213\n" +
            "Central Line,Holborn,df002c,597,204\n" +
            "Central Line,Chancery Lane,df002c,655,192\n" +
            "Central Line,St. Paul's,df002c,743,232\n" +
            "Central Line,Bank,df002c,797,245\n" +
            "Central Line,Liverpool Street,df002c,837,199\n" +
            "Picadilly Line,Earl's Court,002d73,105,462\n" +
            "Picadilly Line,Gloucester Road,002d73,197,437\n" +
            "Picadilly Line,South Kensington,002d73,254,441\n" +
            "Picadilly Line,Knightsbridge,002d73,338,363\n" +
            "Picadilly Line,Hyde Park Corner,002d73,389,353\n" +
            "Picadilly Line,Green Park,002d73,452,313,\n" +
            "Picadilly Line,Picadilly Circus,002d73,507,281\n" +
            "Picadilly Line,Leicester Square,002d73,546,266\n" +
            "Picadilly Line,Covent Garden,002d73,572,250\n" +
            "Picadilly Line,Holborn,002d73,597,204\n" +
            "Picadilly Line,Russell Square,002d73,568,145\n" +
            "Picadilly Line,King's Cross St. Pancras,002d73,572,67\n" +
            "Bakerloo Line,Paddington,ab6612,244,224\n" +
            "Bakerloo Line,Edgware Road,ab6612,278,174\n" +
            "Bakerloo Line,Marylebone,ab6612,323,151\n" +
            "Bakerloo Line,Baker Street,ab6612,361,150\n" +
            "Bakerloo Line,Regent's Park,ab6612,392,141\n" +
            "Bakerloo Line,Oxford's Circus,ab6612,460,227\n" +
            "Bakerloo Line,Picadilly Circus,ab6612,507,281\n" +
            "Bakerloo Line,Charing Cross,ab6612,567,300\n" +
            "Bakerloo Line,Embankment,ab6612,583,306\n" +
            "Bakerloo Line,Waterloo,ab6612,633,344\n" +
            "Bakerloo Line,Lambeth North,ab6612,650,390\n" +
            "Bakerloo Line,Elephant & Castle,ab6612,723,438\n" +
            "Circle Line,Edgware Road,f7dc00,292,181\n" +
            "Circle Line,Paddington,f7dc00,242,212\n" +
            "Circle Line,Paddington,f7dc00,244,224\n" +
            "Circle Line,Bayswater,f7dc00,165,257\n" +
            "Circle Line,Notting Hill Gate,f7dc00,108,285\n" +
            "Circle Line,High Street Kensington,f7dc00,135,371\n" +
            "Circle Line,Gloucester Road,f7dc00,197,437\n" +
            "Circle Line,South Kensington,f7dc00,254,441\n" +
            "Circle Line,Sloane Square,f7dc00,365,459\n" +
            "Circle Line,Victoria,f7dc00,440,416\n" +
            "Circle Line,St. James Park,f7dc00,511,387\n" +
            "Circle Line,Westminster,f7dc00,563,371\n" +
            "Circle Line,Embankment,f7dc00,583,306\n" +
            "Circle Line,Temple,f7dc00,635,268\n" +
            "Circle Line,Blackfriars,f7dc00,705,258\n" +
            "Circle Line,Mansion House,f7dc00,764,259\n" +
            "Circle Line,Cannon Street,f7dc00,786,266\n" +
            "Circle Line,Tower Hill,f7dc00,874,281\n" +
            "Circle Line,Aldgate,f7dc00,881,236\n" +
            "Circle Line,Liverpool Street,f7dc00,837,199\n" +
            "Circle Line,Moorgate,f7dc00,797,192\n" +
            "Circle Line,Barbican,f7dc00,738,173\n" +
            "Circle Line,Farringdon,f7dc00,691,174\n'" +
            "Circle Line,King's Cross St. Pacras,f7dc00,572,67\n" +
            "Circle Line,Euston Square,f7dc00,496,117\n" +
            "Circle Line,Great Portland Street,f7dc00,445,138\n" +
            "Circle Line,Edgware Road,f7dc00,292,181\n" +
            "Circle Line,Paddington,f7dc00,244,224\n" +
            "Victoria Line,King's Cross St. Pancras,0076bd,572,67\n" +
            "Victoria Line,Euston,0076bd,509,94\n" +
            "Victoria Line,Warren Street,0076bd,480,132\n" +
            "Victoria Line,Oxford Circus,0076bd,460,227\n" +
            "Victoria Line,Green Park,0076bd,452,313\n" +
            "Victoria Line,Victoria,0076bd,440,416\n" +
            "Victoria Line,Pimclo,0076bd,515,490\n" +
            "Victoria Line,Vauxhall,0076bd,563,522\n" +
            "District Line,Edgware Road,0d6928,292,181\n" +
            "District Line,Paddington,0d6928,244,224\n" +
            "District Line,Bayswater,0d6928,165,257\n" +
            "District Line,Notting Hill Gate,0d6928,108,285\n" +
            "District Line,High Street Kensington,0d6928,135,371\n" +
            "District Line,Earl's Court,0d6928,105,462\n" +
            "District Line,Gloucester Road,0d6928,197,437\n" +
            "District Line,South Kensington,0d6928,254,441\n" +
            "District Line,Sloane Square,0d6928,365,459\n" +
            "District Line,Victoria,0d6928,440,416\n" +
            "District Line,St. James Park,0d6928,511,387\n" +
            "District Line,Westminster,0d6928,563,371\n" +
            "District Line,Embankment,0d6928,583,306\n" +
            "District Line,Temple,0d6928,635,268\n" +
            "District Line,Blackfriars,0d6928,705,258\n" +
            "District Line,Mansion House,0d6928,764,259\n" +
            "District Line,Cannon Street,0d6928,786,266\n" +
            "District Line,Tower Hill,0d6928,874,281\n" +
            "District Line,Aldgate East,0d6928,899,224\n" +
            "Metropolitan Line,Baker Street,8b004c,361,150\n" +
            "Metropolitan Line,Great Portland Street,8b004c,445,138\n" +
            "Metropolitan Line,Euston Square,8b004c,496,117\n" +
            "Metropolitan Line,King's Cross St. Pacras,8b004c,572,67\n" +
            "Metropolitan Line,Farringdon,8b004c,691,174\n" +
            "Metropolitan Line,Barbican,8b004c,738,173\n" +
            "Metropolitan Line,Moorgate,8b004c,797,192\n" +
            "Metropolitan Line,Liverpool Street,8b004c,837,199\n" +
            "Metropolitan Line,Aldgate,8b004c,881,236\n" +
            "Hammersmith & City Line,Paddington,f5a6b3,242,212\n" +
            "Hammersmith & City Line,Edgware Road,f5a6b3,292,181\n" +
            "Hammersmith & City Line,Baker Street,f5a6b3,361,150\n" +
            "Hammersmith & City Line,Great Portland Street,f5a6b3,445,138\n" +
            "Hammersmith & City Line,Euston Square,f5a6b3,496,117\n" +
            "Hammersmith & City Line,King's Cross St. Pacras,f5a6b3,572,67\n" +
            "Hammersmith & City Line,Farringdon,f5a6b3,691,174\n" +
            "Hammersmith & City Line,Barbican,f5a6b3,738,173\n" +
            "Hammersmith & City Line,Moorgate,f5a6b3,797,192\n" +
            "Hammersmith & City Line,Liverpool Street,f5a6b3,837,199\n" +
            "Hammersmith & City Line,Aldgate East,f5a6b3,899,224\n" +
            "Jubilee Line,Baker Street,767b7f,361,150\n" +
            "Jubilee Line,Bond Street,767b7f,410,236\n" +
            "Jubilee Line,Green Park,767b7f,452,313\n" +
            "Jubilee Line,Westminster,767b7f,563,371\n" +
            "Jubilee Line,Waterloo,767b7f,633,344\n" +
            "Jubilee Line,Southwark,767b7f,693,341\n" +
            "Jubilee Line,London Bridge,767b7f,811,328\n" +
            "Northern Line,Waterloo,000000,633,344\n" +
            "Northern Line,Embankment,000000,583,306\n" +
            "Northern Line,Charing Cross,000000,583,305\n" +
            "Northern Line,Leicester Square,000000,546,266\n" +
            "Northern Line,Tottenham Court Road,000000,527,213\n" +
            "Northern Line,Goodge Street,000000,505,172\n" +
            "Northern Line,Warren Street,000000,480,132\n" +
            "Northern Line,Euston,000000,509,94\n" +
            "Northern Line,King's Cross St. Pancras,000000,572,67\n" +
            "Northern Line,Angel,000000,685,53\n" +
            "Northern Line,Old Street,000000,805,112\n" +
            "Northern Line,Liverpool Street,000000,837,199\n" +
            "Northern Line,Bank,000000,797,245\n" +
            "Northern Line,London Bridge,000000,811,328\n" +
            "Northern Line,Borough,000000,760,372\n" +
            "Northern Line,Elephant & Castle,000000,723,438\n" +
            "Waterloo & City Line,Waterloo,89cbc1,633,344\n" +
            "Waterloo & City Line,Bank,89cbc1,797,245\n";

    public void search(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            TableColumn<Route, String> routeColumn = new TableColumn<>("Route");
            routeColumn.setCellValueFactory(new PropertyValueFactory<>("routeString"));
            routeColumn.setPrefWidth(400);

            routesTableView.getColumns().add(routeColumn);
    }

}
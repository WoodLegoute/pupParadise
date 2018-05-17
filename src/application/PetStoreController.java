package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.sql.*;

public class PetStoreController {

    @FXML
    private AnchorPane displayPane;

    @FXML
    private JFXTextField pupName;

    @FXML
    private TableView<?> display;

    @FXML
    private JFXTextField pupAge;

    @FXML
    private JFXTextField pupID;

    @FXML
    private JFXTextField pupBreed;

    @FXML
    private JFXButton addPup;

    @FXML
    void btnAdd(ActionEvent event) throws SQLException {
       // Connecting.ConnDatabase();
        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        String jdbcUrl = "jdbc:mysql://localhost/pupparadise";
        Connection con = DriverManager.getConnection(jdbcUrl, "root", "");
        System.out.println("Connected!");
        //con.close();

        String queryString = "select * from pups";
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(queryString);
        while ( rset.next()) {
            System.out.println(rset.getString(1)
                    +" "+rset.getString(2)
                    +" "+rset.getString(3)
                    +" "+rset.getString(4));
        }
        stmt.executeUpdate("INSERT INTO pups "
                +"VALUES ('"+pupID.getText()+"', '"+pupName.getText()+"', '"+pupBreed.getText()+"', '"+pupAge.getText()+"')");

    }


    }



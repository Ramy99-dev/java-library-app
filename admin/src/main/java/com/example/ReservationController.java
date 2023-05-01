package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.DAO.ReservationDao;
import com.example.Models.Reservation;



import com.pdfjet.A3;
import com.pdfjet.A4;
import com.pdfjet.Cell;
import com.pdfjet.CoreFont;
import com.pdfjet.Font;
import com.pdfjet.PDF;
import com.pdfjet.Page;
import com.pdfjet.Table;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ReservationController {

    @FXML
    private TableView<Reservation> reservations;


    @FXML
    private TableColumn<Reservation, Long> idBookCol;

    @FXML
    private TableColumn<Reservation, String> idClientCol;

    @FXML
    private TableColumn<Reservation, Long> idCol;


    @FXML
    private TableColumn<Reservation, Date> startDateCol;

    @FXML
    private TableColumn<Reservation, Date> endDateCol;

    @FXML
    public void initialize()
    { 
        ReservationDao reservationDao = new ReservationDao();

        idBookCol.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        idClientCol.setCellValueFactory(new PropertyValueFactory<>("clientFullName"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("idReservation"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        ObservableList<Reservation> reservationsList = FXCollections.observableArrayList();
      
        ResultSet rs = reservationDao.getReservations();

        try {
            while (rs.next()) {
 
                Reservation reservation = new Reservation((long)(rs.getInt("id")),rs.getString("firstname")+" "+rs.getString("lastname"),(long)(rs.getInt("idBook")),rs.getDate("start_date"),rs.getDate("end_date"));
                reservationsList.add(reservation);

            }
            reservations.getItems().addAll(reservationsList);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void print(MouseEvent event) throws Exception {

          File reservationsPDF = new File("/home/rami/Desktop/projects/JavaFX/demo/admin/reservations/reservation.pdf");
          FileOutputStream fos = new FileOutputStream(reservationsPDF);
          PDF pdf = new PDF(fos);
          Page page = new Page(pdf,A4.PORTRAIT);
          
          Font f1 = new Font(pdf , CoreFont.HELVETICA_BOLD);
          Font f2 = new Font(pdf , CoreFont.TIMES_ROMAN);
         
          Table table = new Table();
          List<List<Cell>> tableData  = new ArrayList<>();
          
          List<Cell> tableRow = new ArrayList<>();
        
          Cell cell = new Cell(f1 , idCol.getText());
          tableRow.add(cell);
          
          
          cell = new Cell(f1 , idClientCol.getText());
          tableRow.add(cell);
          
          cell = new Cell(f1 , idBookCol.getText());
          tableRow.add(cell);

          cell = new Cell(f1 , startDateCol.getText());
          tableRow.add(cell);

          cell = new Cell(f1 , endDateCol.getText());
          tableRow.add(cell);
          
          tableData.add(tableRow);
          
          List<Reservation> items = reservations.getItems();
          for (Reservation reservation : items) {
			Cell id = new Cell(f2,reservation.getIdReservation()+"");
			Cell book = new Cell(f2,reservation.getIdBook()+"");
			Cell client = new Cell(f2,reservation.getClientFullName()+"");
			Cell startDate = new Cell(f2,reservation.getStartDate().toString());
            Cell endDate = new Cell(f2,reservation.getEndDate().toString());
			
			tableRow = new ArrayList<Cell>();
			tableRow.add(id);
			tableRow.add(client);
			tableRow.add(book);
			tableRow.add(startDate);
            tableRow.add(endDate);
			
			tableData.add(tableRow);
		  }
          table.setData(tableData);
          table.setPosition(70f, 60f);
          table.setColumnWidth(0, 100f);
          table.setColumnWidth(1, 100f);
          table.setColumnWidth(2, 100f);
          table.setColumnWidth(3, 100f);
          table.setColumnWidth(4, 100f);
          
          while(true)
          {
        	  table.drawOn(page);
        	  if(!table.hasMoreData())
        	  {
        		  table.resetRenderedPagesCount();
        		  break;
        	  }
        	  page = new Page(pdf,A3.PORTRAIT);
          }
          pdf.flush();
          fos.close();
          try {
            String[] command = {"xdg-open", reservationsPDF.getAbsolutePath()};
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}

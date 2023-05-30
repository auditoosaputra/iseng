package pkg123210141_responsi;

import java.sql.*;
import javax.swing.*;

public class ModelPerpustakaan extends Connector{
    private String buku;

    public ModelPerpustakaan(String buku) {
        this.buku = buku;
    }
    
    public ModelPerpustakaan() {
    }
    
    public int getTotalBuku(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `dataperpus`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
    
    public String[][] readAllBuku(){
        String data[][] = new String[getTotalBuku()][7];
        try {
            int indexData = 0;  
            String query = "SELECT * FROM `dataperpus`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[indexData][0] = resultSet.getString("id");
                data[indexData][1] = resultSet.getString("judul");
                data[indexData][2] = resultSet.getString("genre");
                data[indexData][3] = resultSet.getString("penulis");
                data[indexData][4] = resultSet.getString("penerbit");
                data[indexData][5] = resultSet.getString("lokasi");
                data[indexData][6] = resultSet.getString("stock");
                indexData++;
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }
    
    public boolean checkBuku(String id){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `dataperpus` WHERE `id`='" + id + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            
            if(totalData>0){
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }
    
    public void insertBuku(String judul, String genre, String penulis, String penerbit, String lokasi, String stock){
        try {
//            System.out.println("berhasil");
            String query = "INSERT INTO `dataperpus` (`id`, `judul`, `genre`, `penulis`, `penerbit`, `lokasi`, `stock`) "
                    + "VALUES"
                    + "(NULL," + "'" + judul + "'," + "'" + genre + "'," + "'" + penulis + "',"+ "'" + penerbit + "'," + "'" + lokasi + "'," + "'" + stock + "')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            JOptionPane.showMessageDialog(null, "Input Success");
            
        } catch (Exception e) { 
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Username Telah Digunakan","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteBuku(String id){
        if(!checkBuku(id)){
            JOptionPane.showMessageDialog(null, "Buku tidak dapat ditemukan");
            return;
        }
        
        try {
            String query = "DELETE FROM `dataperpus` WHERE `id`='" + id + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            
            JOptionPane.showMessageDialog(null, "Delete Success");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
    
    public void updateBuku(String id, String judul, String genre, String penulis, String penerbit, String lokasi, String stock, String marker){
//        if(!checkBuku(judul)){
//            JOptionPane.showMessageDialog(null, "Buku tidak dapat ditemukan");
//            return;
//        }
         
        try {
            String query = "UPDATE `dataperpus` "
                    + "SET "
                    + "`id`='" + id + "', "
                    + "`judul`='" + judul + "', "
                    + "`genre`='" + genre + "', "
                    + "`penulis`='" + penulis + "' "
                    + "`penerbit`='" + penerbit + "' "
                    + "`lokasi`='" + lokasi + "' "
                    + "`stock`='" + stock + "' "
                    + "WHERE `id`='" + id + "'";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
        }
    }

    void updateBuku(String judul, String genre, String penulis, String penerbit, String lokasi, String stock, String marker) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

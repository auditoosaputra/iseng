/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123210141_responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ControllerPerpustakaan {
    ViewPerpustakaan view;
    ModelPerpustakaan model;
    private String data[][];
    private String marker;

    public ControllerPerpustakaan(ViewPerpustakaan view, ModelPerpustakaan model) {
        this.view = view;
        this.model = model;
        data = model.readAllBuku();
        
        view.getTabelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getTabel().setModel(new DefaultTableModel(data, new String[]{
                    "ID", "JUDUL", "GENRE", "PENULIS", "PENERBIT", "LOKASI", "STOCK"
                }) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false, false, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            }
        });
        
        view.getTabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = view.getTabel().getSelectedRow();
                String id = view.getTabel().getValueAt(row, 0).toString();
                String judul = view.getTabel().getValueAt(row, 1).toString();
                String genre = view.getTabel().getValueAt(row, 2).toString();
                String penulis = view.getTabel().getValueAt(row, 3).toString();
                String penerbit = view.getTabel().getValueAt(row, 4).toString();
                String lokasi = view.getTabel().getValueAt(row, 5).toString();
                String stock = view.getTabel().getValueAt(row, 6).toString();
                marker = judul;
                
                view.setIdTxt(id);
                view.setJudulTxt(judul);
                view.setGenreTxt(genre);
                view.setPenulisTxt(penulis);
                view.setPenerbitTxt(penerbit);
                view.setLokasiTxt(lokasi);
                view.setStockTxt(stock);
            }
        });
        
        view.getAddBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = view.getJudulTxt();
                String genre = view.getGenreTxt();
                String penulis = view.getPenulisTxt();
                String penerbit = view.getPenerbitTxt();
                String lokasi = view.getLokasiTxt();
                String stock = view.getStockTxt();
                
                System.out.println("aneh gabisa diadd:(");
                try{
//                if(!judul.equals("") && !genre.equals("") && !penulis.equals("") && !penerbit.equals("")&& !lokasi.equals("") && !stock.equals("")){
                    view.insertBuku(judul, genre, penulis, penerbit, lokasi, stock);
                    String dataUser[][] = view.readAllBuku();
                    view.getTabel().setModel(new DefaultTableModel(dataUser, new String[]{
                        "ID", "JUDUL", "GENRE", "PENULIS", "PENERBIT", "LOKASI", "STOCK"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false, false, true, true, true
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });
//                } else JOptionPane.showMessageDialog(view, "Mohon isi semua terlebih dahulu","Eror",JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) { 
                    System.out.println(ex.getMessage());}
                    

            }
        });
        
        view.getHapusBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = view.getIdTxt();

//                if (view.getJudulTxt().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Cannot be empty");
//                } else {
                System.out.println("aneh kak gabisa ");
                try{
                    view.deleteBuku(id);
                    String dataUser[][] = model.readAllBuku();
                    view.getTabel().setModel(new DefaultTableModel(dataUser, new String[]{
                        "ID", "JUDUL", "GENRE", "PENULIS", "PENERBIT", "LOKASI", "STOCK"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false, false, true, true, true
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });
//                }
            }catch (Exception ef) { 
            System.out.println(ef.getMessage());}}
        });
        
        view.getEditBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = view.getJudulTxt();
                String genre = view.getGenreTxt();
                String penulis = view.getPenulisTxt();
                String penerbit = view.getPenerbitTxt();
                String lokasi = view.getLokasiTxt();
                String stock = view.getStockTxt();
               
//                if(!judul.equals("") && !genre.equals("") && !penulis.equals("") && !penerbit.equals("")&& !lokasi.equals("") && !stock.equals("")){
//                    JOptionPane.showMessageDialog(null, "Cannot be empty");
//                } else {
                System.out.println("aneh kak nggk bisa diedit");
                try{
                    model.updateBuku(judul, genre, penulis, penerbit, lokasi, stock, marker);
                    String dataUser[][] = view.readAllBuku();
                    view.getTabel().setModel(new DefaultTableModel(dataUser, new String[]{
                        "ID", "JUDUL", "GENRE", "PENULIS", "PENERBIT", "LOKASI", "STOCK"
                    }) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false, false, true, true, true
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    });
//                }
                }catch (Exception ep) { 
            System.out.println(ep.getMessage());}
            
            } 

            
        });
    }
    
    
}

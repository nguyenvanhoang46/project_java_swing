/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.Product;
import com.mycompany.projcetjavaswing.repository.ProductRepository;
import com.mycompany.projcetjavaswing.view.ProductView;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ProductController {
    DefaultTableModel tabbleModel;
    
    private ProductView view;
    List<Product> productList = new ArrayList<>();
    
    public ProductController(ProductView productview) {
        this.view = productview;
        this.view.setVisible(true);
        setUpListener();
    }
    
    public void setUpListener() {
        showProduct();
        insert();
        delete();
        search();
        reset();
        update();
    }
    
    private void showProduct() {
        productList = ProductRepository.findAll();
        tabbleModel = (DefaultTableModel) this.view.getTableProduct().getModel();
        tabbleModel.setRowCount(0);
        
        productList.forEach(p -> {
            tabbleModel.addRow(new Object[] {
                p.getId(),
                p.getNameproduct(),
                p.getCategory_id(),
                p.getPrice(),
                p.getQuantity(),
                p.getUnit()
            });
        });
    }
    
    private void showCategory() {
        
    }
    
    private void insert() {
        view.getBtnSave().addActionListener((ActionEvent e) -> {
            
            if(view.getNameproduct().getText().isEmpty() || view.getPriceproduct().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Full information not enter");
                return;
            }
            String nameproduct = view.getNameproduct().getText();
            int price = Integer.parseInt(view.getPriceproduct().getText());
            int quantity = Integer.parseInt(view.getQuantytiproduct().getText());
            String unit = view.getUnitproduct().getText();
            
            Product pt = new Product(nameproduct, price, quantity, unit);
            ProductRepository.insert(pt);
            showProduct();
        });
    }
    
    private void delete() {
        view.getBtnDelete().addActionListener((ActionEvent e) -> {
            productList = ProductRepository.findAll();
            int index = view.getTableProduct().getSelectedRow();
            if(index >= 0 ) {
                Product pt = productList.get(index);
                int option = JOptionPane.showConfirmDialog(null, "Do you want to Delete this item");
                if(option == JOptionPane.YES_OPTION) {
                    ProductRepository.delete(pt.getId());
                    showProduct();
                }
            }else {
                System.out.println("x");
        }
        });
    }
    
    private void search() {
        view.getBtnFind().addActionListener((ActionEvent e) -> {
            String input = JOptionPane.showInputDialog(this, "Enter full name to search");
            if(input != null && input.length() > 0) {
                productList = ProductRepository.searchName(input);
                tabbleModel.setRowCount(0);
                productList.forEach(product -> {
                   tabbleModel.addRow(new Object[]{tabbleModel.getRowCount() + 1, product.getNameproduct(), product.getCategory_id(), product.getPrice(), product.getQuantity(), product.getUnit(), product.getImage()});
                });
            }else {
                showProduct();
            }
        });
    }
    
    
    private void update(){
        view.getBtnUpdate().addActionListener((ActionEvent e) -> {
        int index = view.getTableProduct().getSelectedRow();
        
        
        
        });
    }
    
    
    private void reset() {
        view.getBtnReset().addActionListener((ActionEvent e) -> {
            view.getNameproduct().setText("");
            view.getPriceproduct().setText("");
            view.getQuantytiproduct().setText("");
            view.getUnitproduct().setText("");
              
        });
    }
    
    
}

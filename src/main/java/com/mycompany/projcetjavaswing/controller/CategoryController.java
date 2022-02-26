/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.model.Category;
import com.mycompany.projcetjavaswing.repository.CategoryRepository;
import com.mycompany.projcetjavaswing.view.CategoryView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CategoryController {
    DefaultTableModel tabbleModel;
    
    private CategoryView view;
    List<Category> categoryList = new ArrayList<>();
    
    public CategoryController(CategoryView view) {
        this.view = view;
        this.view.setVisible(true);
        setUpListener();
        
    }
    
    public void setUpListener() {
        showCategory();
    }
    
    private void showCategory() {
        categoryList = CategoryRepository.findAll();
        tabbleModel = (DefaultTableModel) this.view.getTableCategory().getModel();
        tabbleModel.setRowCount(0);
        
        categoryList.forEach(c -> {
            tabbleModel.addRow(new Object[] {
                c.getId(),
                c.getName()
            });
        });
    }
    
}

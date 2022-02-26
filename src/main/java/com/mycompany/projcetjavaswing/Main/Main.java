/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.Main;

import com.mycompany.projcetjavaswing.controller.CategoryController;
import com.mycompany.projcetjavaswing.controller.LoginController;
import com.mycompany.projcetjavaswing.controller.ProductController;
import com.mycompany.projcetjavaswing.view.CategoryView;
import com.mycompany.projcetjavaswing.view.LoginView;
import com.mycompany.projcetjavaswing.view.ProductView;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
//        new LoginController(new LoginView());
          new ProductController(new ProductView());
//          new CategoryController(new CategoryView());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projcetjavaswing.controller;

import com.mycompany.projcetjavaswing.view.LoginView;
import java.awt.event.ActionEvent;

/**
 *
 * @author Admin
 */
public class LoginController {
    
    
    private LoginView view;
    
    
    public LoginController(LoginView view) {
        this.view = view;
        this.view.setVisible(true);
        event();
    }
    
    public void event() {
        login();
    }
    
    
    public void login() {
        view.getBtnLogin().addActionListener((ActionEvent e) -> {
            String username = view.getUsername().getText();
            String password = new String(view.getPassword().getPassword());
            
            
            System.out.println(username +  " " + password);
        });
    }
}

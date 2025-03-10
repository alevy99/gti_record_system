/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ie.gti.recordsystem;

import ie.gti.recordsystem.frames.LoginFrame;

/**
 *
 * @author Andrei
 */
public class GtiRecord {
    
    private static LoginFrame loginFrame;
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}

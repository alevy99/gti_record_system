/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ie.gti.recordsystem;

import ie.gti.recordsystem.config.ApplicationConfig;
import ie.gti.recordsystem.ui.frame.LoginFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Andrei
 */
public class GtiRecord {

//    @Autowired
    private static LoginFrame loginFrame;

    //    public static AnnotationConfigApplicationContext getContext() {
//        return context;
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ApplicationConfig.class
        );

        System.out.println("Hello World!");
        loginFrame = context.getBean(LoginFrame.class);
        
//        loginFrame = new LoginFrame(context);//context.getBean(LoginFrame.class);
        loginFrame.setVisible(true);
    }
}

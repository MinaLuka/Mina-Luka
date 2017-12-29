/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class Ch8Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//    
        
        JFrame jf=new JFrame();
        jf.setSize(700, 800);
      
        jf.setTitle("luka games");
        
        MovingBalls mb=new MovingBalls();
        MovingBalls m=new MovingBalls();
        mb.Balls.add(new Ball());
   
        mb.Balls.add(new Ball(100, 120, 20, Color.PINK));
        mb.Balls.add(new Ball(120, 130, 50, Color.PINK));
        mb.Balls.add(new Ball(130, 140, 22, Color.PINK));
        mb.Balls.add(new Ball(100,100,29,Color.darkGray));
        mb.Balls.add(new Ball(170,150,38,Color.darkGray));
        mb.Balls.add(new Ball(160,160,15,Color.red));
        mb.Balls.add(new Ball(180,180,10,Color.CYAN));
        mb.Balls.add(new Ball(200, 200, 25, Color.yellow));
        
        
        jf.add(mb,BorderLayout.CENTER);
        jf.add(m,BorderLayout.CENTER);
        mb.setFocusable(true);
  
        Thread t2=new Thread(mb);
            
    
        t2.start();
        
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        
        
    }
    
}

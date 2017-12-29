/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class MovingBalls extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<Ball>(5);
   public Tank BlueTank=new Tank("D:\\Beso_D.png");
    public Tank BlueTannk=new Tank("D:\\Beso_D.png");
    public int x=-1,y=0;
   JTextField frist=new JTextField("Frist Player score : "+x);
   JTextField second=new JTextField("Second Player score : "+y);
    public MovingBalls()
    {
        
        setSize(700,800);
        setBackground(Color.red);
        this.add(frist);
        this.add(second);
       
        BlueTank.pos.x=220;
        BlueTank.pos.y=340;
        BlueTannk.pos.x=320;
        BlueTannk.pos.y=340;
        
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener,ActionListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_DOWN) {
                BlueTank.upmover();
            }
             if (e.getKeyCode()==KeyEvent.VK_UP) {
                BlueTank.downmover();
            }
                if (e.getKeyCode()==KeyEvent.VK_S) {
                BlueTannk.upmover();
            }
             if (e.getKeyCode()==KeyEvent.VK_W) {
                BlueTannk.downmover();
            }
            
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
               
                
            }
              if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                BlueTannk.mover();
               
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                //repaint();
            }
              if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                BlueTannk.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_F)
            {
                
                BlueTannk.fireBullet();
            }
              if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
              
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    public void  paintComponent (Graphics g)
    {
        g.clearRect(0, 0, 700, 800);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
         BufferedImage imgtannk = ImageIO.read(new File(BlueTannk.ImagePath));
        BufferedImage imngrocket = ImageIO.read(new File(BlueTannk.Rocket.imgPath));
        g.drawImage(imgtank, BlueTannk.pos.x, BlueTannk.pos.y,null);
        g.drawImage(imgrocket, BlueTannk.Rocket.pos.x, BlueTannk.Rocket.pos.y,null);
        }
       
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
                x++;
                  Object b=frist;
               frist.setText("Frist Palyer score: "+x);
            
                
                break;
                
            }
             if (BlueTannk.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
                y++;
              
                  Object b=frist;
               second.setText("second Palyer score: "+y);
                break;
                
            }
             
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}

package view;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyJpanel extends JPanel {  
      
    String url="229.PNG";  
    public MyJpanel(String url){  
        super();  
        this.url = url;  
    }  
    public MyJpanel(){  
        super();  
    }  
    public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
        super.paintComponent(g);  
  
        InputStream in;  
        try {  
            in = new FileInputStream(url);  
            // »­±³¾°Í¼Æ¬  
            // Image image =  
            // Toolkit.getDefaultToolkit().getImage(getClass().getResource("sk.png"));  
            BufferedImage image = ImageIO.read(in);  
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(),  
                    this);  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  }
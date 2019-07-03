package view;



import java.awt.Dimension;  
import java.awt.Graphics;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.awt.image.BufferedImage;  
import java.awt.image.PixelGrabber;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
  
import javax.imageio.ImageIO;  
import javax.swing.JButton;  
  
public class MyButton extends JButton {  
    private BufferedImage image_over; // ����ڰ�ť�ϵ�ͼƬ  
    private BufferedImage image_off; // ��겻�ڰ�ť�ϵ�ͼƬ  
    private BufferedImage image_pressed; // ��갴�°�ťʱ��ͼƬ  
    private int buttonWidth; // ��  
    private int buttonHeight; // ��  
    private int[] pixels; // ����ͼƬ���ݵ����飬���ڼ���contains  
    private boolean mouseOn;  
    private boolean mousePressed;  
  
    /** 
     * @param img_off 
     *            ��겻�ڰ�ť�ϵ�ͼƬ 
     * @param img_over 
     *            ����ڰ�ť�ϵ�ͼƬ 
     * @param img_pressed 
     *            ��갴�°�ťʱ��ͼƬ 
     */  
    public MyButton(String img_off, String img_over, String img_pressed) {  
        mouseOn = false;  
        mousePressed = false;  
        // ����ͼƬ  
        try {  
            image_over = ImageIO.read(new FileInputStream(img_over));  
            image_off = ImageIO.read(new FileInputStream(img_off));  
            image_pressed = ImageIO.read(new FileInputStream(img_pressed));  
        } catch (FileNotFoundException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } catch (IOException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
  
        buttonWidth = image_off.getWidth();  
        buttonHeight = image_off.getHeight();  
  
        // ��ȡͼƬ����  
        pixels = new int[buttonWidth * buttonHeight];  
        // ץȡ��������  
        PixelGrabber pg = new PixelGrabber(image_off, 0, 0, buttonWidth,  
                buttonHeight, pixels, 0, buttonWidth);  
        try {  
            pg.grabPixels();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        // �������ã�������в�Ӱ��  
        this.setOpaque(false);  
        this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));  
        this.addMouseListener(new MouseHandler());  
    }  
  
    // ��ȡͼƬ�ļ�  
    public BufferedImage loadImage(String filename) {  
        File file = new File(filename);  
  
        if (!file.exists())  
            return null;  
  
        try {  
            return ImageIO.read(file);  
        } catch (IOException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
    // ���Ǵ˷��������Զ����ͼƬ  
    @Override  
    public void paintComponent(Graphics g) {  
        g.drawImage(image_off, 0, 0, this);  
        if (mouseOn)  
            g.drawImage(image_over, 0, 0, this);  
        else if (mousePressed)  
            g.drawImage(image_pressed, 0, 0, this);  
    }  
  
    // ���Ǵ˷��������Զ���ı߿�  
    @Override  
    public void paintBorder(Graphics g) {  
        // ��Ҫ�߿�  
    }  
  
    @Override  
    public void setSize(Dimension d) {  
        // TODO Auto-generated method stub  
        super.setSize(d);  
    }  
  
    public boolean contains(int x, int y) {  
        // ���ж��Ļ���Խ�磬�����֮��Ҳ�ἤ���������  
        if (!super.contains(x, y))  
            return false;  
  
        int alpha = (pixels[(buttonWidth * y + x)] >> 24) & 0xff;  
  
        repaint();  
        if (alpha == 0) {  
            return false;  
        } else {  
            return true;  
        }  
    }  
  
    // ������롢�뿪ͼƬ��Χ����Ϣ  
    class MouseHandler extends MouseAdapter {  
        public void mouseExited(MouseEvent e) {  
            mouseOn = false;  
            repaint();  
        }  
  
        public void mouseEntered(MouseEvent e) {  
            mouseOn = true;  
            repaint();  
        }  
  
        public void mousePressed(MouseEvent e) {  
            mouseOn = false;  
            mousePressed = true;  
            repaint();  
        }  
  
        public void mouseReleased(MouseEvent e) {  
            // ��ֹ�ڰ�ť֮��ĵط��ɿ����  
            if (contains(e.getX(), e.getY()))  
                mouseOn = true;  
            else  
                mouseOn = false;  
  
            mousePressed = false;  
            repaint();  
        }  
    }  
}  
package Pruebas3;

import java.awt.Color;
import java.awt.Graphics2D;

public class BresenhamTool extends Tool{
	
	public BresenhamTool (int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	
	public void draw(Graphics2D g) {
		g.fillRect(x, y, width, height);
	}
	
	/*
	
	import java.applet.*;
    import java.awt.*;
    import java.awt.image.*;
    
    public class bresenham'salgorithm extends Applet
    {  
        BufferedImage image =  new BufferedImage(100,150,BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster  =  image.getRaster();  
        
        int x0 = 60;
        int x1 = 50;
        int y0 = 10;
        int y1 = 20;
      
              
      
        int Dx = x0 - x1;  
        int Dy = y0 - y1;  
              
        int fraction,xstep,ystep;  
      
        public void paint(Graphics g)  
        {  
            if(Dy < 0)  
            {  
                Dy = -Dy;  
                ystep = -1;  
            }  
            else  
            {  
                ystep = 1;  
            }  
            if(Dx < 0)  
            {  
                Dx = - Dx;  
                xstep = -1;  
            }  
            else  
            {  
                xstep = 1;  
            }  
              
            Dy <<= 1;   
            Dx <<= 1;  
          
            int array[] = {250,0,0,250};  
            raster.setPixel(x0,y0,array);  
            if(Dx > Dy)  
            {  
                fraction = Dy - (Dx >> 1);  
            }   
            while(x0 != x1)  
            {  
                if(fraction >= 0)  
                {  
                    y0 += ystep;  
                    fraction -= Dx;  
                    x0 += xstep;  
                    fraction += Dy;  
                    raster.setPixel(x0,y0,array);  
                }  
                else  
                {  
                    fraction = Dx-(Dy>>1);  
                    while(y0 != y1)  
                    {  
                        if(fraction >= 0)  
                        {  
                            x0 += xstep;  
                            fraction-=Dy;  
                        }  
                        y0 += ystep;  
                        fraction += Dx;  
                        raster.setPixel(x0,y0,array);  
                    }  
                }  
                g.drawImage(image,x1,y1,null);  
            }  
        }  
    }

	 */

}

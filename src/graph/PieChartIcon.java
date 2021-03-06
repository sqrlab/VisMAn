package graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class PieChartIcon implements Icon {

	private double percentRed;
	private double percentYellow;
	private double percentGreen;
	
	private static final int maxSize = 60;
	
	private int sideLength;
	
	public PieChartIcon(double _percentRed, double _percentYellow, double _percentGreen, double averageKilled)
	{
		this.percentRed = _percentRed;
		this.percentYellow = _percentYellow;
		this.percentGreen = _percentGreen;
		this.sideLength = maxSize;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int _x, int _y) {
		
		int x = _x;
		int y = _y - 20; //This vertical translation of 20 pixels up is used to prevent the labels from overlapping the vertex.
		
		Graphics2D g2d = (Graphics2D) g.create();
			
		g2d.setColor(Color.red);
		g2d.fill(new Rectangle2D.Double(x,y+(sideLength-(sideLength*percentRed)),sideLength,sideLength*percentRed));
		
		g2d.setColor(Color.yellow);
		g2d.fill(new Rectangle2D.Double(x,y+(sideLength*percentGreen),sideLength,sideLength*percentYellow));
		
		g2d.setColor(Color.green);
		g2d.fill(new Rectangle2D.Double(x,y,sideLength,sideLength*percentGreen));
		
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(2));
		g2d.draw(new Rectangle2D.Double(x,y,sideLength,sideLength));
		
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return sideLength;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return sideLength;
	}

}

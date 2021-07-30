package guimodule;

import processing.core.PApplet;
import processing.core.PImage;

public class SunColorPerHour extends PApplet {
	
	private String URL="https://media.cntraveler.com/photos/58ac9e5fa5afa42363c01c4b/master/w_4352,h_3264,c_limit/palm-beach-arubaGettyImages-474428679.jpg";
	private PImage backgroundImg;
	
	public void setup(){
		size(400,400);
		backgroundImg= loadImage(URL);
		backgroundImg.resize(0,height);
		image(backgroundImg,0,0);
	}
	public void draw() {
		
		int color[]=sunColor(hour());
		fill(color[0],color[1],color[2]);
		ellipse(width/4,height/5,width/5,height/5);
		
	}
	public int[] sunColor(double hr) {
		
		int rgb[]=new int[3];
		if (hr>=12) {
		double diff=Math.abs(24-hr);
		double ratio=diff/12;
		rgb[0]=(int)(255*ratio);
		rgb[1]=(int)(255*ratio);
		rgb[2]=0;
		}
		else if(hr<12){
			double ratio=hr/12;
			rgb[0]=(int)(255*ratio);
			rgb[1]=(int)(255*ratio);
			rgb[2]=0;
		}	
		return rgb;	
	}

}

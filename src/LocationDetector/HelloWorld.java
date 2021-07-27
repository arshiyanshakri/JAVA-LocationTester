package module1;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.EsriProvider;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.providers.Yahoo;
import de.fhpotsdam.unfolding.utils.MapUtils;

/** HelloWorld
  * An application detecting different map locations and drawing them side by side
  * @AShak
  * Date: July 27, 2021
  * */
public class HelloWorld extends PApplet
{

	private static final long serialVersionUID = 1L;

	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	//If working OFFLINE: Change the value of this variable to true
	private static final boolean offline = false;
	
	//Map of Stockholm,Sweden
	UnfoldingMap map1;
	
	//Map of Kuala Lumpur,Malaysia 
	UnfoldingMap map2;
	
        //Map of Choice
	//UnfoldingMap map3;

	public void setup() {
		size(800, 600, P2D);  // Sets up the Applet window to be 800x600
		                 

		// Sets the background color for the Applet.  
		this.background(100,100,100);
		
		//Map provider
		AbstractMapProvider provider = new Google.GoogleTerrainProvider(); 
                //EsriProvider.WorldStreetMap();
                //Google.GoogleSimplified2Provider();

		// Sets zoom level
		int zoomLevel = 12;
		
		if (offline) {  
			provider = new MBTilesMapProvider(mbTilesString);
			zoomLevel = 3;
		}
		
                //For map 1
		map1 = new UnfoldingMap(this, 50, 50, 350, 500, provider);

	        map1.zoomAndPanTo(zoomLevel, new Location(59.32f, 18.05f));
		
		MapUtils.createDefaultEventDispatcher(this, map1);
		
		//For map 2
		map2 = new UnfoldingMap(this, 420, 50 , 350, 500, provider);

		map2.zoomAndPanTo(zoomLevel, new Location(3.14f, 101.67f));

		MapUtils.createDefaultEventDispatcher(this, map2);
		
                //For map 3(of choice)
		//map3 = new UnfoldingMap(this, x, y, width, height, MapProvider);

	        //map3.zoomAndPanTo(zoomLevel, new Location(latitude, longitude));

	       //MapUtils.createDefaultEventDispatcher(this, map3);
}

	public void draw() {
		
		map1.draw();
		map2.draw();
               //map3.draw();
	}	
}

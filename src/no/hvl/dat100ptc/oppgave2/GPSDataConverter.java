package no.hvl.dat100ptc.oppgave2;

import static java.lang.Integer.*;
import static java.lang.Double.*;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
	// skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26

	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	// toSeconds metoden trekker ut tidsinformasjonen i
	// et gpspunkt og konverterer det til sekunder.
	public static int toSeconds(String timestr) {

		String hrTxt = timestr.substring(11, 13);
		String minTxt = timestr.substring(14, 16);
		String secTxt = timestr.substring(17, 19);
		int hr = parseInt(hrTxt);
		int min = parseInt(minTxt);
		int sec = parseInt(secTxt);
		int secs = (hr * 60 * 60) + (min * 60) + sec;
		return secs;

	}

	// convert metoden gjør om en rekke string variabler til int og double verdier som den bruker for å 
	// returnere et nytt gpspunkt.
	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;
		int time = toSeconds(timeStr);
		double latitude = parseDouble(latitudeStr);
		double longitude = parseDouble(longitudeStr);
		double elevation = parseDouble(elevationStr);
		gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		return gpspoint;
	}

}

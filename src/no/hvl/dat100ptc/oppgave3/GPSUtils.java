package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;
import static java.lang.String.*;
import java.time.Duration.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;

public class GPSUtils {

	
	//findMax metoden finner det høgeste tallet i en tabell med flyttall. 
	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}
	//findMax metoden finner det laveste tallet i en tabell med flyttall. 
	public static double findMin(double[] da) {

		double min;

		min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;

	}
	//getLatitudes metoden returnerer en tabell med alle breddegradene fra alle gpspunktene i tabellen gpspoints.
	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];
		for (int i = 0; i < latitudes.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
	}
	//getLatitudes metoden returnerer en tabell med alle lengdegradene fra alle gpspunktene i tabellen gpspoints.
	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];
		for (int i = 0; i < longitudes.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;
	}

	private static int R = 6371000; // jordens radius

	// metoden distance finner avstanden mellom to gpspunkt ved hjelp av formelen 
	// som står i oppgaveteksten i oppgave 3
	
	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double Latitude1 = gpspoint1.getLatitude() * (Math.PI / 180);
		double Latitude2 = gpspoint2.getLatitude() * (Math.PI / 180);
		double diffLatitudeR = Latitude2 - Latitude1;
		double Longitude1 = gpspoint1.getLongitude() * (Math.PI / 180);
		double Longitude2 = gpspoint2.getLongitude() * (Math.PI / 180);
		double diffLongitudeR = Longitude2 - Longitude1;
		double a = ((Math.sin(diffLatitudeR / 2)) * (Math.sin(diffLatitudeR / 2))) + Math.cos(Latitude1)
				* Math.cos(Latitude2) * ((Math.sin(diffLongitudeR / 2)) * (Math.sin(diffLongitudeR / 2)));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		return d;
	}

	// metoden speed finner farten mellom to gpspunkt. 
	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double sec1 = gpspoint1.getTime();
		double sec2 = gpspoint2.getTime();
		double secs = sec2 - sec1;
		double distance = distance(gpspoint1, gpspoint2);
		double speed = (distance / secs) * 3.6;
		return speed;

	}

	// formatTime metoden gjør om sekunder til hh, mm og ss og formaterer det slik. hh:mm:ss.
	public static String formatTime(int secs) {

		String timestr;
		int hours = secs / 3600;
		int minutes = (secs % 3600) / 60;
		int seconds = secs % 60;
		String tid = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		timestr = String.format("%10s", tid);
		return timestr;
	}

	private static int TEXTWIDTH = 10;

	
	// metoden formatdouble kan man bruke på desimaltall og gjør at 
	// alt etter komma bare er 2 siffer og bytter "," om til ".". Den returnerer resultatet inn i en streng og 
	// fyller på med mellomrom som gjør lengden på strengen til 10.
	public static String formatDouble(double d) {
		String str;
		  
	  	str = String.format("%10.2f", d);
	  	str.replaceAll(",", ".");
	  
	  	return str;
	}
}

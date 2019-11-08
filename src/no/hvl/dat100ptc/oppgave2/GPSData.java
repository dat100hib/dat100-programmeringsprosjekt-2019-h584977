package no.hvl.dat100ptc.oppgave2;

import static java.lang.Integer.*;
import static java.lang.Double.*;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {
		this.gpspoints = new GPSPoint[antall];
		this.antall = 0;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	// Her setter man inn et gpspunkt på en ledig plass i tabellen "gpspoints"
	protected boolean insertGPS(GPSPoint gpspoint) {
		boolean inserted = false;
		if (antall < gpspoints.length) {
			this.gpspoints[antall] = gpspoint;
			antall += 1;
			inserted = true;
		}
		return inserted;

	}
	// her lager metoden insert et nytt gpspunkt samtidig som den setter det inn i gpspoints tabellen.
	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		boolean verdi = insertGPS(gpspoint);
		return verdi;
	}
	
	// her printer metoden alle gpspunktene i tabellen "gpspoints"
	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");
		
		for (int i = 0; i < gpspoints.length; i++) {
			System.out.print(gpspoints[i].toString());
		}
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}

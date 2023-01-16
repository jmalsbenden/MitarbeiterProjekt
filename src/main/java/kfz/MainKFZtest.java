package kfz;
public class MainKFZtest {

	public static void main(String[] args) {
		Kfz bmw = new Kfz();
		bmw.setTankNow(40.8);
		bmw.setSpeedNow(80);
		bmw.setSpeedMax(300);
		bmw.ausgabeStammdaten();
		bmw.fahren();
		bmw.bremsen();
		bmw.ausgabeBewegungsdaten();
	}

}

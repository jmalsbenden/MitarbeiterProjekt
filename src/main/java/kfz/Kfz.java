package kfz;
/**
 * 
 * @author goertz
 *
 */

/**
 * 
 * @class Kfz
 * speichert die Eigenschaften eines KFZs und stellt KFZ-Funktionalität zur Verfügung
 */
public class Kfz {

	private int sitze = 5; //Anzahl der Sitze des KFZs
	private int personen = 4; //Anzahl der Personen im KFZ
	private double tankMax = 50.2; //Maximale Füllmenge des Tanks
	private double tankNow =  50.2; //Momentane Füllmenge des Tanks
	private int speedMax = 200; //Maximale Geschwindigkeit des KFZ
	private int speedNow = 50; //Momentane Geschwindigkeit des KFZ
	private double preis = 20000.00; //Anschaffungspreis für das KFZ

	public int getSitze() {
		return sitze;
	}

	/**
	 * 
	 * @param sitze 
	 * Die Anzahl der Sitze mindestens 1 sein.
	 */
	public void setSitze(int sitze) {

		if (sitze > 0)
		{
			this.sitze = sitze;
		}
	}

	public int getPersonen() {
		return personen;
	}

	/**
	 * 
	 * @param personen
	 * Kann nicht gößer als die Anzahl an Sitzen sein
	 */
	public void setPersonen(int personen) {
		if (personen <= this.sitze)
		{
			this.personen = personen;
		}
		else
		{
			System.out.println("Das KFZ ist überfüllt. Es werden nur " + this.sitze + " Personen mitgenommen.");
		}
	}

	public double getTankMax() {
		return tankMax;
	}

	/**
	 * 
	 * @param tankMax
	 * Ein Tank muss größer als der des Peel P50 sein welcher 4,5l umfasst
	 */
	public void setTankMax(double tankMax) {
		 
		if (tankMax < 4.5) {
			this.tankMax = 4.5;
			System.out.println(
					"Ein Tank muss größer sein als der des Peel P50 welcher das kleinste Auto ist und eine Tank von 4.5l hat.");
		} 
		else {
			this.tankMax = tankMax;
		}
	}

	public double getTankNow() {
		return tankNow;
	}

	/**
	 *
	 * @param tankNow
	 * Der Tank darf nicht überfüllt sein und auch nicht unter 0.
	 */
	public void setTankNow(double tankNow) {

		if (tankNow > this.tankMax)
		{
			System.out.println("Der Tank ist voll mit " + this.tankMax + ".");
			this.tankNow = this.tankMax;
		}
		else if (tankNow >= 0)
		{
			this.tankNow = tankNow;
		}
	}
	
	public int getSpeedMax() {
		return speedMax;
	}

	/**
	 * 
	 * @param speedMax
	 * Höchstgeschwindigkeit eines Autos ist Maximal 430 wie bei einem Bugatti Veyron
	 */
	public void setSpeedMax(int speedMax) {
		if (speedMax > 430)
		{
			System.out.println("Das schnellste KFZ ist der Bugatti Veyron mit 430kmh. Schneller geht nicht.");
			this.speedMax = 430;
		}
		else if (speedMax > 0)
		{
			this.speedMax = speedMax;
		}
	}
	
	public int getSpeedNow() {
		return speedNow;
	}

	/**
	 * 
	 * @param speedNow
	 * Kann nicht höher als speedMax sein.
	 */
	public void setSpeedNow(int speedNow) {
		if (speedNow <= this.speedMax)
		{
			this.speedNow = speedNow;
		}
		else
		{
			System.out.println("Du kannst nicht schneller als deine Höchstgeschwindigkeit fahren.");
		}
	}
	
	
	public double getPreis() {
		return preis;
	}

	/**
	 * 
	 * @param preis
	 * 
	 */
	public void setPreis(double preis) {
		 
		this.preis = preis;
	}

	public void ausgabeStammdaten() {
		System.out.println("Das KFZ hat " + this.sitze + " und kann " + this.speedMax + "km/h schnell fahren");
		System.out.println("Der Tank kann bis zu " + this.tankMax + "l fassen. In der Anschaffung hat das KFZ " + this.preis + "€ gekostet");
	}
	
	public void ausgabeBewegungsdaten() {
		System.out.println("Im KFZ befinden sich " + this.personen + " Personen.");
		System.out.println("Das KFZ fährt momentan mit einer Geschwindigkeit von " + this.speedNow + "km/h und hat noch " + this.tankNow + "l Sprit im Tank.");
	}
	
	public void bremsen() {
		this.speedNow = this.speedNow - 10;
		if (this.speedNow <= 0)
		{
			this.speedNow = 0;
			System.out.println("Das KFZ steht nun still.");
		}
	}
	
	public void beschleunigen() {
		this.speedNow = this.speedNow + 10;
		if (this.speedNow > this.speedMax)
		{
			this.speedNow = this.speedMax;
			System.out.println("Das KFZ hat die Höchstgeschwindigkeit erreicht.");
		}
	}
	
	public void fahren() {
		if (this.tankNow > 0 && this.speedNow > 0)
		{
			System.out.println("Das KFZ fährt.");
			this.tankNow--;
		}
		else if (this.tankNow == 0)
		{
			System.out.println("Der Tank ist leer und das KFZ kann nicht fahren.");
		}
		else 
		{
			System.out.println("Das KFZ steht still und muss erst beschleunigen bevor es fährt.");
		}
	}
	
	public void einsteigen() {
		if (this.personen == this.sitze)
		{
			System.out.println("Das KFZ ist bereits voll und es kann niemand mehr einsteigen.");
		}
		else
		{
			this.personen++;
		}
	}
	
	public void aussteigen() {
		if (this.personen > 0)
		{
			this.personen--;
		}
		else 
		{
			System.out.println("Es ist niemand im KFZ der Aussteigen kann.");
		}
	}
	
	public void tanken(double liter) {
	}
}

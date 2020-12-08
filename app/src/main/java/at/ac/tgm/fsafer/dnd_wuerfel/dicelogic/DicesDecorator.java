package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

/**
 * Decorator Klasse, welche die Methoden für alle Subklassen vorgibt
 * @author Florian Safer
 * @version 2020-12-08
 */
abstract class DicesDecorator implements Dices{

    private Dices dices;

    /**
     * Standardkonstruktor, welcher einen Würfel übernimmt und ihn als Attribut setzt
     * @param d Zu setzender Würfel
     */
    public DicesDecorator(Dices d){
        this.dices = d;
    }

    /**
     * Methode, welches das Ergebnis dieses Würfels als Zahl zurückgibt
     * @return Ergebnis
     */
    @Override
    public int getErgebnis() {
        return this.dices.getErgebnis();
    }

    /**
     * Methode, welches das Ergebnis dieses Würfels als Text zurückgibt
     * @return Ergebnis
     */
    @Override
    public String getInformation() {
        return this.dices.getInformation();
    }
}
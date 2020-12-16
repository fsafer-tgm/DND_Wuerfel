package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

/**
 * Bonus Würfel, welcher den Namen einer Fähigkeit übernimmt sowie einen Zahlenwert und diesen zum Ergebnis addiert
 * @author Florian Safer
 * @version 2020-12-08
 */
public class DiceBonus extends DicesDecorator
{
    private int value;
    private String type;

    /**
     * Standardkonstruktor
     * @param d Würfel, welcher als Superobjekt gespeichert wird
     * @param type Name der Fähigkeit
     * @param value Hinzuzurechnender Wert
     */
    public DiceBonus(Dices d, String type, int value) {
        super(d);
        this.value = value;
        this.type = type;
    }

    /**
     * Diese Methode gibt das Ergebnis mit dem Bonus zurück
     * @return Ergebnis
     */
    @Override
    public int getErgebnis() {
        return super.getErgebnis()+value;
    }

    /**
     * Diese Methode gibt das Ergebnis als Text mit der entsprechenden Fähigkeit zurück
     * @return Ergebnis als Text
     */
    @Override
    public String getInformation() {
        return "Bonus( "+super.getInformation()+") "+this.type+": "+this.value;
    }
}
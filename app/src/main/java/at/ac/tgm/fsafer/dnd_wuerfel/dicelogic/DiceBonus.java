package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

/**
 * Bonus Würfel, welcher den Namen einer Fähigkeit übernimmt sowie einen Zahlenwert und diesen zum Ergebnis addiert
 * @author Florian Safer
 * @version 2020-12-08
 */
public class DiceBonus extends DicesDecorator
{
    private int ergebnis;
    private String information;

    /**
     * Standardkonstruktor
     * @param d Würfel, welcher als Superobjekt gespeichert wird
     * @param type Name der Fähigkeit
     * @param value Hinzuzurechnender Wert
     */
    public DiceBonus(Dices d, String type, int value) {
        super(d);
        this.ergebnis = super.getErgebnis()+value;
        if (super.getInformation().equals(""))
            this.information = type+" ("+value+")";
        else
            this.information = super.getInformation()+", "+type+" ("+value+")";
    }

    /**
     * Diese Methode gibt das Ergebnis mit dem Bonus zurück
     * @return Ergebnis
     */
    @Override
    public int getErgebnis() {
        return this.ergebnis;
    }

    /**
     * Diese Methode gibt das Ergebnis als Text mit der entsprechenden Fähigkeit zurück
     * @return Ergebnis als Text
     */
    @Override
    public String getInformation() {
        return this.information;
    }
}
package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

/**
 * Diese Methode übernimmt einen Würfel und gibt das verdoppelte Ergebnis zurück
 * @author Florian Safer
 * @version 2020-12-08
 */
public class DiceCritical extends DicesDecorator
{

    /**
     * Standard Konstruktor, welcher einen Würfel übernimmt
     * @param d Super Objekt
     */
    public DiceCritical(Dices d) {
        super(d);
    }

    /**
     * Gibt das verdoppelte Ergebnis als Zahl zurück
     * @return
     */
    @Override
    public int getErgebnis() {
        return super.getErgebnis()*2;
    }

    /**
     * Gibt den Wert, um welchen verdoppelt wird, mit Zusatzinformation als Text zurück
     * @return Text mit Ergebnis
     */
    @Override
    public String getInformation() {
        if(super.getInformation().equals(""))
            return "Critical ("+super.getErgebnis()+")";
        return super.getInformation()+", Critical ("+super.getErgebnis()+")";
    }
}
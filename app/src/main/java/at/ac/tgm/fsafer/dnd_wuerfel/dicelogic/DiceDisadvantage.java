package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

/**
 * Vorteils-Würfel, welcher zwei mal würfelt und das niedrigere Ergebnis auswählt
 * @author Florian Safer
 * @version 2020-12-08
 */
public class DiceDisadvantage extends DicesDecorator {

    private Dices d2;

    /**
     * Standard-Konstruktor
     * @param d Würfel 1, der als Superobjekt gesetzt wird
     * @param d2 Würfel 2, um niedrigeres Ergebnis zu bekommen
     */
    public DiceDisadvantage(Dices d, Dices d2) {
        super(d);
        this.d2 = d2;
    }

    /**
     * Diese Methode gibt das niedrigere Ergbnis als Zahl zurück
     * @return Ergebnis als Zahl
     */
    @Override
    public int getErgebnis() {
        int val2 = this.d2.getErgebnis();
        if ( super.getErgebnis() >= val2)
            return val2;
        return super.getErgebnis();
    }

    /**
     * Diese Methode gibt das Ergebnis als Text mit der Information Disadvantage und beiden Ergebnissen aus
     * @return Ergebnis mit zusätzlicher Information
     */
    @Override
    public String getInformation() {
        return "Disadvantage( "+super.getInformation()+", "+d2.getInformation()+")";
    }
}
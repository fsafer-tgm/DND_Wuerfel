package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

/**
 * Vorteils-Würfel, welcher zwei mal würfelt und das höhere Ergebnis auswählt
 * @author Florian Safer
 * @version 2020-12-08
 */
public class DiceAdvantage extends DicesDecorator
{

    private Dices d2;

    /**
     * Standard-Konstruktor
     * @param d Würfel 1, der als Superobjekt gesetzt wird
     * @param d2 Würfel 2, um höheres Ergebnis zu bekommen
     */
    public DiceAdvantage(Dices d, Dices d2) {
        super(d);
        this.d2 = d2;
    }

    /**
     * Diese Methode gibt das höhere Ergbnis als Zahl zurück
     * @return Ergebnis als Zahl
     */
    @Override
    public int getErgebnis() {
        int val2 = this.d2.getErgebnis();
        if ( super.getErgebnis() <= val2)
            return val2;
        return super.getErgebnis();
    }

    /**
     * Diese Methode gibt das Ergebnis als Text mit der Information Advantage und beiden Ergebnissen aus
     * @return Ergebnis mit zusätzlicher Information
     */
    @Override
    public String getInformation() {
        String information;
        if (super.getErgebnis() >= this.d2.getErgebnis()) {
            if (super.getInformation().equals(""))
                information = super.getInformation() + "Advantage (" + super.getErgebnis() + ", " + this.d2.getErgebnis() + ")";
            else
                information = super.getInformation() + ", Advantage (" + super.getErgebnis() + ", " + this.d2.getErgebnis() + ")";
        } else {
            if (super.getInformation().equals(""))
                information = super.getInformation() + "Advantage (" + this.d2.getErgebnis() + ", " + super.getErgebnis() + ")";
            else
                information = super.getInformation() + ", Advantage (" + this.d2.getErgebnis() + ", " + super.getErgebnis() + ")";
        }
        return information;
    }
}
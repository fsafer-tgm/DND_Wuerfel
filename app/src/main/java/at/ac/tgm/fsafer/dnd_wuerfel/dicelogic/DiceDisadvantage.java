package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

import java.util.Random;

/**
 * Diese Klasse würfelt 2 mal und gibt beide Ergebnisse zurück. Jedoch wird nur das kleinere Ergebnis weiter verwendet
 * @author Florian Safer
 * @version 2020-11-25
 */
public class DiceDisadvantage extends DicesDecorator{

    private Dices d;

    /**
     * Stqndardkonstruktor
     * @param dices
     */
    public DiceDisadvantage(Dices dices) {
        super(dices);
        this.d = dices;
    }

    /**
     * Überschriebene rollTheDice Methode, welche zweimal würfelt und beide Ergebnisse zurückgibt. Jedoch ist nur das
     * kleinere Ergebnis von Bedeutung
     * @return beide Ergebnisse
     */
    @Override
    public String rollTheDice() {
        Random r = new Random();
        int newVal = r.nextInt(d.getSites())+1;
        int tmp = Integer.parseInt(super.rollTheDice());
        StringBuilder b = new StringBuilder();
        b.append("Nachteil(");
        if(newVal <= tmp){
            b.append(newVal);
            b.append(", ");
            b.append(tmp);
        }else{
            b.append(tmp);
            b.append(", ");
            b.append(newVal);
        }
        b.append(")");
        return b.toString();
    }

    /**
     * Methode, die die Seiten des Würfels zurückgeben kann
     * @return Seiten des Würfels
     */
    @Override
    public int getSites() {
        return this.d.getSites();
    }
}

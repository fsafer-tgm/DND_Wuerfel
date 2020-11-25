package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

import java.util.Random;

/**
 * Diese Würfelklasse würfelt 2 mal und gibt beide Summen zurück. Jeodch wird im Endeffekt nur die größere benötigt
 * @author Florian Safer
 * @version 2020-11-25
 */
public class DiceAdvantage extends DicesDecorator{

    Dices d;

    /**
     * Standardkonstruktor
     * @param dices
     */
    public DiceAdvantage(Dices dices) {
        super(dices);
        this.d = dices;
    }

    /**
     * Diese Methode würfelt 2 mal und gibt beide Werte zurück
     * @return String mit den beiden Ergebnissen
     */
    @Override
    public String rollTheDice() {
        Random r = new Random();
        int newVal = r.nextInt(d.getSites())+1;
        int tmp = Integer.parseInt(super.rollTheDice());
        StringBuilder b = new StringBuilder();
        b.append("Vorteil(");
        if(newVal >= tmp){
            if(newVal < 10)
                b.append("0");
            b.append(newVal);
            b.append(", ");
            if(tmp < 10)
                b.append("0");
            b.append(tmp);
        }else{
            if(tmp < 10)
                b.append("0");
            b.append(tmp);
            b.append(", ");
            if(newVal < 10)
                b.append("0");
            b.append(newVal);
        }
        b.append(")");
        return b.toString();
    }

    /**
     * Kann die Seiten des Würfels zurückgeben
     * @return Seiten des Würfels
     */
    @Override
    public int getSites() {
        return this.d.getSites();
    }
}

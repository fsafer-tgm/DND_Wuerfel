package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

/**
 * Diese Klasse verdoppelt das beim Würfeln entstandene Ergebnis
 * @author Florian Safer
 * @version 2020-11-25
 */
public class DiceCritical extends DicesDecorator{

    private Dices d;

    /**
     * Standardkonstruktor
     * @param dices
     */
    public DiceCritical(Dices dices) {
        super(dices);
        this.d = dices;
    }

    /**
     * Methode, die das Würfelergebnis bekommt und dieses multipliziert.
     * @return das verdoppelte Ergebnis
     */
    @Override
    public String rollTheDice() {
        int tmp = Integer.parseInt(super.rollTheDice().substring(0,2))*2;
        if(tmp<10)
            return "0"+tmp;
        return tmp+"";
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

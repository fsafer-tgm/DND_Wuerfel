package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

/**
 * Diese Klasse gibt einen String aus, welcher zusätzliche Informationen über die Berechnung der entgültigen Zahl enthält
 * (beispielsweise Ability)
 * @author Florian Safer
 * @version 2020-11-25
 */
public class DiceExtrainformation extends DicesDecorator{

    private String ability, proficiecy, item;
    private boolean critical;
    private Dices d;

    /**
     * Konstruktor, welche alle existierenden Werte übernimmt
     * @param dices
     * @param ability
     * @param proficiency
     * @param item
     * @param critical
     */
    public DiceExtrainformation(Dices dices, String ability, String proficiency, String item, boolean critical) {
        super(dices);
        this.d = dices;
        this.ability = ability;
        this.proficiecy = proficiency;
        this.item = item;
        this.critical = critical;
    }

    /**
     * Überschriebene rollTheDice Methode, welche alle Zusatzinformationen in einen String schreibt und diesen dann zurückgibt
     * @return Alle Informationen in einem String
     */
    @Override
    public String rollTheDice() {
        StringBuilder b = new StringBuilder();
        String tmp = super.rollTheDice();
        if(this.critical)
            b.append("0"+Integer.parseInt(tmp)/2+" (Critical)");
        else
            b.append(tmp);

        if(this.ability != null)
            b.append(" "+this.ability+" (Ability)");
        if(this.proficiecy != null)
            b.append(" "+this.proficiecy+" (Proficiecy)");
        if(this.item != null)
            b.append(" "+this.item+" (Item)");
        return b.toString();
    }

    /**
     * Methode, die die Anzahl der Seiten zurückgeben kann
     * @return
     */
    @Override
    public int getSites() {
        return this.d.getSites();
    }
}

package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;
public class DiceBonus extends DicesDecorator
{
    private int ergebnis;
    private String information;

    public DiceBonus(Dices d, String type, int value) {
        super(d);
        this.ergebnis = super.getErgebnis()+value;
        if (super.getInformation().equals(""))
            this.information = type+" ("+value+")";
        else
            this.information = super.getInformation()+", "+type+" ("+value+")";
    }

    @Override
    public int getErgebnis() {
        return this.ergebnis;
    }

    @Override
    public String getInformation() {
        return this.information;
    }
}
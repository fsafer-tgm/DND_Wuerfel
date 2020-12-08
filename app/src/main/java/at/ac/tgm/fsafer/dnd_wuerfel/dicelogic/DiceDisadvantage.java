package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;
public class DiceDisadvantage extends DicesDecorator {

    private Dices d2;

    public DiceDisadvantage(Dices d, Dices d2) {
        super(d);
        this.d2 = d2;
    }

    @Override
    public int getErgebnis() {
        int val2 = this.d2.getErgebnis();
        if ( super.getErgebnis() >= val2)
            return val2;
        return super.getErgebnis();
    }

    @Override
    public String getInformation() {
        String information;
        if (super.getErgebnis() <= this.d2.getErgebnis()) {
            if (super.getInformation().equals(""))
                information = super.getInformation() + "Disadvantage (" + super.getErgebnis() + ", " + this.d2.getErgebnis() + ")";
            else
                information = super.getInformation() + ", Disadvantage (" + super.getErgebnis() + ", " + this.d2.getErgebnis() + ")";
        } else {
            if (super.getInformation().equals(""))
                information = super.getInformation() + "Disadvantage (" + this.d2.getErgebnis() + ", " + super.getErgebnis() + ")";
            else
                information = super.getInformation() + ", Disadvantage (" + this.d2.getErgebnis() + ", " + super.getErgebnis() + ")";
        }
        return information;
    }
}
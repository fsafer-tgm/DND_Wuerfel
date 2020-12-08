package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;
public class DiceCritical extends DicesDecorator
{

    public DiceCritical(Dices d) {
        super(d);
    }

    @Override
    public int getErgebnis() {
        return super.getErgebnis()*2;
    }

    @Override
    public String getInformation() {
        if(super.getInformation().equals(""))
            return "Critical ("+super.getErgebnis()+")";
        return super.getInformation()+", Critical ("+super.getErgebnis()+")";
    }
}
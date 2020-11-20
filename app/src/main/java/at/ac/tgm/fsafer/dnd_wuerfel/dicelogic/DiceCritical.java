package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

public class DiceCritical extends DicesDecorator{

    private Dices d;

    public DiceCritical(Dices dices) {
        super(dices);
        this.d = dices;
    }

    @Override
    public String rollTheDice() {
        int tmp = 0;
        String value = super.rollTheDice();
        if(value.substring(0,7).equals("Vorteil"))
            tmp = Integer.parseInt(value.substring(8,10))*2;

        if(value.substring(0,8).equals("Nachteil"))
            tmp = Integer.parseInt(value.substring(9,11))*2;
        return value + " Critical: " + tmp;
    }

    @Override
    public int getSites() {
        return this.d.getSites();
    }
}

package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

import java.util.Random;

public class DiceDisadvantage extends DicesDecorator{

    private Dices d;

    public DiceDisadvantage(Dices dices) {
        super(dices);
        this.d = dices;
    }

    @Override
    public String rollTheDice() {
        Random r = new Random();
        int newVal = r.nextInt(d.getSites())+1;
        int tmp = Integer.parseInt(super.rollTheDice());
        StringBuilder b = new StringBuilder();
        b.append("Nachteil(");
        if(newVal <= tmp){
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

    @Override
    public int getSites() {
        return this.d.getSites();
    }
}

package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

import java.util.Random;

public class NormalDice implements Dices{

    private int sites;

    public NormalDice(int sites){
        this.sites=sites;

    }

    @Override
    public String rollTheDice() {
        Random r = new Random();
        return r.nextInt(sites)+1+"";
    }

    public int getSites() {
        return sites;
    }
}

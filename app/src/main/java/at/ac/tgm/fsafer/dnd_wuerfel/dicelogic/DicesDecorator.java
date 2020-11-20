package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

import java.util.Random;

abstract class DicesDecorator implements Dices{

    private Dices dice;


    public DicesDecorator(Dices dices){
        this.dice = dices;
    }

    @Override
    public String rollTheDice() {
        return dice.rollTheDice();
    }

}

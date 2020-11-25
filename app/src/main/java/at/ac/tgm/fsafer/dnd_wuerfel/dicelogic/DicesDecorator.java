package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

import java.util.Random;

/**
 * Abstrakte Decorator Klasse, welche von den anderen Würfelklassen geerbt wird
 * @author Florian Safer
 * @version 2020-11-25
 */
abstract class DicesDecorator implements Dices{

    private Dices dice;

    /**
     * Standardkonstruktor
     * @param dices
     */
    public DicesDecorator(Dices dices){
        this.dice = dices;
    }

    /**
     * Methode, die die Seiten des Würfels zurückgeben kann
     * @return Seiten des Würfels
     */
    @Override
    public String rollTheDice() {
        return dice.rollTheDice();
    }

}

package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

import java.util.Random;

/**
 * Normaler Würfel, welcher einmal mit beliebig vielen Seiten würfelt
 * @author Florian Safer
 * @version 2020-11-25
 */
public class NormalDice implements Dices{

    private int sites;

    /**
     * Standardkosntruktor
     * @param sites Anzahl der Seiten
     */
    public NormalDice(int sites){
        this.sites=sites;

    }

    /**
     * Methode, welche einmal würfelt und die Zahl dann als String zurückgibt
     * @return Würfelergebnis
     */
    @Override
    public String rollTheDice() {
        Random r = new Random();
        int tmp =  r.nextInt(sites)+1;
        if(tmp < 10){
            return "0"+tmp;
        }
        return tmp+"";
    }

    /**
     * Methode, die die Seiten des Würfels zurückgeben kann
     * @return Seiten des Würfels
     */
    public int getSites() {
        return sites;
    }
}

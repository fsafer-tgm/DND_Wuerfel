package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;
import java.util.Random;

/**
 * Würfel, welcher eine Seitenanzahl übernimmt und mit dieser Seitenzahl würfelt
 * @author Florian Safer
 * @version 2020-12-08
 */
public class NormalDice implements Dices
{
    private int sides;
    private int result;

    /**
     * Standard-Konstruktor, welcher eine Seitenanzahl übernimmt, prüft, ob sich diese im Bereich der Vorgaben
     * befindet und dann eine Zufallszahl generiert
     * @param sides Seitenanzahl
     */
    public NormalDice(int sides){
        if(sides == 4 || sides == 6 || sides == 8 || sides == 10 || sides == 12 || sides == 20){
            this.sides = sides;
        }
        Random r = new Random();
        this.result = r.nextInt(this.sides)+1;

    }


    /**
     * Gibt Ergebnis als Text mit Information für Normalen Würfel zurück
     * @return Ergebnis
     */
    @Override
    public String getInformation() {
        return "d"+this.sides+"("+this.result+")";
    }

    /**
     * Gibt Würfelergebnis als Zahl zurück
     * @return Ergebnis
     */
    @Override
    public int getErgebnis() {
        return this.result;
    }


}
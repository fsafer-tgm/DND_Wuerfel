package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;
import java.util.Random;

public class NormalDice implements Dices
{
    private int sides;
    private int result;

    public NormalDice(int sides){
        if(sides == 4 || sides == 6 || sides == 8 || sides == 10 || sides == 12 || sides == 20){
            this.sides = sides;
        }
        Random r = new Random();
        this.result = r.nextInt(this.sides)+1;

    }



    @Override
    public String getInformation() {
        return "";
    }

    @Override
    public int getErgebnis() {
        return this.result;
    }


}
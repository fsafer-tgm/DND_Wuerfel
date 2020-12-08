package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

abstract class DicesDecorator implements Dices{

    private Dices dices;

    public DicesDecorator(Dices d){
        this.dices = d;
    }

    @Override
    public int getErgebnis() {
        return this.dices.getErgebnis();
    }

    @Override
    public String getInformation() {
        return this.dices.getInformation();
    }
}
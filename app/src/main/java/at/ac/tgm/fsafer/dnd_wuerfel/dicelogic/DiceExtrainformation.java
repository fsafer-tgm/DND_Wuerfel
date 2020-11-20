package at.ac.tgm.fsafer.dnd_wuerfel.dicelogic;

public class DiceExtrainformation extends DicesDecorator{

    private String ability, proficiecy, item;
    private Dices d;

    public DiceExtrainformation(Dices dices, String ability, String proficiency, String item) {
        super(dices);
        this.d = dices;
        this.ability = ability;
        this.proficiecy = proficiency;
        this.item = item;
    }

    public DiceExtrainformation(Dices dices){
        super(dices);
    }

    @Override
    public String rollTheDice() {
        StringBuilder b = new StringBuilder();
        String tmp = super.rollTheDice();
        b.append(tmp);
        System.out.println(tmp);
        if(this.ability != null)
            b.append(" "+this.ability+" (Ability)");
        if(this.proficiecy != null)
            b.append(" "+this.proficiecy+" (Proficiecy)");
        if(this.item != null)
            b.append(" "+this.item+" (Item)");
        return b.toString();
    }

    @Override
    public int getSites() {
        return this.d.getSites();
    }
}

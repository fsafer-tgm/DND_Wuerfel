package at.ac.tgm.fsafer.dnd_wuerfel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import at.ac.tgm.fsafer.dnd_wuerfel.dicelogic.*;

/**
 * MainAcitivity für die DND Würfel APP.
 * @author Florian Safer
 * @version 2020-11-25
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int ability;
    private int proficiecy;
    private int item;
    private int checked;

    private int readAbility;

    private int toAdd, sites;

    /**
     * In dieser Methode werden von mir die 3 Spinner, welche in der Main App verwendet werden, befüllt.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner wuerfel = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Wuerfel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wuerfel.setAdapter(adapter);
        wuerfel.setOnItemSelectedListener(this);

        Spinner pro = findViewById(R.id.abilityBonus);
        ArrayAdapter<CharSequence> proAdapter = ArrayAdapter.createFromResource(this,R.array.abilitybonus, R.layout.support_simple_spinner_dropdown_item);
        proAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pro.setAdapter(proAdapter);
        pro.setOnItemSelectedListener(this);

        Spinner upper = findViewById(R.id.upperSpinner);
        ArrayAdapter<CharSequence> upperChar = ArrayAdapter.createFromResource(this,R.array.abilitybonus, R.layout.support_simple_spinner_dropdown_item);
        upperChar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        upper.setAdapter(proAdapter);
        upper.setOnItemSelectedListener(this);

        this.sites = 4;

    }


    /**
     * Diese Methode wird benötigt, um ein OptionsMenu zu erstellen
     * @return Returnt true, wenn das Menu richtig erstellt wurde
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_options_menu, menu);
        return true;
    }

    /**
     * Listener Methode für die Items im Menu
     * @param item Welches Item angeklickt wurde
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addProfile:
                Intent addProfile = new Intent(this, CreateProfile.class);
                startActivity(addProfile);
                return true;
            case R.id.proficiency:
                Intent proficiency = new Intent(this, AddProficiency.class);
                startActivity(proficiency);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Diese Methode ist für das berechnen der oberen Sektion zuständig.
     * @param view Welcher Button geklickt wurde
     */
    public void rollDice(View view){
        RadioGroup g = findViewById(R.id.radioGroup);
        TextView t = findViewById(R.id.numberOut2);
        TextView f = findViewById(R.id.finalOut);

        setAttributes();
        getAttributes();
        Dices normal = new NormalDice(20);
        Dices dice = null;
        switch (g.getCheckedRadioButtonId()) {
            case R.id.radioNormal:
                dice = addBonus(normal);
                break;
            case R.id.radioAdvantage:
                dice = addBonus(new DiceAdvantage(normal, new NormalDice(20)));
                break;
            case R.id.radioDisadvantage:
                dice = addBonus(new DiceDisadvantage(normal, new NormalDice(20)));
                break;
            default:
                t.setText("Würfelart auswählen");

        }
        if (dice != null){
            t.setText(""+dice.getErgebnis());
            f.setText(dice.getInformation());
        }
    }

    public Dices addBonus(Dices normal){
        System.out.println("Bin im Bonus");
        Dices tmp;
        if(this.ability !=0) {
            tmp = new DiceBonus(normal, "Ability", this.ability);
            normal = tmp;
        }
        if (this.proficiecy != 0){
            System.out.println("Bin im Profi");
            tmp = new DiceBonus(normal, "Proficiency", this.proficiecy);
            normal = tmp;
        }
        if (this.item != 0){
            tmp = new DiceBonus(normal, "Item", this.item);
            normal = tmp;
        }
        return normal;
    }

    public void setAttributes(){
        this.ability = 0;
        this.proficiecy = 0;
        this.item = 0;
        this.toAdd = 0;
    }

    /**
     * Diese Methode ist dafür zuständig, die in den Eingabefeldern eingegebenen Werte auszulesen
     */
    public void getAttributes(){
        CheckBox c1;
        CheckBox c2;
        EditText e;
        this.checked = 0;
            c1 = findViewById(R.id.checkAbility);
            c2 = findViewById(R.id.checkAbility2);
            if (c1.isChecked() || c2.isChecked()){
                this.ability = readAbility;
                toAdd += this.readAbility;
                this.checked++;
            }

            c1 = findViewById(R.id.checkProficiency);
            c2 = findViewById(R.id.checkProficiency2);
            if(c1.isChecked() || c2.isChecked()){
                SharedPreferences sharedPref = getSharedPreferences("Proficiency", 0);
                this.proficiecy = sharedPref.getInt(String.valueOf(R.integer.proficiency),0);
                toAdd += this.proficiecy;
                this.checked++;
            }

            c1 = findViewById(R.id.checkItem);
            c2 = findViewById(R.id.checkItem2);
            e = findViewById(R.id.editItem);
            if(c1.isChecked() || c2.isChecked()){
                try {
                    int tmp = Integer.parseInt(e.getText().toString());
                }catch (NumberFormatException exception){
                    TextView t = findViewById(R.id.profile_name);
                    t.setText("Gültigen Wert bei Item eingeben");
                }
                this.checked++;
            }

    }

    /**
     * Diese Methode ist für die Berechnung der Werte im unteren Bereich zuständig
     * @param view Der geklickte Button
     */
    public void damageChecks(View view){
        CheckBox c = findViewById(R.id.critical);
        this.toAdd = 0;
        setAttributes();
        getAttributes();

        TextView t = findViewById(R.id.damageOut);
        TextView f = findViewById(R.id.completeOut);
        Dices normal = new NormalDice(sites);
        Dices d = null;

        if (c.isChecked()){
            d = addBonus(new DiceCritical(normal));
        }else {
            d = addBonus(normal);

        }
        t.setText(d.getErgebnis()+"");
        f.setText(d.getInformation());
    }


    /**
     * Dies ist der von mir überschriebene Listener für alle 3 Spinner
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinner) {
            switch (position){
                case 0:
                    this.sites=4;
                    break;
                case 1:
                    this.sites=6;
                    break;
                case 2:
                    this.sites=8;
                    break;
                case 3:
                    this.sites=10;
                    break;
                case 4:
                    this.sites=12;
                    break;
            }
        }
        if(parent.getId() == R.id.abilityBonus || parent.getId() == R.id.upperSpinner){


                SharedPreferences sharedPref = getSharedPreferences("Abilitys", 0);
                int standard = 0;
                switch (position){
                    case 0:
                        this.readAbility = sharedPref.getInt(String.valueOf(R.integer.strength), standard);
                        System.out.println(this.readAbility);
                        break;
                    case 1:
                        this.readAbility = sharedPref.getInt(String.valueOf(R.integer.dexterity), standard);
                        break;
                    case 2:
                        this.readAbility = sharedPref.getInt(String.valueOf(R.integer.constitution), standard);
                        break;
                    case 3:
                        this.readAbility = sharedPref.getInt(String.valueOf(R.integer.intelligence), standard);
                        break;
                    case 4:
                        this.readAbility = sharedPref.getInt(String.valueOf(R.integer.wisdom), standard);
                        break;
                    case 5:
                        this.readAbility = sharedPref.getInt(String.valueOf(R.integer.charisma), standard);
                        break;
                }
                if (this.readAbility == standard){
                    TextView t = findViewById(R.id.profile_name);
                    t.setText("Bitte ein Profil anlegen");
                }else
                    this.toAdd = this.readAbility;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
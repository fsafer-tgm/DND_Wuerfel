package at.ac.tgm.fsafer.dnd_wuerfel;

import android.content.Context;
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

    private String ability;
    private String proficiecy;
    private String item;

    private String readAbility;

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
                Intent explicit = new Intent(MainActivity.this, CreateProfile.class);
                startActivity(explicit);
            case R.id.proficiency:

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
        Dices d;
        TextView t = findViewById(R.id.numberOut2);
        TextView f = findViewById(R.id.finalOut);
        String tmp,number;

        this.toAdd = 0;
        getAttributes(true);

        switch (g.getCheckedRadioButtonId()) {
            case R.id.radioNormal:
                d = new NormalDice(20);
                t.setText(d.rollTheDice());
                break;
            case R.id.radioAdvantage:
                d = new DiceExtrainformation(new DiceAdvantage(new NormalDice(20)), this.ability, this.proficiecy, this.item, false);
                tmp = d.rollTheDice();
                number = tmp.substring(8,10);
                t.setText(Integer.parseInt(number)+this.toAdd+"");
                f.setText(tmp);
                break;
            case R.id.radioDisadvantage:
                d = new DiceExtrainformation(new DiceDisadvantage(new NormalDice(20)), this.ability, this.proficiecy, this.item, false);
                tmp = d.rollTheDice();
                number = tmp.substring(9,11);
                t.setText(Integer.parseInt(number)+this.toAdd+"");
                f.setText(tmp);
                break;
            default:
                t.setText("Würfelart auswählen");

        }
    }

    /**
     * Diese Methode ist dafür zuständig, die in den Eingabefeldern eingegebenen Werte auszulesen
     * @param select true für oberen Bereich, false für unteren
     */
    public void getAttributes(boolean select){
        CheckBox c;
        EditText e;
        if (select == true){
            c = findViewById(R.id.checkAbility);
            this.ability = readAbility;
            toAdd += Integer.parseInt(this.readAbility);

            c = findViewById(R.id.checkProficiency);
            e = findViewById(R.id.editProficiecy);
            if(c.isChecked()){
                this.proficiecy = e.getText().toString();
                toAdd += Integer.parseInt(this.proficiecy);
            }

            c = findViewById(R.id.checkItem);
            e = findViewById(R.id.editItem);
            if(c.isChecked())
                this.item = e.getText().toString();

        } else{
            c = findViewById(R.id.checkAbility2);
            if(c.isChecked()){
                this.ability = readAbility;
                toAdd += Integer.parseInt(this.ability);
            }


            c = findViewById(R.id.checkProficiency2);
            e = findViewById(R.id.editProficiecy2);
            if(c.isChecked()){
                this.proficiecy = e.getText().toString();
                toAdd += Integer.parseInt(this.proficiecy);
            }
            c = findViewById(R.id.checkItem2);
            e = findViewById(R.id.editItem2);
            if(c.isChecked())
                this.item = e.getText().toString();

        }
    }

    /**
     * Diese Methode ist für die Berechnung der Werte im unteren Bereich zuständig
     * @param view Der geklickte Button
     */
    public void damageChecks(View view){
        CheckBox c = findViewById(R.id.critical);
        this.toAdd = 0;
        getAttributes(false);



        String tmp, number;
        Dices d;

        TextView t = findViewById(R.id.damageOut);
        TextView f = findViewById(R.id.completeOut);

        if (c.isChecked()){
            d = new DiceExtrainformation(new DiceCritical(new NormalDice(this.sites)),this.ability, this.proficiecy,this.item, true);
            tmp = d.rollTheDice();
            number = tmp.substring(0,2);
            System.out.println(this.toAdd);
            t.setText(Integer.parseInt(number)*2+this.toAdd+"");
            f.setText(tmp);
        }else {
            d = new DiceExtrainformation(new NormalDice(this.sites),this.ability, this.proficiecy,this.item, false);
            tmp = d.rollTheDice();
            number = tmp.substring(0,2);
            t.setText(Integer.parseInt(number)+this.toAdd+"");
            f.setText(tmp);
        }
        this.ability = null;
        this.proficiecy = null;
        this.item = null;
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
                String standard = "";
                switch (position){
                    case 0:
                        this.readAbility = sharedPref.getString(String.valueOf(R.string.strength), standard);
                        System.out.println(this.readAbility);
                        break;
                    case 1:
                        this.readAbility = sharedPref.getString(String.valueOf(R.string.dexterity), standard);
                        break;
                    case 2:
                        this.readAbility = sharedPref.getString(String.valueOf(R.string.constitution), standard);
                        break;
                    case 3:
                        this.readAbility = sharedPref.getString(String.valueOf(R.string.intelligence), standard);
                        break;
                    case 4:
                        this.readAbility = sharedPref.getString(String.valueOf(R.string.wisdom), standard);
                        break;
                    case 5:
                        this.readAbility = sharedPref.getString(String.valueOf(R.string.charisma), standard);
                        break;
                }
                if (this.readAbility.equals("")){
                    TextView t = findViewById(R.id.profile_name);
                    t.setText("Bitte ein Profil anlegen");
                }else
                    this.toAdd = Integer.parseInt(this.readAbility);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
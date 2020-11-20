package at.ac.tgm.fsafer.dnd_wuerfel;

import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import at.ac.tgm.fsafer.dnd_wuerfel.dicelogic.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String ability;
    private String proficiecy;
    private String item;
    private int toAdd, sites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Wuerfel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addProfile:
                Intent explicit = new Intent(MainActivity.this, CreateProfile.class);
                startActivity(explicit);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void rollDice(View view){
        RadioGroup g = findViewById(R.id.radioGroup);
        Dices d;
        TextView t = findViewById(R.id.numberOut);
        TextView f = findViewById(R.id.finalOut);
        String tmp,number;

        this.toAdd = 0;
        getAttributes();

        switch (g.getCheckedRadioButtonId()) {
            case R.id.radioNormal:
                d = new NormalDice(20);
                t.setText(d.rollTheDice());
                break;
            case R.id.radioAdvantage:
                d = new DiceExtrainformation(new DiceAdvantage(new NormalDice(20)), this.ability, this.proficiecy, this.item);
                tmp = d.rollTheDice();
                number = tmp.substring(8,10);
                t.setText(Integer.parseInt(number)+this.toAdd+"");
                f.setText(tmp);
                break;
            case R.id.radioDisadvantage:
                d = new DiceExtrainformation(new DiceDisadvantage(new NormalDice(20)), this.ability, this.proficiecy, this.item);
                tmp = d.rollTheDice();
                number = tmp.substring(9,11);
                t.setText(number);
                f.setText(tmp);
                break;
            default:
                t.setText("Würfelart auswählen");

        }
    }
    public void getAttributes(){
        CheckBox c = findViewById(R.id.checkAbility);
        EditText e = findViewById(R.id.editAbility);

        if(c.isChecked()){
            this.ability = e.getText().toString();
            toAdd += Integer.parseInt(this.ability);
        }

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

    }

    public void damageChecks(View view){

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
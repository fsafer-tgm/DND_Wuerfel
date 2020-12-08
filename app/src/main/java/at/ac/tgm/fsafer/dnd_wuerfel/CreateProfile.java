package at.ac.tgm.fsafer.dnd_wuerfel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Diese Klasse ist eine zweite Acitivty. Sie wird benötigt, um alle Daten für ein Profil einzugeben
 * @author Florian Safer
 * @version 2020-11-25
 */
public class CreateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
    }

    /**
     * In dieser Methode werden alle Values aus den Textfeldern ausgelesen und in die Shared Preferences gespeichert
     * @param view
     */
    public void saveProfile(View view){
        int tmp = -1;
        boolean allesRichtig = true;
        SharedPreferences sharedPref = getSharedPreferences("Abilitys", 0);
        EditText e = findViewById(R.id.inputStrength);
        String s = e.getText().toString();
        SharedPreferences.Editor editor = sharedPref.edit();
        try {
            tmp = Integer.parseInt(s);
            if (tmp != -1)
                editor.putInt(String.valueOf(R.integer.strength),tmp);
            tmp = -1;
            e = findViewById(R.id.inputDexterity);
            s = e.getText().toString();
            tmp = Integer.parseInt(s);
            if (tmp != -1)
                editor.putInt(String.valueOf(R.integer.dexterity),tmp);
            tmp = -1;
            e = findViewById(R.id.inputConstitiution);
            s = e.getText().toString();
            tmp = Integer.parseInt(s);
            if (tmp != -1)
                editor.putInt(String.valueOf(R.integer.constitution),tmp);
            tmp = -1;
            e = findViewById(R.id.inputIntelligence);
            s = e.getText().toString();
            tmp = Integer.parseInt(s);
            if (tmp != -1)
                editor.putInt(String.valueOf(R.integer.intelligence),tmp);
            tmp = -1;
            e = findViewById(R.id.inputWisdom);
            s = e.getText().toString();
            tmp = Integer.parseInt(s);
            if (tmp != -1)
                editor.putInt(String.valueOf(R.integer.wisdom),tmp);
            tmp = -1;
            e = findViewById(R.id.inputCharisma);
            s = e.getText().toString();
            tmp = Integer.parseInt(s);
            if (tmp != -1)
                editor.putInt(String.valueOf(R.integer.charisma),tmp);
        }catch (NumberFormatException exception){
            TextView t = findViewById(R.id.error);
            t.setText("Please enter valid numbers");
            allesRichtig = false;
        }
        if(allesRichtig){
            editor.apply();
            finish();
        }
    }

}
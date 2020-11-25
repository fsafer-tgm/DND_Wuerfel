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
        boolean allesRichtig = true;
        SharedPreferences sharedPref = getSharedPreferences("Abilitys", 0);
        EditText e = findViewById(R.id.inputStrength);
        String s = e.getText().toString();
        SharedPreferences.Editor editor = sharedPref.edit();
        try {
            if (s.length()>0)
                editor.putString(String.valueOf(R.string.strength),s);
            Integer.parseInt(s);
            e = findViewById(R.id.inputDexterity);
            s = e.getText().toString();
            if (s.length()>0)
                editor.putString(String.valueOf(R.string.dexterity),s);
            Integer.parseInt(s);
            e = findViewById(R.id.inputConstitiution);
            s = e.getText().toString();
            if (s.length()>0)
                editor.putString(String.valueOf(R.string.constitution),s);
            Integer.parseInt(s);
            e = findViewById(R.id.inputIntelligence);
            s = e.getText().toString();
            if (s.length()>0)
                editor.putString(String.valueOf(R.string.intelligence),s);
            Integer.parseInt(s);
            e = findViewById(R.id.inputWisdom);
            s = e.getText().toString();
            if (s.length()>0)
                editor.putString(String.valueOf(R.string.wisdom),s);
            Integer.parseInt(s);
            e = findViewById(R.id.inputCharisma);
            s = e.getText().toString();
            if (s.length()>0)
                editor.putString(String.valueOf(R.string.charisma),s);
            Integer.parseInt(s);
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
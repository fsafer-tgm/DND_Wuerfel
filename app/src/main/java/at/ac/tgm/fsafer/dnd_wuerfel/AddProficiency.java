package at.ac.tgm.fsafer.dnd_wuerfel;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Diese Klasse nimmt die Eingabe für Proficiency und speichert sie in die Shared Preferences
 * @author Florian Safer
 * @version 2020-11-25
 */
public class AddProficiency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_proficiency);
    }

    /**
     * Diese Methode wird von einem Button in der View aufgerufen. Sie nimmt den Wert aus der Eingabe und speichert
     * sie in die SharedPreferences
     * @param view Button, über welchen die Methode asufgerufen wird
     */
    public void saveProficiency(View view){
        boolean eingabeRichtig = true;
        SharedPreferences sharedPref = getSharedPreferences("Proficiency", 0);
        EditText e = findViewById(R.id.viewProficiency);
        String s = e.getText().toString();
        SharedPreferences.Editor editor = sharedPref.edit();
        try {
            System.out.println("Bin im try");
            if (s.length()>0)
                editor.putString(String.valueOf(R.string.proficiency),s);
            Integer.parseInt(s);
        }catch (NumberFormatException exception){
            TextView t = findViewById(R.id.errorOut);
            t.setText("Enter a valid Number");
            eingabeRichtig = false;
        }
        if(eingabeRichtig){
            editor.apply();
            finish();
        }
    }
}
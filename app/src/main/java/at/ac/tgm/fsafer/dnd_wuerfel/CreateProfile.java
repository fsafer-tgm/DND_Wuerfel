package at.ac.tgm.fsafer.dnd_wuerfel;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CreateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
    }

    public void saveProfile(View view){
        SharedPreferences sharedPref = CreateProfile.this.getPreferences(Context.MODE_PRIVATE);
        EditText e = findViewById(R.id.profile_name);
        String s = e.getText().toString();
        SharedPreferences.Editor editor = sharedPref.edit();
        if(s.length()>0)
            editor.putString(String.valueOf(R.string.profile_name), s);
        e = findViewById(R.id.inputStrength);
        s = e.getText().toString();
        if (s.length()>0)
            editor.putString(String.valueOf(R.string.strength),s);
        e = findViewById(R.id.inputDexterity);
        s = e.getText().toString();
        if (s.length()>0)
            editor.putString(String.valueOf(R.string.dexterity),s);
        e = findViewById(R.id.inputConstitiution);
        s = e.getText().toString();
        if (s.length()>0)
            editor.putString(String.valueOf(R.string.constitution),s);
        e = findViewById(R.id.inputIntelligence);
        s = e.getText().toString();
        if (s.length()>0)
            editor.putString(String.valueOf(R.string.intelligence),s);
        e = findViewById(R.id.inputWisdom);
        s = e.getText().toString();
        if (s.length()>0)
            editor.putString(String.valueOf(R.string.wisdom),s);
        e = findViewById(R.id.inputCharisma);
        s = e.getText().toString();
        if (s.length()>0)
            editor.putString(String.valueOf(R.string.charisma),s);
        editor.commit();



    }

}
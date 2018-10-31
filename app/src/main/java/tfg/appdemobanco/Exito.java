package tfg.appdemobanco;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by pedromi on 1/10/18..
 */

public class Exito extends AppCompatActivity {
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        boton=findViewById(R.id.button);
        boton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio= new Intent(getApplicationContext(),Main2Activity.class);
                inicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(inicio);
                finish();
            }
        });
    }
}

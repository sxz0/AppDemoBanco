package tfg.appdemobanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Transacciones extends AppCompatActivity {
    private EditText importe;
    private EditText pass;
    private Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacciones);
        importe = (EditText) findViewById(R.id.editText3);
        pass=(EditText) findViewById(R.id.editText7);
        double AL= Utils.leerValidacion();
        if(AL<0.78){
            pass.setVisibility(View.VISIBLE);
        }else{
            pass.setVisibility(View.INVISIBLE);
        }
        boton = (Button) findViewById(R.id.button5);
        final double res = Utils.leerValidacion();
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = String.valueOf(importe.getText());
                double importe=0;
                if(n!=null)
                    importe = Double.parseDouble(n);
                else
                    Toast.makeText(getApplicationContext(),"The amount can not be void.",Toast.LENGTH_LONG).show();
                    //Comprobacion de credenciales si hubiera
                Intent exito=new Intent(getApplicationContext(),Exito.class);
                startActivity(exito);
                /*if ((res >= 0.80 && importe > 20) || importe <= 20) {

                }*/
            }
        });
    }
}

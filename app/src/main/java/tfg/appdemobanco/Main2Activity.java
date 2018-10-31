package tfg.appdemobanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button b1;
    Button b2;
    private TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        error=(TextView) findViewById(R.id.textView);
        final double res=Utils.leerValidacion();
        if(res<0.35){
            error.setVisibility(View.VISIBLE);
            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
        }else{
            error.setVisibility(View.INVISIBLE);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(res>=0.67){
                    Intent ListSong = new Intent(getApplicationContext(), Cuentas.class);
                    startActivity(ListSong);
                }else {
                    Toast.makeText(getApplicationContext(),"You do not have enough authentication level",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(res>=0.67){
                    Intent ListSong = new Intent(getApplicationContext(), Transacciones.class);
                    startActivity(ListSong);
                }else {
                    Toast.makeText(getApplicationContext(),"You do not have enough authentication level",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        final double res=Utils.leerValidacion();
        if(res<0.35){
            error.setVisibility(View.VISIBLE);
            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
        }else{
            error.setVisibility(View.INVISIBLE);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
        }
    }
}

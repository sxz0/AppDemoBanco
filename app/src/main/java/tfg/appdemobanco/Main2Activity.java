package tfg.appdemobanco;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.AppOpsManager.MODE_ALLOWED;
import static android.app.AppOpsManager.OPSTR_GET_USAGE_STATS;
import static android.os.Process.myUid;

public class Main2Activity extends AppCompatActivity {
    Button b1;
    Button b2;
    private TextView error;
    double res=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        error=(TextView) findViewById(R.id.textView);
        res=Utils.leerValidacion();
        checkForPermission(this);
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
        res=Utils.leerValidacion();
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
    private void checkForPermission(Context context) {
        boolean hasPermissionWrite = (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        String[] permissions;

        //Permisos estadisticas de uso y escritura en memoria
        permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if(!hasPermissionWrite)
            ActivityCompat.requestPermissions(this,permissions,0);
    }
}

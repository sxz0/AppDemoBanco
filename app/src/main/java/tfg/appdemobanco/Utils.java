package tfg.appdemobanco;

import android.Manifest;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;


public class Utils {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    public static double leerValidacion(){
        try {
            File rootPath = new File(Environment.getExternalStorageDirectory(), "ML");
            if(!rootPath.exists())
                return 0.0;
            File dataFile=new File(rootPath,"resultadoEvaluacion.txt");
            if(!dataFile.exists())
                return 0.0;
            FileReader fis=new FileReader(dataFile);
            Scanner scanner=new Scanner(fis);
            String s=scanner.next();
            double res=Double.parseDouble(s);
            fis.close();
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}

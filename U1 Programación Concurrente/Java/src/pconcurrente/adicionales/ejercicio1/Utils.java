package pconcurrente.practica1;

import java.io.File;

public class Utils {

    public static long getFolderSize(File folder)
    {
        long length = 0;

        File[] files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
            else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }

    public static ConversionResult convertUnits(long bytes){
        ConversionResult cr;
        boolean negative = bytes < 0;
        if(negative){
            bytes = Math.abs(bytes);
        }
        if(bytes<1000){
            cr = new ConversionResult((float)bytes, Unit.B);
        } else if(bytes<1000000) {
            float redondeo = Math.round((float)(bytes/1000f * 100)) / 100.0f;
            cr = new ConversionResult(redondeo, Unit.KB);
        } else if(bytes<1000000000){
            float redondeo = Math.round((float)(bytes/1000000f * 100)) / 100.0f;
            cr = new ConversionResult(redondeo, Unit.MB);
        } else {
            float redondeo = Math.round((float)(bytes/1000000000f * 100)) / 100.0f;
            cr = new ConversionResult(redondeo, Unit.GB);
        }

        if(negative){
            cr.setValue(-cr.getValue());
        }

        return cr;
    }
}

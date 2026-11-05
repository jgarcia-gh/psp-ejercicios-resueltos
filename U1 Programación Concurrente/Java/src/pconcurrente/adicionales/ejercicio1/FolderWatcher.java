package pconcurrente.practica1;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FolderWatcher implements Runnable {

    public ArrayList<String> historical = new ArrayList<String>();
    private File file;
    private long lastFolderSize;
    private long currentFolderSize;
    private boolean run = true;
    private boolean showLiveLog = false;

    public void detener() {
        this.run = false;
    }

    public void setShowLiveLog(boolean showLiveLog) {
        this.showLiveLog = showLiveLog;
    }

    public String getPath(){
        return file.getAbsolutePath();
    }

    public FolderWatcher(String path){
        file = new File(path);
    }
    public FolderWatcher(File f){
        file = f;
    }
    @Override
    public void run() {
        currentFolderSize = lastFolderSize = Utils.getFolderSize(file);
        showSizeChange(currentFolderSize,lastFolderSize);

        do {
            long currentFolderSize = Utils.getFolderSize(file);
            if(currentFolderSize != lastFolderSize){
                showSizeChange(currentFolderSize,lastFolderSize);
            }
            lastFolderSize = currentFolderSize;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (run);

    }

    public void showSizeChange(long currentFolderSize, long lastFolderSize){


        long inc = currentFolderSize - lastFolderSize;
        ConversionResult incCR = Utils.convertUnits(inc);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);

        String line = currentTime + " " + file.getAbsolutePath() + " " + Utils.convertUnits(currentFolderSize)
                + "(" + (incCR.getValue() >0? "+ " : "")
                + incCR + ")";

        historical.add(line);
        if(showLiveLog){
            System.out.println(line);
        }
    }

    public void showHistorical(){
        for (String s : historical) {
            System.out.println(s);
        }
    }

}

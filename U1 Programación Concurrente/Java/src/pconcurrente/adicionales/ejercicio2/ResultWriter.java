package pconcurrente.adicionales.ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultWriter {

    private Result currentResult = null;
    private PrintWriter pw = null;

    public ResultWriter(){
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(".\\files\\busquedas", true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writeResult(Result r){

        if(pw != null){

            boolean showHeader = false;
            if(currentResult == null){
                currentResult = r;
                showHeader = true;
            } else {
                if(currentResult.getSearch().getId() != r.getSearch().getId()){
                    currentResult = r;
                    showHeader = true;
                }
            }

            if(showHeader){
                Search s = currentResult.getSearch();
                pw.println("----------------------------------------------------------------------------------");
                pw.println("Search ID: " + s.getId() + " File: " + s.getFileName() + " Word: " + s.getWord());
                pw.println("----------------------------------------------------------------------------------");
            }

            pw.println("\t" + r.getLine());
        }

    }

    public void close(){
        if(pw!=null){
            pw.close();
        }
    }
}

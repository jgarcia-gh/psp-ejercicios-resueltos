package pconcurrente.adicionales.ejercicio2;

import java.io.*;
import java.util.ArrayList;


public class Search implements Runnable{
    public enum STATE {
        NEW,
        SEARCHING,
        FINISHED
    }

    private String fileName;
    private String word;
    private ArrayList<Result> results = new ArrayList<Result>();
    private STATE state;
    private boolean run = true;
    private ResultWriter resultWriter = null;
    private int id;

    public void setResultWriter(ResultWriter rw){
        this.resultWriter = rw;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public String getFileName() {
        return fileName;
    }

    public String getWord() {
        return word;
    }

    public int getNumberResults(){
        return results.size();
    }

    public STATE getState(){
        return state;
    }

    public int getId() {
        return id;
    }

    public void stop(){
        run = false;
    }
    public Search(int id, String fileName, String word){
        this.fileName = fileName;
        this.word = word;
        this.state = STATE.NEW;
        this.id = id;
    }

    @Override
    public void run() {
        this.state = STATE.SEARCHING;
        int lineCounter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(".\\Files\\" + fileName));
            String line;
            while((line = br.readLine())!= null && run){
                lineCounter++;
                if(line.toLowerCase().contains(word.toLowerCase())){
                    Result r = new Result(this, lineCounter, line);
                    results.add(r);
                    if(resultWriter != null){
                        resultWriter.writeResult(r);
                    }
                }
            }
            this.state = STATE.FINISHED;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package pconcurrente.adicionales.ejercicio2;

public class Result {

    private int lineNumber;
    private String line;
    private Search search;

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Result(Search search, int lineNumber, String line){
        this.search = search;
        this.lineNumber = lineNumber;
        this.line = line;
    }
}

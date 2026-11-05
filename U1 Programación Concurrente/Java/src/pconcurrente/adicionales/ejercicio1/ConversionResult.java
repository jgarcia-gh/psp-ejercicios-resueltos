package pconcurrente.practica1;

public class ConversionResult {

    private float value;
    private Unit unit;

    public ConversionResult(float value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}

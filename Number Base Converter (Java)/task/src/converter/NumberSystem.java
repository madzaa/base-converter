package converter;

public class NumberSystem {
    private int sourceBase;
    private int targetBase;
    private String targetNumber;

    public void setTargetNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }

    public void setSourceBase(int sourceBase) {
        this.sourceBase = sourceBase;
    }

    public void setTargetBase(int targetBase) {
        this.targetBase = targetBase;
    }

    public int getSourceBase() {
        return sourceBase;
    }

    public int getTargetBase() {
        return targetBase;
    }

    public String getTargetNumber() {
        return targetNumber;
    }

}

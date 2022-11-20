package tr.edu.mu.ceng.simplecalculator;

public class MockCalculatorListener implements CalculatorListener{

    private int result;

    public int getResult() {
        return result;
    }
    public void onResultCaculated(int result){
        this.result = result;
    }
}

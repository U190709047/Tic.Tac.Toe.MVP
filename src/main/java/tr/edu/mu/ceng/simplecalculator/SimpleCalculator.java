package tr.edu.mu.ceng.simplecalculator;

public class SimpleCalculator {

    Integer operand1;
    Integer operand2;
    String operator;

    CalculatorListener listener;

    public SimpleCalculator(CalculatorListener listener) {
        this.listener = listener;
    }

    public void setOperand(int value) {
        if (operand1 == null){
            operand1 = value;
        }else{
            operand2 = value;
        }

        if (operator == null)
            return;

        if (operator.equals("+"))
            operand1 += operand2;
        else if (operator.equals("-"))
            operand1 -= operand2;
        listener.onResultCaculated(operand1);

    }

    public void setOperator(String operator) {
        if(operator.equals("=")){
            operator = null;
            operand2 = null;
        }else
            this.operator = operator;
    }

    public void reset() {
        operand1 = null;
        operand2 = null;
        operand2 = null;
    }
}

package tr.edu.mu.ceng.simplecalculator;

import android.view.View;
import android.widget.Button;

public class Presenter  implements View.OnClickListener, CalculatorListener{
    CalculatorView calculatorView;
    SimpleCalculator simpleCalculator;

    boolean operatorExpected = false;
    boolean isFirstDigit = true;

    public Presenter(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        simpleCalculator = new SimpleCalculator(this);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        String symbol = btn.getText().toString();
        if (operatorExpected){
            if (symbol.equals("+") || symbol.equals("-") ){
                simpleCalculator.setOperand(Integer.parseInt(calculatorView.getNumber()));
                simpleCalculator.setOperator(symbol);
                isFirstDigit = true;
                return;
            }else if (symbol.equals("=")){
                simpleCalculator.setOperand(Integer.parseInt(calculatorView.getNumber()));
                simpleCalculator.setOperator(symbol);
                isFirstDigit = true;
                return;
            }
        }
        if(symbol.toLowerCase().equals("clear")){
            calculatorView.setNumber("");
            operatorExpected= false;
            isFirstDigit = true;
            simpleCalculator.reset();
        }else{
            if(isFirstDigit){
                calculatorView.setNumber(symbol);
                isFirstDigit = false;
                operatorExpected = true;
            }else{
                calculatorView.setNumber(calculatorView.getNumber()+symbol);
            }
        }

    }

    @Override
    public void onResultCaculated(int result) {
        calculatorView.setNumber(result + "");
    }
}

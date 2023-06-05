public class Calculator {

    private double addition(double numOne, double numTwo){
        return numOne + numTwo;
    }

    private double subtraction(double numOne, double numTwo){
        return numOne - numTwo;
    }

    private double multiplication(double numOne, double numTwo){
        return numOne * numTwo;
    }

    private double division(double numOne, double numTwo){
        return numOne / numTwo;
    }

    public double calculate(double numOne, double numTwo, char operator){
        switch (operator) {
            case '+':
                return addition(numOne,numTwo);
            case '-':
                return subtraction(numOne,numTwo);
            case '*':
                return multiplication(numOne,numTwo);
            case '/':
                return division(numOne,numTwo);
            default:
                return 0.0;
        }
    }
}

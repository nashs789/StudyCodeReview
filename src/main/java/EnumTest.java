package studyCodeReview;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EnumTest {
    enum Operator{
        PLUS("+", (op1, op2) -> op1 + op2),
        MINUS("-", (op1, op2) -> op1 - op2),
        MULT("*", (op1, op2) -> op1 * op2),
        DIV("/", (op1, op2) -> op1 / op2);

        private final String operator;
        private BiFunction<Integer, Integer, Integer> biF;

        private Operator(String operator, BiFunction<Integer, Integer, Integer> biF){
            this.operator = operator;
            this.biF = biF;
        }

        public String getOperator(){
            return this.operator;
        }

        public int calcurate(int operand1, int operand2){
            return biF.apply(operand1, operand2);
        }
    }

    public static void main(String[] args) {
        System.out.println(Operator.MINUS.name());
        
        for(Operator op : Operator.values()){
            System.out.println("op.name() = " + op.name());
            System.out.println("op.ordinal() = " + op.ordinal());
            System.out.println("op.operator = " + op.operator);
            System.out.println("##########################");
        }
        
        Operator op = Operator.MINUS;
        System.out.println("op.ordinal() = " + op.ordinal());
        System.out.println("op.name() = " + op.name());
    }
}

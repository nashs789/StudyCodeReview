/**
 *  [ 문자열 계산기 ]
 *
 *  문자열이 주어진다. 문자 구분은 “ “으로 할 수 있다.
 *  문자열 계산기는 기존의 계산과는 다르게 왼쪽에서 오른쪽으로 계산된다.
 *  Ex) “2 + 3 * 5” 결과 : 25
 *
 *  1. 문자열 계산 프로그램 만들기
 *  2. 객체지향적으로 코드를 짜는 것을 목표로 한다.
 *  3. Test 코드를 통해 검증할 것.
 */

package StringCalc;

import studyCodeReview.errorMsg;

import java.util.regex.Pattern;

public class StringCalc {
    static final Pattern numberPattern = Pattern.compile("^[0-9]*$");
    static final Pattern operatorPattern = Pattern.compile("^[+\\-*/]*$");

    public static void main(String[] args) throws Exception {
        // String expression = "2 + 3 * 5";
        String expression = "2 * 30 * 5 + 10 / 5 - 3 * 10";
        String[] expressionArr = expression.split(" ");
        int result = 0;

        isValidExpression(expressionArr);
        isValidExpressionLength(expressionArr);
        result = isResultZero(result, expressionArr);

        for(int idx = 2; idx < expressionArr.length; idx+=2){
            result = calculate(result, expressionArr[idx - 1].charAt(0), Integer.parseInt(expressionArr[idx]));
        }

        System.out.println("result = " + result);
    }

    public static int calculate(int result, char operator, int operand) throws Exception {
        switch(operator){
            case '+':
                result += operand;
                break;
            case '-':
                result -= operand;
                break;
            case '*':
                result *= operand;
                break;
            case '/':
                result /= operand;
                break;
            default:
                throw new Exception(errorMsg.code4);
        }

        return result;
    }

    // 문자열 검증 했으니 첫 문자는 숫자
    public static int isResultZero(int result, String[] str){
        if(result == 0){
            return result + Integer.parseInt(str[0]);
        }
        return 0; // 걍 위에서 리턴하고 끝내도 되는건데..
    }

    public static boolean isValidExpressionLength(String[] str) throws Exception{
         if(str.length % 2 == 0) {
             throw new Exception(errorMsg.code3);
         }
         return true;
    }

    public static boolean isValidExpression(String[] str) throws Exception {
        for(int idx = 0; idx < str.length; idx++){
            if(idx % 2 == 0){
                if(!Pattern.matches(numberPattern.pattern(), str[idx])){
                    throw new Exception(errorMsg.code1);
                }
            } else {
                if(!Pattern.matches(operatorPattern.pattern(), str[idx])){
                    throw new Exception(errorMsg.code2);
                }
            }
        }
        return true;
    }
}

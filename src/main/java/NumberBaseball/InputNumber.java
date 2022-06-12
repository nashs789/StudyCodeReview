package NumberBaseball;

import java.util.Scanner;

public class InputNumber {
    private final Scanner sc;

    InputNumber() {
        this.sc = new Scanner(System.in);
    }

    public int inputNumber(){
        return sc.nextInt();
    }

    public void start() {
        System.out.println("=========== game start ==========");
    }

    public void end(){
        System.out.println("=========== game over ==========");
    }
}

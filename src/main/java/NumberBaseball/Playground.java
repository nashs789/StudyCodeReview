package NumberBaseball;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Playground implements AutoCloseable {
    private final int comNumber;
    private final InputNumber inputNumber;
    private final String strike = "Strike";
    private final String ball = "Ball";
    private final String nothing = "Nothing";
    private final String homeRun = "Home run!!!";

    private int userNumber;
    private int strikeCnt;
    private int ballCnt;

    private Playground(int comNumber) throws Exception {
        this.comNumber = comNumber;
        inputNumber = new InputNumber();
        inputNumber.start();
    }

    public static Playground getPlaygroundInstance()throws Exception {
        return new Playground(setComNumber());
    }

    public void run() throws Exception {
       while(true){
           System.out.println("---------------------------------");
           System.out.print("값을 입력 하세요: ");

           userNumber = inputNumber.inputNumber();

           if(!(isValidValue(userNumber))){
                continue;
           }

           if(isHomerun(userNumber)){
               inputNumber.end();
               break;
           }

           howManyStrike();
           howManyBall();
           getResult();
       }
    }

    public boolean isValidValue(int userNumber){
        if(999 < userNumber || userNumber < 99 || (userNumber % 100) < 10 || ((userNumber % 100) % 10) == 0){
            System.out.println("값의 크기가 유효하지 않습니다.");
            return false;
        }

        return true;
    }

    public boolean isHomerun(int userNumber){
        if(userNumber == comNumber){
            System.out.println(homeRun);
            return true;
        }

        return false;
    }

    public static int setComNumber(){
        int[] arr = new int[3];
        HashMap<Integer, Integer> resultMap = new HashMap();
        
        for(int idx = 0; idx < arr.length; idx++){
            int randNum = (int)Math.floor((Math.random() * 9) + 1);
            if(!(resultMap.containsKey(randNum))){
                resultMap.put(randNum, randNum);
                arr[idx] = randNum;
                continue;
            }
            idx--;
        }
        //System.out.println(arr[0] * 100 + arr[1] * 10 + arr[2]);
        return arr[0] * 100 + arr[1] * 10 + arr[2];
    }

    public void howManyStrike(){
        int tempUserNumber = userNumber;
        int tempComNumber = comNumber;
        strikeCnt = 0;

        for(int idx = 3; idx > 0; idx--){
            if( (tempComNumber / pow(idx)) == (tempUserNumber / pow(idx)) ){
                strikeCnt++;
            }
            tempUserNumber = ((userNumber % pow(idx)));
            tempComNumber = ((comNumber % pow(idx)));
        }
    }

    public void howManyBall(){
        Map<Integer, Integer> map = new HashMap<>();
        int tempComNumber = comNumber;
        int tempUserNumber = userNumber;
        ballCnt = 0;

        for(int idx = 3; idx > 0; idx--){
            map.put((tempComNumber / pow(idx)), (tempComNumber / pow(idx)));
            tempComNumber = ((comNumber % pow(idx)));
        }

        for(int idx = 3; idx > 0; idx--){
            if(map.containsKey((tempUserNumber / pow(idx)))){
                ballCnt++;
            }

            tempUserNumber = ((userNumber % pow(idx)));
        }
    }

    public void getResult(){
        if(strikeCnt == 0 && ballCnt == 0){
            System.out.println(nothing);
            return;
        }
        System.out.println(strikeCnt + strike + " " + (ballCnt - strikeCnt) + " " + ball);
    }

    // 10 제곱 반환 메소드 ( 인덱스가 0부터 시작이라 -1 해줘야함 )
    public int pow(int idx){
        return (int) Math.pow(10, idx - 1);
    }

    @Override
    public void close() throws IOException {

    }
}

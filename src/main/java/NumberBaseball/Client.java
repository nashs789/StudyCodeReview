/**
 *  [ 숫자야구게임 ]
 *
 *  1. 같은 수가 같은 자리에 있으면 Strike, 다른 자리에 있으면 Ball, 전혀 없으면 Four Ball or Nothing
 *  ( 정해진 숫자 - 456 / 입력된 숫자 516 - 1Strike 1Ball )
 *  2. 상대방 역활은 컴퓨터로 양방향이 아닌 컴퓨터가 수비, 유저가 공격으로 역활을 수행한다.
 *  3. 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
 *  4. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
 *
 *  [ 요구사항 ]
 *  1. 들여쓰기는 4 spaces
 *  2. 들여쓰기 depth 가 2를 넘지 않도록 한다. ex) for문 안에 if문 -> depth 2
 *  3. 모든 로직에 단위 테스트를 구현한다. ( UI 제외 )
 *  4. 3항 연산자를 쓰지 않는다.
 *  5. else 예약어를 쓰지 않는다. ( switch case도 제외 )
 */

package NumberBaseball;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int answer;

        while(true){
            try(Playground pg = Playground.getPlaygroundInstance()){
                pg.run();
            } catch (Exception e){
                System.out.println("허용되지 않은 작업입니다.");
            } finally{
                System.out.println("게임을 계속 하시겠습니까? 계속(9) 종료(0)");
                answer = sc.nextInt();
                if(answer == 0){
                    break;
                }
            }
        }
    }
}


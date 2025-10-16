package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        char[] sign = new char[444];
        sign[0] = ','; sign[1] = ':';
        int sum = 0;

        for(int i = 0, sign_idx = 2; i < str.length(); i++) {
            for(int j = 0; j < sign_idx; j++) {
                if(str.charAt(i) == sign[j]) {
                    sum += str.charAt(i-1)-'0';
                    if(i == str.length()-2) sum += str.charAt(i+1)-'0';
                    i++;
                    break;
                }
            }
        }

        System.out.println("결과 : " + sum);
    }
}


package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        char[] sign = new char[444];
        sign[0] = ','; sign[1] = ':';
        int sum = 0, i = 0, sign_idx = 2;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        int back_idx = str.indexOf("\\n");

        //커스텀 구분자 추가
        if(back_idx != -1) {
            for(i = 2; i < back_idx; i++) {
                sign[sign_idx++] = str.charAt(i);
            }
            i = back_idx+2;
        }

        //기본으로 값을 더해주는 루프문
        for(; i < str.length(); i++) {
            //숫자가 들어오는 경우
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                //숫자가 연속으로 들어오는 경우 예외 처리
                if(i > 0 && str.charAt(i-1) >= '0' && str.charAt(i-1) <= '9')
                    throw new IllegalArgumentException("숫자를 연속으로 입력할 수 없습니다.");

                // 마지막 문자가 숫자인 경우 더해주기
                if(i == str.length()-1)
                    sum += str.charAt(i) - '0';
                continue;
            }

            for(int j = 0; j < sign_idx; j++) {
                if(str.charAt(i) == sign[j]) {
                    sum += str.charAt(i-1)-'0';
                    break;
                }
                //구분자가 아닌 문자가 들어오는 경우 예외 처리 (break가 안 걸린 경우)
                throw new IllegalArgumentException("올바르지 않은 문자열입니다.");
            }
        }

        System.out.println("결과 : " + sum);
    }
}


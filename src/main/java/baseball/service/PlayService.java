package baseball.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayService {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ERROR_MESSAGE = "입력한 숫자를 확인해주세요. (1~9 사이의 서로 다른 3자리 숫자)";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public boolean playGame(List<Integer> answer) {
        String input = null;

        do {
            System.out.print(INPUT_MESSAGE);
            input = Console.readLine();
            validateAnswer(input);
        } while(!getResult(answer, input));

        return isContinueGame();
    }

    public void validateAnswer(String input) {
        validateLength(input); // 4자리 이상 입력
        validateContainZero(input); // 0 포함
        validateRepeatedNum(input); // 중복된 숫자
        validateNonNum(input); // 숫자 외 입력값 포함
    }

    public boolean getResult(List<Integer> answer, String input) {
        int ballCount = 0;
        int strikeCount = 0;

        for(int i=0; i<answer.size(); i++) {
            ballCount += checkBall(answer, input, i);
            strikeCount += checkStrike(answer, input, i);
        }

        return checkAnswer(ballCount, strikeCount);
    }

    public boolean isContinueGame() {
        System.out.println(END_MESSAGE);
        System.out.println(RESTART_MESSAGE);

        if(Console.readLine().equals("1")) {
            return true;
        }

        return false;
    }

    private void validateLength(String input) {
        if(input.length() > 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validateContainZero(String input) {
        if(input.contains("0")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validateRepeatedNum(String input) {
        Set<Character> charSet = new HashSet<>();
        char[] chars = input.toCharArray();

        for(char c : chars) {
            charSet.add(c);
        }

        if(charSet.size() < 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validateNonNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private int checkBall(List<Integer> answer, String input, int index) {
        Integer value = Integer.valueOf(input.substring(index, index + 1));

        if(value != answer.get(index) && answer.contains(value)) {
            return 1;
        }
        return 0;
    }

    private int checkStrike(List<Integer> answer, String input, int index) {
        Integer value = Integer.valueOf(input.substring(index, index + 1));

        if(value == answer.get(index)) {
            return 1;
        }
        return 0;
    }

    private boolean checkAnswer(int ball, int strike) {
        if(strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }

        printHint(ball, strike);
        return false;
    }

    private void printHint(int ball, int strike) {
        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }

        if(ball > 0) {
            System.out.printf("%d볼 ", ball);
        }

        if(strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }

        System.out.println();
    }
}

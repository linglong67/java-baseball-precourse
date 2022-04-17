package baseball.service;

import java.util.HashSet;
import java.util.Set;

public class PlayService {
    public static final String ERROR_MESSAGE = "입력한 숫자를 확인해주세요. (1~9 사이의 서로 다른 3자리 숫자)";

    public boolean validateAnswer(String input) {
        validateLength(input); // 4자리 이상 입력
        validateContainZero(input); // 0 포함
        validateRepeatedNum(input); // 중복된 숫자
        validateNonNum(input); // 숫자 외 입력값 포함

        return true;
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

    public boolean checkAnswer(String input) {
        return false;
    }
}

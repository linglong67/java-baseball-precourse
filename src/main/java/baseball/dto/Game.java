package baseball.dto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    public Game() {
        Set<Integer> number = new HashSet<>();
        do {
            number.add(Randoms.pickNumberInRange(1, 9));
        } while (number.size() < 3);

        this.answer = number;
    }

    private Set<Integer> answer;
    private String returnMessage;
}

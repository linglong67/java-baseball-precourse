package baseball.dto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Game {

    public Game() {
        Set<Integer> answer = new LinkedHashSet<>();

        do {
            answer.add(Randoms.pickNumberInRange(1, 9));
        } while (answer.size() < 3);

        this.answer = new ArrayList<>(answer);
    }

    private List<Integer> answer;

    public List<Integer> getAnswer() {
        return answer;
    }
}

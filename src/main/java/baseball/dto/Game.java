package baseball.dto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {

    public Game() {
        Set<Integer> answer = new LinkedHashSet<>();

        do {
            answer.add(Randoms.pickNumberInRange(1, 9));
        } while (answer.size() < 3);

        this.answer = new ArrayList<>(answer);
    }

    private List<Integer> answer;
    private String returnMessage;

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}

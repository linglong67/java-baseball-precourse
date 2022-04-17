package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import baseball.service.PlayService;

public class PlayController {
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private PlayService playService = new PlayService();

    public boolean play() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();

        if(playService.validateAnswer(input)) {

        }

        return false; // 임시
    }

}

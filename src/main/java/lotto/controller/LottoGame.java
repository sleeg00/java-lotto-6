package lotto.controller;

import static lotto.domain.User.DIVIDE_NUMBER;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private List<Lotto> lotto = new ArrayList<>();
    private long purchaseAmount;
    private InputView inputView;
    private OutputView outputView;
    private User user;

    public LottoGame(InputView inputView, OutputView outputView, User user) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.user = user;
    }

    public void start() {
        purchaseAmount();
    }

    private void purchaseAmount() {
        outputView.purchaseAmount();
        while (true) {
            String input = inputView.purchaseAmount();
            try {
                user.setPurchaseAmount(input);
                purchaseAmount = user.getPurchaseAmount() / DIVIDE_NUMBER;
                outputView.printPurchaseAmount(purchaseAmount);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

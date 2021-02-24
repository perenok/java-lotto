package lotto.controller;

import lotto.domain.*;
import lotto.utils.AutoLottoGenerator;
import lotto.utils.FixedLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    private final LottoGame lottoGame = new LottoGame();

    public void run() {
        Money money = InputView.askMoney();
        LottoQuantity lottoQuantity = InputView.askLottoQuantity(money);
        buyLotto(lottoQuantity);

        Lotto lotto = InputView.askLastWinningLotto();
        WinningLotto lastWinningLotto = createLastWinningLotto(lotto);
        showLottoGameResult(lastWinningLotto);
    }

    private void buyLotto(LottoQuantity lottoQuantity) {
        buyFixedLotto(lottoQuantity);
        buyAutoLotto(lottoQuantity);
    }

    private void buyFixedLotto(LottoQuantity lottoQuantity) {
        int fixedLottoQuantity = lottoQuantity.getFixedLottoQuantity();
        List<String> fixedLottoNumbersBundle = InputView.askFixLottoNumbersBundle(fixedLottoQuantity);
        Money fixedLottoPrice = lottoQuantity.calculateFixedLottoPrice();
        try{
            lottoGame.buyLottos(fixedLottoPrice, new FixedLottoGenerator(fixedLottoNumbersBundle));
        } catch (Exception e){
            OutputView.printError(e);
            lottoGame.clear();
            buyFixedLotto(lottoQuantity);
        }
    }

    private void buyAutoLotto(LottoQuantity lottoQuantity) {
        Money fixedLottoPrice = lottoQuantity.calculateAutoLottoPrice();
        lottoGame.buyLottos(fixedLottoPrice, new AutoLottoGenerator());
        OutputView.printEachLotto(lottoGame.myLottos());
    }

    private WinningLotto createLastWinningLotto(Lotto lotto) {
        LottoNumber bonusNumber = createBonusNumber();
        try {
            return new WinningLotto(lotto, bonusNumber);
        } catch (Exception e) {
            OutputView.printError(e);
            return createLastWinningLotto(lotto);
        }
    }

    private LottoNumber createBonusNumber() {
        try {
            return InputView.askBonusNumber();
        } catch (Exception e) {
            OutputView.printError(e);
            return createBonusNumber();
        }
    }

    private void showLottoGameResult(WinningLotto lastWinningLotto) {
        LottoGameResult lottoGameResult = lottoGame.calculateLottoGameResult(lastWinningLotto);
        OutputView.printLottoGameResult(lottoGameResult);
    }
}

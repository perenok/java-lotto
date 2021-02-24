package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoQuantity;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView(){
    }

    public static Money askMoney() {
        OutputView.printMessage("구입 금액을 입력해 주세요.");
        String money = scanner.nextLine();
        try {
            return new Money(money);
        } catch (Exception e) {
            OutputView.printError(e);
            return askMoney();
        }
    }

    public static LottoQuantity askLottoQuantity(Money money) {
        OutputView.printMessage("수동으로 구매할 로또 수를 입력해 주세요.");
        String fixedLottoCount = scanner.nextLine();
        try {
            return new LottoQuantity(money, fixedLottoCount);
        } catch (Exception e) {
            OutputView.printError(e);
            return askLottoQuantity(money);
        }
    }

    public static List<String> askFixLottoNumbersBundle(int fixedLottoQuantity) {
        OutputView.printMessage("수동으로 구매할 번호를 입력해 주세요.");
        List<String> FixLottoNumbersBundle = new ArrayList<>();
        for(int i = 0; i < fixedLottoQuantity; i++){
            FixLottoNumbersBundle.add(scanner.nextLine());
        }
        return FixLottoNumbersBundle;
    }

    public static Lotto askLastWinningLotto() {
        OutputView.printMessage("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        try {
            return new Lotto(createWinningLottoNumbers(input));
        } catch (Exception e) {
            OutputView.printError(e);
            return askLastWinningLotto();
        }
    }

    private static List<LottoNumber> createWinningLottoNumbers(String input) {
        List<String> splitNumbers = Arrays.asList(input.split(","));
        return splitNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }


    public static LottoNumber askBonusNumber() {
        OutputView.printMessage("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.nextLine();
        try {
            return new LottoNumber(bonusNumber);
        } catch (Exception e) {
            OutputView.printError(e);
            return askBonusNumber();
        }
    }
}

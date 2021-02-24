package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public void clear(){
        lottos.clear();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoGameResult compareWithWinningLotto(WinningLotto winningLotto) {
        LottoGameResult lottoGameResult = new LottoGameResult();
        lottos().stream()
                .map(winningLotto::findRank)
                .forEach(lottoGameResult::add);
        return lottoGameResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}

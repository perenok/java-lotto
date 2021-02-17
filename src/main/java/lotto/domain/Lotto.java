package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto() {
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public boolean containNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public int countOfMatchNumber(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::containNumber)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "lottoNumbers = " + lottoNumbers;
    }
}

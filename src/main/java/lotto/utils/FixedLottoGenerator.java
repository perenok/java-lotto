package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.AutoLottoGenerator.FROM_INDEX;

public class FixedLottoGenerator implements LottoGenerator {

    private final List<List<LottoNumber>> numbers2 = new ArrayList<>();

    public FixedLottoGenerator(List<String> fixedLottoNumbers) {
        numbers2.addAll(createFixedNumbersBundle(fixedLottoNumbers));
    }

    private List<List<LottoNumber>> createFixedNumbersBundle(List<String> input) throws IllegalArgumentException {
        List<String> splitNumbers = new ArrayList<>();
        List<List<LottoNumber>> fixedNumbersBundle = new ArrayList<>();
        for (String s : input) {
            splitNumbers.addAll(Arrays.asList(s.split(",")));
            fixedNumbersBundle.add(splitNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
            splitNumbers.clear();
        }
        return fixedNumbersBundle;
    }

    @Override
    public Lotto generate() throws IllegalArgumentException {
        List<LottoNumber> lottoNumbers = numbers2.get(FROM_INDEX);
        numbers2.remove(FROM_INDEX);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
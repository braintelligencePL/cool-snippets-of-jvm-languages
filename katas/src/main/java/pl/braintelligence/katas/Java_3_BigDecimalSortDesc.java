package pl.braintelligence.katas;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Java_3_BigDecimalSortDesc {

    public List<BigDecimal> sortNumbersDescending(List<BigDecimal> numbers) {
        numbers.sort(Collections.reverseOrder());
        return numbers;
    }

}

package str;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringCalculator {

  private static final String EMPTY_STRING = "";
  private static final String SEP_COMMA = ",";
  private static final String SEP_ENTER = "\n";

  // 이 메서드는 구분된 0개, 1개 또는 2개의 숫자를 입력받아
  // 그 합을 반환합니다.
  public int add(String numbers) {
    if (EMPTY_STRING.equals(numbers)) {
      return 0;
    }

    List<Integer> parsedNumbers = parseNumbers(numbers);
    validateNoNegatives(parsedNumbers);

    return sum(parsedNumbers);
  }

  private int sum(List<Integer> numbers) {
    return numbers.stream()
        .mapToInt(Integer::intValue)
        .sum();
  }

  private List<Integer> parseNumbers(String numbers) {

    String normalized = normalize(numbers);
    String[] tokens = normalized.split(SEP_COMMA);

    List<Integer> result = new ArrayList<>();
    for (String token : tokens) {
      result.add(Integer.parseInt(token));
    }

    return result;
  }

  private void validateNoNegatives(List<Integer> numbers) {
    List<Integer> negatives = new ArrayList<>();

    for (int i = 0; i < numbers.size(); i++) {
      int target = numbers.get(i);

      if (target < 0) {
        negatives.add(target);
      }
    }

    if (!negatives.isEmpty()) {
      StringBuilder sb = new StringBuilder("negatives not allowed: ");
      for (int i = 0; i < negatives.size(); i++) {
        sb.append(negatives.get(i));
        if (i < negatives.size() - 1) {
          sb.append(", ");
        }
      }

      throw new IllegalArgumentException(sb.toString());
    }
  }

  private String normalize(String input) {
    if (input.startsWith("//")) {
      int newLineIndex = input.indexOf("\n");
      String customDelimiter = input.substring(2, newLineIndex);
      input = input.substring(newLineIndex + 1);

      input = input.replace(customDelimiter, SEP_COMMA);
    }

    return input.replace(SEP_ENTER, SEP_COMMA);
  }

}

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import str.StringCalculator;

public class StringCalTest {

  StringCalculator cal = null;

  @BeforeEach
  void setUp() {
    cal = new StringCalculator();
  }

  @Test
  @DisplayName("빈 문자열 입력시 0 반환")
  void test1() {
    String emptyString = "";

    assertThat(cal.add(emptyString)).isEqualTo(0);
  }

  @Test
  @DisplayName("숫자 한개를 입력 받으면 해당 숫자가 출력 된다")
  void test2() {
    String oneStr = "1";
    String twoStr = "2";

    assertThat(cal.add(oneStr)).isEqualTo(1);
    assertThat(cal.add(twoStr)).isEqualTo(2);
  }

  @Test
  @DisplayName("숫자 두개를 입력 받으면 두 숫자의 합이 출력 된다")
  void test3() {
    String str = "1,2";

    assertThat(cal.add(str)).isEqualTo(3);
  }

  @Test
  @DisplayName("n개의 숫자를 입력 받으면 숫자들의 합이 출력 된다")
  void test4() {
    String str = "1,2,3,4,5";

    assertThat(cal.add(str)).isEqualTo(15);
  }

  @Test
  @DisplayName("줄바꿈 문자(\n)도 허용하게 한다")
  void test5() {
    String str = "1\n2";
    String str2 = "1\n2\n3";

    assertThat(cal.add(str)).isEqualTo(3);
    assertThat(cal.add(str2)).isEqualTo(6);
  }

  @Test
  @DisplayName("쉼표(,)와 줄바꿈(\n)이 함께 섞여 있어도 정상적으로 합산된다")
  void test6() {
    String str = "1\n2,3";

    assertThat(cal.add(str)).isEqualTo(6);
  }

  @Test
  @DisplayName("커스텀 구분자를 지원")
  void test7() {
//   "//[delimiter]\n[numbers…]";
    String str = "//;\n1;2";

    assertThat(cal.add(str)).isEqualTo(3);
  }

  @Test
  @DisplayName("음수 처리 (예외 발생)")
  void test8() {
    String str = "1,4,-1,-2,-3";

    assertThatThrownBy(() -> cal.add(str))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("negatives not allowed: -1, -2, -3");
  }
}

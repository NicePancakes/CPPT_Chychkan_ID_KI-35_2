package Lab4;

public class CalcException extends ArithmeticException {
  public CalcException() {
  }

  public CalcException(String cause) {
    // String prefix = cause.startsWith("[1]", 0)
    //     ? "first prefix"
    //     : cause.startsWith("[2]", 0)
    //         ? "second prefix"
    //         : cause.startsWith("[3]", 0)
    //             ? "third prefix"
    //             : "unknown prefix";

    super("[ cause ] " + cause);
  }
}

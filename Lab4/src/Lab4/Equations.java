package Lab4;

import java.io.FileNotFoundException;

public class Equations {

  public double calculate(double x) throws CalcException {
    double res;
    try {
      res = Math.tan(2 * x);

      if (res == 0) {
        throw new ArithmeticException("[1] value in devider (tan(2 * x)) is 0");
      }

      if (Double.isNaN(res) || Double.isInfinite(res)) {
        throw new ArithmeticException("[2] value in devider (tan(2 * x)) is not valid");
      }

      res = 1 / res;

      if (Double.isNaN(res) || Double.isInfinite(res)) {
        throw new ArithmeticException("[3] result value is not valid");
      }
    } catch (ArithmeticException e) {
      throw new CalcException(e.getMessage());
    }

    return res;
  }
}

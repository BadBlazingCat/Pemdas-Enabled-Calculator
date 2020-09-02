
public class Operation {
  private String operationType;
  private int priority;

  public Operation(String operationType, int priority) {
    this.operationType = operationType;
    this.priority = priority;
  }

  public double runOperation(double num1, double num2) {
    if (operationType.equals("add")) {
      return (num1 + num2);
    } else if (operationType.equals("subtract")) {
      return (num1 - num2);
    } else if (operationType.equals("multiply")){
      return (num1 * num2);
    } else if (operationType.equals("divide")){
      // TODO: throw exception and use try-catch if dived by 0
      return (num1 / num2);
    } else {
      return(-1);
    }
  }

  public String getOperationType() {
    return (operationType);
  }

  public int getPriority() {
    return (priority);
  }
}

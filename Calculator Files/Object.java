
public class Object{
  private double number;
  private Operation op;

  public Object(double number, Operation op){
    this.number = number;
    this.op = op;
  }

  public double getNumber(){
    return (number);
  }

  public void setNumber(double number){
    this.number = number;
  }

  public Operation getOperation(){
    return (op);
  }
}
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
  public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      //the main logic behind the program instantiated
      Calculator calc = new Calculator();
      boolean continueCalculations = true;
      
      while (continueCalculations){
       
        System.out.println("Enter Calculations: " );
        String calculationsLineString = in.next();
        //ArrayList<String> numbersArray = Arrays.asList(calculationsLineString.split("[+-*/]")); does not work for some reason
        ArrayList<String> tempArray = new ArrayList<>(Arrays.asList(calculationsLineString.split("[ +\\-\\*/]")));

        //Convert String ArrayList to Double ArrayList
        ArrayList<Double> numbersArray = new ArrayList<>();
        for(int i = 0; i < tempArray.size(); i++){
          numbersArray.add(i, Double.valueOf(tempArray.get(i)));
        }

        //Keeps track of the index we are on in the actual String the user inputed
        int tempIndexString = 0;

        //Keeps track the index we are currently on in the ArrayList of Numbers invovled in the actual String the user inputed
        int tempIndexArray = 0;

        //Basically converting the occurance of operations in the acutal string the user inputed to instances of the Object class. These objects are then stored in an array within the Calculator instance

        while(tempIndexString < calculationsLineString.length()){
          if(calculationsLineString.charAt(tempIndexString) == '+'){         
            Operation op = new Operation("add", 2);
            Object obj = new Object(numbersArray.get(tempIndexArray), op);
            calc.addToList(obj);
            tempIndexArray++;
          }
          else if (calculationsLineString.charAt(tempIndexString) == '-'){
            Operation op = new Operation("subtract", 3);
            Object obj = new Object(numbersArray.get(tempIndexArray), op);
            calc.addToList(obj);
            tempIndexArray++;
          }
          else if (calculationsLineString.charAt(tempIndexString) == '*'){
            Operation op = new Operation("multiply", 0);
            Object obj = new Object(numbersArray.get(tempIndexArray), op);
            calc.addToList(obj);
            tempIndexArray++;
          }
          else if (calculationsLineString.charAt(tempIndexString) == '/'){
            Operation op = new Operation("divide", 1);
            Object obj = new Object(numbersArray.get(tempIndexArray), op);
            calc.addToList(obj);
            tempIndexArray++;
          }
          tempIndexString++;    
        }
        calc.addToList(new Object(numbersArray.get(tempIndexArray), null));
        

        System.out.println(calc.calculate());

        System.out.println("Do you want to continue? (Type a character or 'No')");
        String answer = in.next();
        if (answer.equals("No")){
          continueCalculations = false; 
        }
        calc.clearList();
      }
      
  }
}
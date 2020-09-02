/**
 * Write a description of class Calculator here.
 *
 * @author Anu Soneye
 * @version 01
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator
{
  private static final String[][] priorityList = {{"multiply", "divide"},
                                                  { "add", "subtract"}};
  private  ArrayList<Object> mainObjectArray;

  public Calculator(){
    mainObjectArray = new ArrayList<>();
  }

  public void addToList(Object obj){
    mainObjectArray.add(obj);
  }

  public void removeFromList(Object obj){
    mainObjectArray.remove(obj);
  }

  public void printList(){
    for (Object obj : mainObjectArray){
      if (obj.getOperation() != null){
        System.out.println(obj.getNumber() + ", " + obj.getOperation().getOperationType());
      }
      else{
        System.out.println(obj.getNumber() + ", null");
      }
    }
  }

  public void clearList(){
   mainObjectArray.clear();
  }

  public double calculate(){
    for (int j = 0; j < priorityList.length; j++){
      for (int i = 0; i < (mainObjectArray.size()-1); i++){
        Object currentObj = mainObjectArray.get(i);
        Object nextObj = mainObjectArray.get(i+1);
        if (Arrays.binarySearch(priorityList[j], currentObj.getOperation().getOperationType()) != -1){
          for (Object obj : mainObjectArray){
    }
          double result = currentObj.getOperation().runOperation(currentObj.getNumber(), nextObj.getNumber());
          nextObj.setNumber(result);
          mainObjectArray.remove(currentObj);
          i--;
        }
      }
    }
    return(mainObjectArray.get(0).getNumber());
  }
 

}



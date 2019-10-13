/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author Dalibor
 */
public class Operations {
    
    private static Operations operations;

    public Operations() {
    }
    
    public static Operations getInstance(){
        if (operations == null) {
            operations = new Operations();
        }
        return operations;
    }
    
    public static int doOperation(int a, int b, String operator) {
        
        if(operator.equals("+")){
            return a + b;
        } else if(operator.equals("-")){
            return a - b;
        }
        
        return -1;
    }
}

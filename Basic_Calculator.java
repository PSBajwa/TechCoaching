import java.util.Scanner;

public class Basic_Calculator {

    static String[] calculatorOptions ={"Addition", "Subtraction", "Multiplication", "Division"};
    
    private double doAddition(double numX, double numY)
    {
        return numX + numY;
    }
    private double doSubtraction(double numX, double numY)
    {
        return numX - numY;
    }
    private double doMultiplication(double numX, double numY)
    {
        return numX *  numY;
    }
    private double doDivision(double numX, double numY)
    {
        return numX / numY;
    }
    public void displayCalculatorMenu()
    {
        for (int i = 0; i < calculatorOptions.length; i++)
        {
            System.out.println((i+1) + ". " + calculatorOptions[i]);
        }
        System.out.print("Please enter your choice: ");
    }
    public boolean initiateCalculation(int menuChoice)
    {
        if (menuChoice>=1 && menuChoice<=calculatorOptions.length)
        {
            System.out.println("Proceed with : " + calculatorOptions[menuChoice-1]);
            return true;
        } else {
            System.out.print("Please enter a valid option : ");
            return false;
        }

    }
    public double executeCalculation(int calculationChoice, double numX, double numY)
    {
        switch(calculationChoice) {
            case 1:
            return doAddition(numX, numY);
            case 2:
            return doSubtraction(numX, numY);
            case 3:
            return doMultiplication(numX, numY);
            case 4:
            return doDivision(numX, numY);
            default:
            return 0.0d;
        }    
    }
    public double verifyInput(String inputValue)
    {
        double vInput = -0.0d;
        if (inputValue == null) {
            return vInput;
        }
        try {
              vInput = Double.parseDouble(inputValue);
        } catch (NumberFormatException nfe) {
            return vInput;
        }
        return vInput;
    }
    public static void main(String[] args) {
        Basic_Calculator myCalculator = new Basic_Calculator();
        Scanner scanUserInput = new Scanner(System.in);  // Create a Scanner object
        boolean startCalculation = false;
        boolean verifyNum = false;
        String choice = "0";
        int choiceNum = 0;
        double numX = 0.0d, numY = 0.0d;
        
        myCalculator.displayCalculatorMenu();
                
        while (!startCalculation)
        {   
            choice = scanUserInput.nextLine(); // Read user input
            choiceNum = (int)myCalculator.verifyInput(choice);
            startCalculation = myCalculator.initiateCalculation(choiceNum);
        }

        System.out.print("Please enter first number: ");
        while (!verifyNum)
        {
        numX = myCalculator.verifyInput(scanUserInput.nextLine());
        verifyNum = true;
        if (numX == -0.0d)
        {
            System.out.print("Please enter a valid number : ");
            numX = 0.0d;
            verifyNum = false;
        }
        }
        
        verifyNum = false;
        System.out.print("Please enter second number: ");
        while (!verifyNum)
        {
        numY = myCalculator.verifyInput(scanUserInput.nextLine());
        verifyNum = true;
        if (numY == -0.0d)
        {
            System.out.print("Please enter a valid number : ");
            numY = 0.0d;
            verifyNum = false;
        }
        }
        
        System.out.println("The result of calculation is: " + myCalculator.executeCalculation(choiceNum, numX, numY));
        scanUserInput.close();
      }

}
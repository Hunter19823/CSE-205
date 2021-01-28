package projects.examples.polymorphism;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtilities {
    private final Scanner scanner;
    public ScannerUtilities(){
        scanner = new Scanner(System.in);
    }

    public void close(){
        scanner.close();
    }

    public <TYPE> int promptChoiceOrUnknown(String prompt, TYPE[] choices)
    {
        int unknownType = choices.length;
        for(int i=0; i<choices.length;i++){
            prompt += "\n"+i+". "+choices[i];
        }
        prompt += "\n"+unknownType+". Not listed.";
        while(true){
            int response = promptInt(prompt);
            if(response < 0 || response > unknownType)
                continue;
            return response;
        }
    }

    public boolean promptBoolean(String prompt)
    {
        // Loop until scanner returns a value.
        while(true)
        {
            System.out.println(prompt+"(True/False)");
            try{
                // Attempt to scan and return a response.
                return scanner.nextBoolean();
            }catch(InputMismatchException exception){
                // Tell them their input is not valid.
                System.out.println("Please only type either True or False.");
                // Skip over their last answer since it is no valid.
                scanner.next();
            }
        }
    }
    public int promptInt(String prompt)
    {
        // Loop until scanner returns a value.
        while(true)
        {
            System.out.println(prompt);
            try{
                // Attempt to scan and return a response.
                return scanner.nextInt();
            }catch(InputMismatchException exception){
                // Tell them their input is not valid.
                System.out.println("Please type a valid Integer");
                // Skip over their last answer since it is no valid.
                scanner.next();
            }
        }
    }
    public String prompt(String string)
    {
        System.out.println(string);
        String out = scanner.nextLine();
        while(out.length() == 0)
            out = scanner.nextLine();
        return out;
    }
}

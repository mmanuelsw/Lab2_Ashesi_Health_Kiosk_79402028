
// Kwasi Bekae Ackonor
// 79402028
// Ashesi Health Kiosk

import java.util.Scanner;

public class HealthKiosk {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Ashesi Health Kiosk!");
        double metric = 0;
        double bmi = 0; // declared outside so Task 5 can access it
        double roundedBmi = 0; // moved outside so Task 5 can access it


        // Task 1 - Service Router (focus:switch)

        // Taking user input,
        System.out.println("Enter service code (P/L/T/C): ");
        char userServiceCode = input.nextLine().toUpperCase().charAt(0);

        // Using switch statements to print.
        String goToStatement;

        switch (userServiceCode) {
            case 'P':
            goToStatement = "Pharmacy";
            break;

            case 'L':
            goToStatement = "Lab";
            break;

            case 'T':
            goToStatement = "Triage";
            break;

            case 'C':
            goToStatement = "Counseling";
            break;
            
            default:
            goToStatement = "Invalid service code.";

        }
        
        // Displaying output
        System.out.println("Go to: " + goToStatement);



        // Task 2 - Mini Health Metric
        System.out.println("Enter health metric: "
         + "(1 for BMI\n"
         + "2 for Dosage round-up\n" 
         + "3 for simple trig helper)");
         int userHealthMetric = input.nextInt();


        //  Using switch statements to determine process.
        switch (userHealthMetric){


            // OPTION A
            case 1:
            System.out.println("Enter weight (kg): ");
            double userWeightInKilograms = input.nextDouble();

            System.out.println("Enter height (m): ");
            double userHeightInMeters = input.nextDouble();


            // Computing BMI
            bmi = userWeightInKilograms / Math.pow(userHeightInMeters,2);
            roundedBmi = Math.round(bmi * 10) / 10.0;


            // Using if/else as a simplified category
            String bmiCategory;

            if (roundedBmi < 18.5){
                bmiCategory = "Underweight";
            }
            else if (roundedBmi >= 18.5 && roundedBmi <= 24.9){
                bmiCategory = "Normal";
            }
            else if (roundedBmi >= 25.0 && roundedBmi <= 29.9){
                bmiCategory = "Overweight";
            }
            else{
                bmiCategory = "Obese";
            }

            System.out.println("BMI: " + roundedBmi + " Category: " + bmiCategory);
            metric = roundedBmi;
            break;

           

            // OPTION B
            case 2:
            System.out.println("Enter the required dosage in mg: ");
            double userDosage = input.nextDouble();

            // Computation for tablets 
            double numberOfTablets = Math.ceil(userDosage / 250);
                        
            // Displaying number of tablets
            System.out.println("The number of tablets to be taken is " + (int)numberOfTablets);
            metric = numberOfTablets;
            break;


            
            // OPTION C
            case 3:
            System.out.println("Enter an angle in degrees: ");
            double userAngle = input.nextDouble();

            // Converting angle to radians
            double radians = Math.toRadians(userAngle);

            // Computation for sin and cos
            double sinAngle = Math.round(Math.sin(radians) * 1000)/ 1000.0;
            double cosAngle = Math.round(Math.cos(radians) * 1000)/ 1000.0;

            
            // Displaying sin and cos angles
            System.out.println("The sin of the angle is " + sinAngle );
            System.out.println("The cos of the angle is " + cosAngle );
            metric = radians;

            break;

            
            default:
            System.out.println("Invalid user input!");

        }




        // TASK 3 - ID Sanity Check

        // Generating a random character
        char letter = (char)('A' + (int) (Math.random() * 26));

        // Generating 4 random numbers
        int firstNumber = (int) (Math.random()* (9 - 3 + 1) + 3);
        int secondNumber = (int) (Math.random()* (9 - 3 + 1) + 3);
        int thirdNumber = (int) (Math.random()* (9 - 3 + 1) + 3);
        int fourthNumber = (int) (Math.random()* (9 - 3 + 1) + 3);

        String ID = "" + letter + firstNumber + secondNumber + thirdNumber + fourthNumber;

        if (ID.length() == 5 
        && Character.isLetter(ID.charAt(0)) 
        && Character.isDigit(ID.charAt(1)) 
        && Character.isDigit(ID.charAt(2)) 
        && Character.isDigit(ID.charAt(3)) 
        && Character.isDigit(ID.charAt(4))) {
            System.out.println("ID OK");
}
else {
    System.out.println(" Invalid: first char must be a letter, Invalid: last 4 must be\r\n" + //
                "digits, or Invalid length");
}



    // TASK 4 - secure Display Code
    input.nextLine(); // clear buffer after nextInt()
    System.out.println("Enter your first name: ");
    String first_name = input.nextLine();

    // Taking the first letter of the name
    char first_letter = Character.toUpperCase(first_name.charAt(0));
    char shiftedLetter = (char) ('A' + (first_letter - 'A' + 2) % 26);
    String lastTwo = ID.substring(ID.length() - 2);
    String Code = "" + shiftedLetter + lastTwo + "-" + Math.round(metric);

    System.out.println("Generated Code: " + Code);



    // TASK 5 - Service Summary
    if (userServiceCode == 'P') {
        System.out.println("PHARMACY | ID=" + ID + " | Code= " + Code);
    }
    else if (userServiceCode == 'L') {
        System.out.println("LAB | ID=" + ID + " | Code= " + Code);
    }
    else if (userServiceCode == 'T'){
        System.out.println("TRIAGE | ID=" + ID + " | BMI=" + roundedBmi + " | Code= " + Code);
    }
    else if (userServiceCode == 'C'){
        System.out.println("COUNSELING | ID=" + ID + " | Code= " + Code);
    }

    
    }
    
}

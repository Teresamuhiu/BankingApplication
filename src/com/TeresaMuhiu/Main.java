package com.TeresaMuhiu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //to run this application create an object of BankAccount
        //pass two values in its constructor
        BankAccount objectOne = new BankAccount("Customer", "AB001");
        objectOne.showMenu();//invoke the showMenu method


    }
}

//This application allows the user to choose the option to check their balance, deposit money,
//to withdraw or to check their previous transactions


//create BankAccount class that has four variables
class BankAccount {
    int balance; //money which user has in account
    int previousTransaction; //last amount deposited
    String nameCustomer;
    String idCustomer;

    //create constructor
    //take two values as parameters
    //need values when displaying welcome message to user
    BankAccount(String customerName, String customerId){
        nameCustomer = customerName;
        idCustomer = customerId;

    }

    //the first method, deposit will take one int variable which is the amount
    //it wont perform the operation if the value entered is zero
    //increment balance with the amount
    //load the amount in the previous transaction

    void depositMethod(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    //withdrawMethod
    //cant withdraw zero from the amount so amount cant be equal to zero
    //balance has amount deducted

    void withdrawMethod(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){ //amount was deposited
            System.out.println("You have deposited: " + "£" + previousTransaction);
        }
        else if(previousTransaction < 0){ //withdrawn some amount. Use absolute method
            // to give positive of negative value so it makes sense
            System.out.println("You have withdrawn: " + "£" + Math.abs(previousTransaction));
        }
        else{ //if any of the above transaction doesn't work then no transaction occurred
            System.out.println("No transaction occurred");
        }
    }
    void showMenu(){
        {
            char option ='\0';
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome " + nameCustomer);
            System.out.println("Your ID number is " + idCustomer);
            //line break
            System.out.println("\n");
            //Five options for User to choose
            System.out.println("A. Check your balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");

            //do method
            do{
                System.out.println("=========================================");
                System.out.println("Enter an option:");
                System.out.println("=========================================");

                //read a character from the console.
                //The user will have entered some characters
                //Which will be captured in the option variable
                option = scanner.next().charAt(0);

                //pass the option variable in a switch case
                //Switch meaning: the option variable will be compared with each of the cases
                //Whenever it finds a match it will execute the following code
                switch (option){
                    //For Ex: if user enter A as option
                    //Then the below case A will be matched and code will be executed
                    case 'A':
                        System.out.println("--------------------------------");//Design
                        System.out.println("Balance = " + "£" +balance);//Display Balance
                        System.out.println("--------------------------------");//Design
                        System.out.println("\n");//line break
                        break;

                    case 'B':
                        System.out.println("--------------------------------");
                        System.out.println("Please enter an amount to deposit: ");//ask user
                        System.out.println("--------------------------------");
                        //use scanner object to take the input
                        //Value I get from user will be placed the variable amountDeposited
                        int amountDeposited = scanner.nextInt();
                        //Pass that variable into the depositMethod
                        //depositMethod will perform the operations written in the first method
                        //it will take the amount and add to the balance
                        depositMethod(amountDeposited);
                        System.out.println("\n");
                        break;

                    case 'C':
                        System.out.println("--------------------------------");
                        System.out.println("Enter an amount to withdraw: ");
                        System.out.println("--------------------------------");
                        int amountWithdrawn = scanner.nextInt();
                        //pass amount user enters into the withdraw method
                        //withdraw method will take the amount and deduct it from the balance
                        //and set the value of the previous transaction
                        withdrawMethod(amountWithdrawn);
                        System.out.println("\n");
                        break;

                    case 'D':
                        System.out.println("--------------------------------");
                        getPreviousTransaction(); //call method
                        System.out.println("--------------------------------");
                        System.out.println("\n");
                        break;

                    case 'E':
                        System.out.println("*************************************");
                        break;

                    //if user enters a character not present in the cases above
                    //For ex if user enters Z
                    //then it will print error message
                    default:
                        System.out.println("Invalid option! Please enter an option again");
                        break;

                }
                //loop will work(it will keep asking the user to enter an option)
                //as long as user does not enter E for exit
            }while(option != 'E');
            System.out.println("Thank You for using this service!");

        }
    }
}























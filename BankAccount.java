import java.io.*;
import java.util.*;
class BankAccount
{
public static void main(String [] args)
{
CheckingBankDetails b=new CheckingBankDetails(101);
Scanner sc=new Scanner(System.in);

while(true)
{
System.out.println("\nWELCOME: \nChoose operation:\n");
System.out.println("Press 1 to check balance in your account");
System.out.println("Press 2 for deposit");
System.out.println("Press 3 for widthdraw");
System.out.println("Press 4 for exit");
int a=sc.nextInt();



switch(a)
{
case 1:
System.out.println("Balance:"+b.getBalance());
break;

case 2:
System.out.println("Enter amount to deposit");
double a2=sc.nextInt();
b.deposit(a2);
break;

case 3:
System.out.println("Enter amount :");
try{
double a1=sc.nextDouble();
b.withdraw(a1);
}catch(FundsInsufficientException e)
{System.out.println("Account holder short "+e.getAmount());
e.printStackTrace();
}
break;

case 4:
System.exit(0);


default:
System.out.println("Invalid ");
}
}
}
}
class CheckingBankDetails
{int number;
double balance=0;
public CheckingBankDetails(int n)
{this.number=n;
}

public void deposit(double amount)
{balance+=amount;
}
public double getBalance()
{return balance;
}
public void withdraw(double amount)throws FundsInsufficientException
{
if(amount<=balance)
{
balance-=amount;
}
else
{
double need=amount-balance;
throw new FundsInsufficientException(need);
}
}
}
class FundsInsufficientException extends Exception
{double amount;
public FundsInsufficientException(double amount)
{this.amount=amount;
}
public double getAmount()
{
return amount;
}
}

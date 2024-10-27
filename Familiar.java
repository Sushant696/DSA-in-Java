/**
 * Familiar
 */

// Implement a simple banking system where a citizen can deposit and withdraw
// money and check balance

public class Familiar {
  public static void main(String[] args) {
    Bank mybank = new Bank(1200);
    mybank.getBalance();
    mybank.deposit(3000);

    mybank.withDrawMoney(3000);
    mybank.withDrawMoney(1201);

  }
}

class Bank {
  public int balance;

  Bank(int balance) {
    this.balance = balance;
  }

  public void getBalance() {
    System.out.println("Current account balance is " + balance);
  }

  public void deposit(int depositAmount) {
    this.balance = this.balance + depositAmount;
    System.out.println("Deposited " + depositAmount);
    getBalance();
  }

  public void withDrawMoney(int withdrawAmt) {
    if (withdrawAmt > this.balance) {
      System.out.print("You need $ ");
      System.out.println(this.balance - withdrawAmt + " short.");
    } else {
      System.out.println("withdrawn amount  " + withdrawAmt);
      this.balance = this.balance - withdrawAmt;
      getBalance();
    }
  }
}

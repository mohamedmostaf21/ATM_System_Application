/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import javafx.event.*;
import javafx.application.*;
import javafx.scene.input.MouseEvent;
enum TYPE{
    DEPOSITE,
    WITHDRAW,
}
/**
 *
 * @author Mohamed Mostafa
 */
public class Balance {
    private int balance;
    private boolean flag = true;

    public Balance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

   public void decreaseBalacance(Withdraw withdraw){
               if(this.balance < withdraw.getWithdraw()){
                   setFlag(false);
             
               }else{
                   this.balance -= withdraw.getWithdraw();
               }
       
   }
   public void increaseBalance(Deposite deposite){
           
            this.balance += deposite.getDeposite();
       
   }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
   
}

package Account;

import org.junit.Assert;
import org.junit.Test;


public class AccountTest {

    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    //The deposit and withdraw methods will not accept negative numbers
    @Test
    public void depositCannotHaveNegativeNumber_test(){
        Account account = new Account(20);
        boolean result = account.deposit(-1);
        Assert.assertFalse(result);
    }

    //The deposit and withdraw methods will not accept negative numbers
    @Test
    public void withDrawCannotHaveNegativeNumber_test(){
        Account account = new Account(20);
        boolean result = account.withdraw(-1);
        Assert.assertFalse(result);
    }

    // Account cannot overstep its overdraft limit:
    @Test
    public void account_cannot_overstep_overdraft_limit_test(){
        Account account = new Account(20);
        boolean result = account.withdraw(25);
        Assert.assertFalse(result);
    }

    //The deposit and withdraw methods will deposit or withdraw the correct amount, respectively
    @Test
    public void deposit_methods_correct_amount_Test(){
        Account account = new Account(20);
        account.deposit(20);
        boolean result = account.withdraw(20);

        Assert.assertTrue(Double.valueOf(0).equals(account.getBalance()));
        Assert.assertTrue(result);

    }

   // The withdraw and deposit methods return the correct results:
    @Test
    public void withdraw_methods_return_the_correct_results_test (){
        Account account = new Account(100);
        boolean withDrawResult =  account.withdraw(10);
        boolean depositResult =  account.deposit(20);

        Assert.assertTrue(Double.valueOf(10).equals(account.getBalance()));
        Assert.assertTrue(withDrawResult);
        Assert.assertTrue(depositResult);
    }

    // Tracking how fast I do, I score is 100%, perfect! 18 minutes

}
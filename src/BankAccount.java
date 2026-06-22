import java.time.LocalDateTime;
import java.util.Random;

public class BankAccount {
    private String accountHolderName;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;
    private String number;

    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
        Random random = new Random();
        this.number = String.format("%08d", random.nextInt(100000000));
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String getNumber() {
        return number;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean deposit(int amount) {
        if (!isBlocked && amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(int amount) {
        if (!isBlocked && amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (otherAccount != null && !isBlocked && !otherAccount.isBlocked) {
            if (withdraw(amount)) {
                otherAccount.deposit(amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Номер: " + number + "\n" +
                "Владелец: " + accountHolderName + "\n" +
                "Баланс: " + balance + "\n" +
                "Дата открытия: " + openingDate + "\n" +
                "Статус: " + (isBlocked ? "Заблокирован" : "Активен") + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof BankAccount)) return false;
        BankAccount otherAccount = (BankAccount) obj;
        return this.number.equals(otherAccount.number);
    }

    @Override
    public int hashCode() {
        if (number == null) {
            return 0;
        }
        return number.hashCode();
    }
}
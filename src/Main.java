public class Main{
    public static void main(String[] args) {
        BankAccount account_1 = new BankAccount("Дарья");
        BankAccount account_2 = new BankAccount("Луна");
        System.out.println(account_1);
        System.out.println(account_2);

        account_1.deposit(1000);
        System.out.println("Баланс счета №" + account_1.getNumber() + " после пополнения на 1000: " + account_1.getBalance() + "\n");

        System.out.println("Результат пополнения на 0: " + (account_2.deposit(0) ? "Успешно" : "Ошибка"));
        System.out.println("Результат пополнения на -50: " + (account_2.deposit(-50) ? "Успешно" : "Ошибка") + "\n");

        account_1.withdraw(200);
        System.out.println("Баланс счета №" + account_1.getNumber() + " после снятия 200: " + account_1.getBalance());
        System.out.println("Результат повторного снятия 900: " + (account_2.withdraw(900) ? "Успешно" : "Ошибка") + "\n");

        System.out.println("Баланс счета №" + account_1.getNumber() + ": " + account_1.getBalance());
        System.out.println("Баланс счета №" + account_2.getNumber() + ": " + account_2.getBalance() + "\n");
        account_1.transfer(account_2, 200);
        System.out.println("Результат перевода 200 от первого второму аккаунту:" + "\n"
                + "Баланс счета №" + account_1.getNumber() + ": " + account_1.getBalance() + "\n"
                + "Баланс счета №" + account_2.getNumber() + ": " + account_2.getBalance() + "\n");

        System.out.println("Результат повторного перевода 900: " + (account_1.transfer(account_2, 900) ? "Успешно" : "Ошибка") + "\n");

        account_1.setBlocked(true);
        System.out.println("Результат блокировки аккаунта 1: " + (account_1.isBlocked() ? "Заблокирован" : "Активен"));
        System.out.println("Результат попытки пополнения на 100: " + (account_1.deposit(100) ? "Успешно" : "Ошибка") + "\n");

        System.out.println("Результат сравнения аккаунта 1 с аккаунтом 1: " + (account_1.equals(account_1) ? "Равны" : "Не равны"));
        System.out.println("Результат сравнения аккаунта 1 с аккаунтом 2: " + (account_1.equals(account_2) ? "Равны" : "Не равны"));
    }
}

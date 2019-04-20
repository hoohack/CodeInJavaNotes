package chapter7;

public class CashCard {

    private String number;

    private int balance;

    private int bonus;

    public CashCard(String number, int balance, int bonus) {
        this.number = number;
        this.balance = balance;
        this.bonus = bonus;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void store(int money) {
        assert money >= 0 : "不能存负数";

        if (money > 0) {
            this.balance += money;
            if (money >= 100) {
                this.bonus++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void charge(int money) throws InsufficientException {
        assert money >= 0 : "不能取负数";

        if (money > 0) {
            if (money <= this.balance) {
                this.balance -= money;
            } else {
                throw new InsufficientException("余额不足", this.balance);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int exchange(int bonus) throws InsufficientException {
        if (bonus > 0) {
            this.bonus = bonus;
        } else {
            throw new InsufficientException("点数不足", bonus);
        }

        return this.bonus;
    }

}

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
        if (money > 0) {
            this.balance += money;
            if (money >= 100) {
                this.bonus++;
            }
        } else {
            System.out.println("存储负值，错误");
        }
    }

    public void charge(int money) {
        if (money > 0) {
            if (money <= this.balance) {
                this.balance -= money;
            } else {
                System.out.println("余额不足");
            }
        } else {
            System.out.println("不能取负数");
        }
    }

    public int exchange(int bonus) {
        if (bonus > 0) {
            this.bonus = bonus;
        } else {
            System.out.println("点数不足");
        }

        return this.bonus;
    }

}

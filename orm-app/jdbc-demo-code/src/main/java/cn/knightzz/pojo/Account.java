package cn.knightzz.pojo;

/**
 * @author 王天赐
 * @title: Account
 * @projectName lg-train-camp
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/11/3 13:17
 */
public class Account {

    private String cardNo;
    private String name;
    private int money;

    public Account(String cardNo, String name, int money) {
        this.cardNo = cardNo;
        this.name = name;
        this.money = money;
    }

    public Account() {
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardNo='" + cardNo + '\'' +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}

package chapter7;


public class CashCardService {

    private CashCard cashCard;

    public void save(CashCard cashCard) {
        CashCardDao cashCardDao = new CashCardFileServer();
        cashCardDao.add(cashCard);
    }

    public CashCard load(String number) {
        CashCardDao cashCardDao = new CashCardFileServer();
        return cashCardDao.getByNumber(number);
    }

}

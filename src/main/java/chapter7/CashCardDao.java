package chapter7;

/**
 * 设计Dao
 */
public interface CashCardDao {

    void add(CashCard cashCard);

    CashCard getByNumber(String number);

}

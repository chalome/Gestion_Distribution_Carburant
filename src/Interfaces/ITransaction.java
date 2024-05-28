
package Interfaces;

import Modeles.Transaction;
import java.util.List;

public interface ITransaction {
    
    public int create(Transaction transaction);

    public int update(Transaction transaction);

    public int delete(Transaction transaction);

    public List<Transaction> afficherTransactions();
}

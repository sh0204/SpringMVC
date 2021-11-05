package edu.catholic.mapper;

import edu.catholic.model.Account;

public interface AccountMapper {
    Account getAccount(String id);
    void insertAccount(Account account);
    void UpdateAccount(Account account);

}

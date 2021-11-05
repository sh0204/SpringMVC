package edu.catholic.Service;

import edu.catholic.mapper.AccountMapper;
import edu.catholic.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountMapper accountMapper;

    @Autowired //생성자를 통해 AccountMapper를 참조 할 수 있음
    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }
    public Account getAccount(String username) {

        return accountMapper.getAccount(username);
    }

    @Transactional // insert 할 때는 꼭 필요 한 순간에 한 사람만
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    @Transactional // update
    public void UpdateAccount(Account account) {
        accountMapper.UpdateAccount(account);
    }


}

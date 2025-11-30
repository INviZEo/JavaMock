package org.example.topic2_mockito.task3_AccountService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    @DisplayName("Успешное снятие средств")
    void successfullyWithdrawMoney() {
        Account account = new Account("14", 20000);
        int withdrawable = 10000;
        when(accountRepository.findAccountById(account.getAccountId())).thenReturn(account);

        boolean rsl = accountService.withdraw(account.getAccountId(), withdrawable);

        Assertions.assertTrue(rsl);
        Assertions.assertEquals(withdrawable, account.getBalance(), "Ждём балланс 10000");
        verify(accountRepository).findAccountById(account.getAccountId());
        verify(accountRepository).updateAccount(account);
        verifyNoMoreInteractions(accountRepository);
    }

    @Test
    @DisplayName("Отказ при недостатке средств")
    void insufficientFunds() {
        Account account = new Account("14", 20000);
        int withdrawable = 30000;
        when(accountRepository.findAccountById(account.getAccountId())).thenReturn(account);

        boolean rsl = accountService.withdraw(account.getAccountId(), withdrawable);

        Assertions.assertFalse(rsl);
        Assertions.assertEquals(20000, account.getBalance(), "Баланс не менялся");
        verify(accountRepository).findAccountById(account.getAccountId());
        verifyNoMoreInteractions(accountRepository);
    }

    @Test
    @DisplayName("Отказ, если аккаунт не найден")
    void accountNotFound() {
        String notExistAccountId = "notExistAccountId";
        int withdrawable = 5000;
        when(accountRepository.findAccountById(notExistAccountId)).thenReturn(null);

        boolean rsl = accountService.withdraw(notExistAccountId, withdrawable);
        Assertions.assertFalse(rsl);
        verify(accountRepository).findAccountById(notExistAccountId);
        verifyNoMoreInteractions(accountRepository);
    }
}
package org.heg.samplefury.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountDto {

    public AccountDto(Long accountId, String noAccount, ClientDto client, String status, LocalDate openDate, BigDecimal amount, String description) {
        this.accountId = accountId;
        this.noAccount = noAccount;
        this.client = client;
        this.status = status;
        this.openDate = openDate;
        this.amount = amount;
        this.description = description;
    }

    private Long accountId;

    private String noAccount;

    private ClientDto client;

    private String status;

    private LocalDate openDate;

    private BigDecimal amount;

    private String description;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getNoAccount() {
        return noAccount;
    }

    public void setNoAccount(String noAccount) {
        this.noAccount = noAccount;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountId=" + accountId +
                ", noAccount='" + noAccount + '\'' +
                ", client=" + client +
                ", status='" + status + '\'' +
                ", openDate=" + openDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}

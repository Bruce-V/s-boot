package cn.kgc.vo;

import java.io.Serializable;

public class Account implements Serializable{
  private Integer id;
  private String cardno;
  private String password;
  private Double balance;
  private Integer status;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCardno() {
    return cardno;
  }

  public void setCardno(String cardno) {
    this.cardno = cardno;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Account{" +
            "id=" + id +
            ", cardno='" + cardno + '\'' +
            ", password='" + password + '\'' +
            ", balance=" + balance +
            ", status=" + status +
            '}';
  }
}

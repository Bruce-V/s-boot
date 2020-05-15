package cn.kgc.vo;

import java.io.Serializable;

public class Record implements Serializable{
  private Integer id;
  private String cardno;
  private String transactiondate;
  private Double expense;
  private Double income;
  private Double balance;
  private String transactiontype;
  private String remark;

  private String starttime;
  private String endtime;


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

  public String getTransactiondate() {
    return transactiondate;
  }

  public void setTransactiondate(String transactiondate) {
    this.transactiondate = transactiondate;
  }

  public Double getExpense() {
    return expense;
  }

  public void setExpense(Double expense) {
    this.expense = expense;
  }

  public Double getIncome() {
    return income;
  }

  public void setIncome(Double income) {
    this.income = income;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public String getTransactiontype() {
    return transactiontype;
  }

  public void setTransactiontype(String transactiontype) {
    this.transactiontype = transactiontype;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getStarttime() {
    return starttime;
  }

  public void setStarttime(String starttime) {
    this.starttime = starttime;
  }

  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }

  @Override
  public String toString() {
    return "Record{" +
            "id=" + id +
            ", cardno='" + cardno + '\'' +
            ", transactiondate='" + transactiondate + '\'' +
            ", expense=" + expense +
            ", income=" + income +
            ", balance=" + balance +
            ", transactiontype='" + transactiontype + '\'' +
            ", remark='" + remark + '\'' +
            ", starttime='" + starttime + '\'' +
            ", endtime='" + endtime + '\'' +
            '}';
  }
}

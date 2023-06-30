package com.example.SpringAngular.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @Column(name = "customer_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerid;

    @Column(name = "customer_name", length = 50)
    private String customername;

    @Column(name = "customer_address", length = 60)
    private String customeraddress;

    @Column(name = "mobile", length = 12)
    private int mobile;
    @Column(name = "debut_de_conge", length = 60)
    private Date customerdebut;
    @Column(name = "fin_de_conge", length = 60)
    private Date customerfin;

    public Customer(String customername, String customeraddress, int mobile, Date customerdebut , Date customerfin ) {
        this.customerid = customerid;
        this.customername = customername;
        this.customeraddress = customeraddress;
        this.mobile = mobile;
        this.customerdebut = customerdebut;
        this.customerfin = customerfin;
    }

    public Customer() {
    }

    public Customer(String customername, String customeraddress, int mobile) {
        this.customername = customername;
        this.customeraddress = customeraddress;
        this.mobile = mobile;
        this.customerdebut = customerdebut;
        this.customerfin = customerfin;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public Date getCustomerdebut() {
        return customerdebut;
    }

    public void setCustomerdebut(Date customerdebut) {
        this.customerdebut = customerdebut;
    }

    public Date getCustomerfin() {
        return customerfin;
    }

    public void setCustomerfin(Date customerfin) {
        this.customerfin = customerfin;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", customername='" + customername + '\'' +
                ", customeraddress='" + customeraddress + '\'' +
                ", mobile=" + mobile +
                ", customerdebut=" + customerdebut +
                ", customerfin=" +customerfin +

                '}';
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import ejb.CustomerService;
import entity.Customer;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author grace
 */
@Named(value = "test")
@SessionScoped
public class testMB implements Serializable{

    @EJB
    private CustomerService cs;
    private int customerid;

    public testMB() {
    }
    
    public String add(){
        Customer c=new Customer();
        c.setId(12);
        cs.create(c);
        return null;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public CustomerService getCs() {
        return cs;
    }

    public void setCs(CustomerService cs) {
        this.cs = cs;
    }
    
    
}

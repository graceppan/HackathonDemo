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

/**
 *
 * @author grace
 */
@ManagedBean
@SessionScoped
public class Test implements Serializable{

    @EJB
    private CustomerService cs;
    private String name;
    public Test() {
    }
    public String add(){
        Customer c=new Customer();
        c.setName(name);
        cs.create(c);
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CustomerService getCs() {
        return cs;
    }

    public void setCs(CustomerService cs) {
        this.cs = cs;
    }
    
    
}


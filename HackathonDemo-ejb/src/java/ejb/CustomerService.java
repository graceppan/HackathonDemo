/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import boundary.AbstractFacade;
import entity.Customer;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

/**
 *
 * @author grace
 */
@Stateless
public class CustomerService extends AbstractFacade<Customer> {

    @PersistenceContext(name = "HackathonDemo")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerService() {
        super(Customer.class);
    }

    public Customer findCutomerWithId(int id) {
        try {
            TypedQuery query = em.createNamedQuery("Customer.findCustomerById", Customer.class).setParameter("id", id);
            Customer c = (Customer) query.getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    public Customer findCutomerWithId() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        HttpSession session = (HttpSession) ec.getSession(true);
        try {
            int id = (int) session.getAttribute("loggedUserId");
            TypedQuery query = em.createNamedQuery("Customer.findCustomerById", Customer.class).setParameter("id", id);
            Customer c = (Customer) query.getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    public Customer findLoginCustomer(String email, String password) {
        try {
            TypedQuery query = em.createNamedQuery("Customer.findLoginCustomer", Customer.class).setParameter("email", email).setParameter("password", password);
            Customer c = (Customer) query.getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    public Customer findCutomerWithEmail(String email) {
        try {
            TypedQuery query = em.createNamedQuery("Customer.findCustomerByEmail", Customer.class).setParameter("email", email);
            Customer c = (Customer) query.getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}

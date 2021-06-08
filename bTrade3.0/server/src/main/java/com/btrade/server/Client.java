/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btrade.server;

/**
 *
 * @author ODJOGIY
 */
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
@Entity
@Table(name = "CLIENT")
public class Client  {
       @Id
       @Column(name="CUSTOMER_ID")
       private int customerId;
      
       @Column(name="FIRST_NAME")
        private String firstName;
       
       @Column(name="LAST_NAME")
        private String lastName;
        public Client() {}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

        

}


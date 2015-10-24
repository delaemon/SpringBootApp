package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
 
@Entity
public class Person {
 
        @Id
        @GeneratedValue
        public Integer id;
        public String name;
        public String tel;
        public String mail;
        public String description;
 
        public Person() {
          super();
        }
 
        public Person(String name, String tel, String mail, String description) {
 
          super();
          this.name = name;
          this.tel  = tel;
          this.mail = mail;
          this.description = description;
        }
 
        // for debug
        public String toString() {
          return "[name:" + name + ", tel:" + tel + ", mail:" + mail + ", description:" + description + "]";
        }
}
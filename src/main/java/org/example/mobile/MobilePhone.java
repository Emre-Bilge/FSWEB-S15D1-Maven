package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

  /*  public MobilePhone(String myNumber,ArrayList<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }
*/
  public MobilePhone(String myNumber, List<Contact> myContacts) {
      this.myNumber = myNumber;
      this.myContacts = new ArrayList<>(myContacts); // List'ı ArrayList'e dönüştürme
  }


    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (!myContacts.contains(contact)) {
            myContacts.add(contact);
            return true;
        } else {
            System.out.println("zaten kayıtlı");
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (myContacts.contains(oldContact)) {
            int indexOfOldContact = myContacts.indexOf(oldContact);
            myContacts.set(indexOfOldContact, newContact);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if (myContacts.contains(contact)) {
            //   int indexOfContact = myContacts.indexOf(contact);
            myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }

    public int findContact(Contact contact) {
        if (myContacts.contains(contact)) {
            int indexOfContact = myContacts.indexOf(contact);
            return indexOfContact;
        } else {
            return -1;
        }
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1; // Eğer bulunmazsa
    }

   public void printContact(){
        if(myContacts.isEmpty()){
            System.out.println("kayıtlı değil");
            return ;
        }

       System.out.println("Contact List:");
        for(Contact contact : myContacts){
            System.out.println(contact.getName() + " -> "+contact.getPhoneNumber());
        }
   }
    public Contact queryContact(String name) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(name)) { // İsimleri karşılaştırıyoruz
                return contact; // İlgili Contact'ı döndürüyoruz
            }
        }
        return null; // Eğer listede yoksa null döndürüyoruz
    }


}
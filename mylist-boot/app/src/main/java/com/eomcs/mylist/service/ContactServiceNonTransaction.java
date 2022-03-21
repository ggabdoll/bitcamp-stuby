package com.eomcs.mylist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;

//@Service
public class ContactServiceNonTransaction {

  @Autowired
  ContactDao contactDao;

  @Autowired
  TransactionTemplate transactionTemlplate;

  public Object list() {
    List<Contact> contacts = contactDao.findAll();
    for (Contact contact : contacts) {
      contact.setTels(contactDao.findTelByContactNo(contact.getNo()));
    }
    return contacts;
  }

  public Integer add(Contact contact) {
    return transactionTemlplate.execute(status -> {
      // 트랜잭션으로 묶어서 할 작업을 기술한다.
      contactDao.insert(contact);
      for (ContactTel tel:contact.getTels()) {
        tel.setContactNo(contact.getNo()); // 전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
        contactDao.insertTel(tel);
      }
      return 1;       
    });
  }

  public Contact get(int no) {
    Contact contact = contactDao.findByNo(no);
    if (contact != null) {
      contact.setTels(contactDao.findTelByContactNo(no));
    }
    return contact;
  }

  //  public Integer update(Contact contact) {
  //    // 1) 트랜잭션으로 묶어서 실해할 작업을 스프링 규칙에 따라 정의한다.
  //    class ContactUpdateTransaction implements TransactionCallback<Integer>{
  //
  //      @Override
  //      public Integer doInTransaction(TransactionStatus status) {
  //        int count = contactDao.update(contact);
  //        if (count > 0) {
  //          contactDao.deleteTelByContactNo(contact.getNo()); // 전와번로 변경 전에 기존 전화번호를 모두 삭제 한다.
  //          for (ContactTel tel:contact.getTels()) {
  //            contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
  //          }
  //        }
  //        return count;
  //      }
  //
  //    }
  //    // 2) 트랜잭션을 실행한다.
  //    return  transactionTemlplate.execute(new ContactUpdateTransaction());
  //  }

  //  public Integer update(Contact contact) {
  //    // 1) 트랜잭션으로 묶어서 실해할 작업을 스프링 규칙에 따라 정의한다.
  //    TransactionCallback<Integer> ContactUpdateTransaction = new TransactionCallback<>(){
  //      @Override
  //      public Integer doInTransaction(TransactionStatus status) {
  //        int count = contactDao.update(contact);
  //        if (count > 0) {
  //          contactDao.deleteTelByContactNo(contact.getNo()); // 전와번로 변경 전에 기존 전화번호를 모두 삭제 한다.
  //          for (ContactTel tel:contact.getTels()) {
  //            contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
  //          }
  //        }
  //        return count;
  //      }
  //    };
  //    // 2) 트랜잭션을 실행한다.
  //    return  transactionTemlplate.execute(ContactUpdateTransaction);
  //  }

  //  public Integer update(Contact contact) {
  //    return  transactionTemlplate.execute(new TransactionCallback<>(){
  //      @Override
  //      public Integer doInTransaction(TransactionStatus status) {
  //        int count = contactDao.update(contact);
  //        if (count > 0) {
  //          contactDao.deleteTelByContactNo(contact.getNo()); // 전와번로 변경 전에 기존 전화번호를 모두 삭제 한다.
  //          for (ContactTel tel:contact.getTels()) {
  //            contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
  //          }
  //        }
  //        return count;
  //      }
  //    });
  //  }

  public Integer update(Contact contact) {
    return  transactionTemlplate.execute(status -> {
      int count = contactDao.update(contact);
      if (count > 0) {
        contactDao.deleteTelByContactNo(contact.getNo()); // 전와번로 변경 전에 기존 전화번호를 모두 삭제 한다.
        for (ContactTel tel:contact.getTels()) {
          contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
        }
      }
      return count;
    });
  }

  public Integer delete(Integer no) {
    return transactionTemlplate.execute(status -> {
      contactDao.deleteTelByContactNo(no);
      return contactDao.delete(no);
    });
  }

}

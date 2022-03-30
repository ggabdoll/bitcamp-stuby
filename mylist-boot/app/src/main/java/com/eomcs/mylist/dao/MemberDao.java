package com.eomcs.mylist.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.eomcs.mylist.domain.Member;

@Mapper  
public interface MemberDao {

  int insert(Member board);

  Member findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

  //  List<Member> findAll();
  //
  //
  //  Member findByNo(int no);
  //
  //  int update(Member board);
  //
  //  int delete(int no);
  //
  //  int increaseViewCount(int no);
}












package com.eomcs.mylist.dao;

import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Member;

@Mapper  
public interface MemberDao {

  int insert(Member board);

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












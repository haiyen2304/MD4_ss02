package com.ra.session02MD4.repository;

import com.ra.session02MD4.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("select m from Member m where m.fullName like concat('%',:search,'%') or m.departmentName like concat('%',:search,'%')")
    List<Member> findAllByFullNameOrDepartmentNameContains(@Param("search") String search);

}

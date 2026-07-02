package ols2405.mlm.repository;

import org.springframework.data.repository.CrudRepository;

import ols2405.mlm.model.Member;

public interface MemberRepository extends CrudRepository <Member, Integer> {
    
}

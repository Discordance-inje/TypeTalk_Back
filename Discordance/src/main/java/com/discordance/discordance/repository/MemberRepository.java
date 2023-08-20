package com.discordance.discordance.repository;


import com.discordance.discordance.common.MemberType;
import com.discordance.discordance.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, BigInteger> {
    Optional<Member> findByAccount(String account);
    List<Member> findAllByType(MemberType type);

}

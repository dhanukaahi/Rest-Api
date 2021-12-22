package com.Dhanuka.Suren.repository;

import com.Dhanuka.Suren.model.Admin;
import com.Dhanuka.Suren.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
}

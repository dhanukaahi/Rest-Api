package com.Dhanuka.Suren.repository;

import com.Dhanuka.Suren.model.Department;
import com.Dhanuka.Suren.model.HRM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

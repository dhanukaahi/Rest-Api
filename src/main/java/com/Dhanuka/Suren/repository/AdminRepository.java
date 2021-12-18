package com.Dhanuka.Suren.repository;

import com.Dhanuka.Suren.model.Admin;
import com.Dhanuka.Suren.model.HRM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}

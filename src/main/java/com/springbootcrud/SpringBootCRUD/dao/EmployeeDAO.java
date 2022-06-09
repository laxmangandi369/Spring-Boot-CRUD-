package com.springbootcrud.SpringBootCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootcrud.SpringBootCRUD.beans.EmployeeBean;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeBean, Integer>  {

}
 
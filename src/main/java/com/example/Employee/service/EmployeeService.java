package com.example.Employee.service;


import com.example.Employee.entity.Employee;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    //get all employees
    public List<Employee> getAll(){

        //find all employees data and return it
        return repo.findAll();
    }

    //save Employee data
    public Employee add(Employee emp){
        // save the data to the employee
        return repo.save(emp);
    }

    //get the employee date by id
    public Employee getById(int id){
        Employee emp = repo.findById(id).get();
        //if the employee not found throw error
        if (emp==null){
            throw new RuntimeException("Employee not found");
        }
        return emp;
    }

    //delete employee by id
    public String deleteById(int id){
        Employee emp = repo.findById(id).get();
        if (emp==null){
            throw new RuntimeException("Employee not found");
        }
        repo.deleteById(id);
        return "Deleted:"+emp.getFirstname()+" "+emp.getLastname();
    }



}

package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap=null;

    @Autowired
    DepartmentDao departmentDao;

    static {
        employeeMap=new HashMap<>();
      employeeMap.put(1001,new Employee(1001,"AA","A1506120391@qq.com",1,new Department(101,"一教")));
      employeeMap.put(1002,new Employee(1002,"BB","B1506120391@qq.com",0,new Department(102,"二教")));
      employeeMap.put(1003,new Employee(1003,"CC","C1506120391@qq.com",1,new Department(103,"三教")));
      employeeMap.put(1004,new Employee(1004,"DD","D1506120391@qq.com",0,new Department(104,"四教")));
      employeeMap.put(1005,new Employee(1005,"EE","E1506120391@qq.com",1,new Department(105,"五教")));
    }
    //主键自增
    private static Integer initId=1006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
    //全部
    public Collection<Employee> getAll(){
        return employeeMap.values();
    }
    //查询
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);

    }
    //删除
   public void delete(Integer id){
        employeeMap.remove(id);
    }

}

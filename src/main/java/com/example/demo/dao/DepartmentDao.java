package com.example.demo.dao;

import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {
    //模拟数据库的数据
    private  static Map<Integer, Department> departmentMap=null;
    static {
        departmentMap=new HashMap<>();
        departmentMap.put(101,new Department(101,"一教"));
        departmentMap.put(102,new Department(102,"二教"));
        departmentMap.put(103,new Department(103,"三教"));
        departmentMap.put(104,new Department(104,"四教"));
        departmentMap.put(105,new Department(105,"五教"));
    }
    public Collection<Department> getDepartments(){
        return  departmentMap.values();
    }
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }


}

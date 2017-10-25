package com.pvt.services;

import com.pvt.DAO.DepartmentDAO;
import com.pvt.model.Department;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DepartmentServiceImpl implements DepartmentService{
    
    private DepartmentDAO departmentDAO;

    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }
    
    //метод вставляет запись в таблицу, потом выбрасывает исключение,
    //что приводит к откату транзакции
    public void addDepartment(final Department dep)  {
        departmentDAO.addDepartment(dep);
        throw new RuntimeException("Exception throwed!");
    }
}

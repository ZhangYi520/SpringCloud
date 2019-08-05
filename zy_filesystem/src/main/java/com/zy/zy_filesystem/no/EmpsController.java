package com.zy.zy_filesystem.no;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


//@Controller
//public class EmpsController {
//
//	@Autowired
//	EmployeeDao employeeDao;
//
//	@Autowired
//	DepartmentDao departmentDao;
//	
//	//查询所有数据填充达到界面
//	@GetMapping("/emps")
//	public String emps(Model model) {
//		Collection<Employee> employee=employeeDao.getAll(); 
//		model.addAttribute("emps", employee);
//		return "emp/list";
//	}
//	//获取下拉列表的值
//	@GetMapping("/emp")
//	public String addEmps(Model model) {
//		Collection<Department> departments=departmentDao.getDepartments();
//		model.addAttribute("depts",departments);
//		return "emp/addUserSet";
//	}
//	
//	//写实体类，Spring MVC会自动将对应的值填充进实体类，前提是name和实体类属性值一样
//	@PostMapping("/emp")
//	public String addEmp(Employee employee) {
//		employeeDao.save(employee);
//		//System.out.println(employee);
//		return "redirect:/emps";
//	}
//	//来到修改界面
//	@GetMapping("/emp/{id}")
//	public String onUpdateUser(@PathVariable("id") Integer id,Model model) {
//		//回显用户数据
//		Employee employee= employeeDao.get(id);
//		model.addAttribute("emp",employee);
//		//查询下拉框的值
//		Collection<Department> departments=departmentDao.getDepartments();
//		model.addAttribute("depts",departments);
//		return "emp/addUserSet";
//	}
//	
//	//修改数据
//	@PutMapping("/emp")
//	public String updateUser(Employee employee) {
//		employeeDao.save(employee);
//		return "redirect:/emps";
//	}
//	
//	//删除数据
//	@GetMapping("/empDel/{id}")
//	public String deleteEmp(@PathVariable("id") Integer id) {
//		employeeDao.delete(id);
//		return "redirect:/emps";
//	}
//}

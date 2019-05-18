package com.duan.mapper;

import java.util.List;

import com.duan.pojo.Student;

public interface StudentMapper {
	public List<Student> selectStudentByIdOrByNameAndPwd(Student student);
	public List<Student> selectStudentByWhere(Student student);
	public void updateStudentByDynamicSQL(Student student);
	public List<Student> selectStudentsByInClause(List<Integer> list);
	public List<Student> selectStudentsByPattern(String value);
}

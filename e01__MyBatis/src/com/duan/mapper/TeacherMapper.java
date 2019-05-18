package com.duan.mapper;

import java.util.List;
import java.util.Map;

import com.duan.pojo.Teacher;

public interface TeacherMapper {
	public void insertOneTeacherStatic();
	public int insertOneTeacher(Teacher teacher);
	public void deleteOneTeacher(int id);
	public List<Teacher> selectTeachersByCondition(Map<String,Object> params);
	
}

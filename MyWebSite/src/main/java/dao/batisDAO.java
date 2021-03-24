package dao;


import org.apache.ibatis.annotations.Select;

public interface batisDAO {
	
	
	
	@Select("SELECT * FROM student.USER_INFO WHERE user_id = 'qqq'")
	public String selectUser();
	
}

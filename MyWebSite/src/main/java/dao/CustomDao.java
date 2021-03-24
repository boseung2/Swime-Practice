package dao;

public class CustomDao extends UtilOfDao{
	UserDao udo = UserDao.getInstance();
	
	public boolean isIdPw(String id, String pw) throws Exception {
		User user = udo.selectUser(id);
		if(user == null) return false;
		else return user.getPassword().equals(pw);
	}
	
	
	public boolean alreadyId(String id) throws Exception { 
		return udo.selectUser(id) != null;
	}
	
	public User selectUser(String id) throws Exception { 
		return udo.selectUser(id);
	}
	
	public boolean ismakeUser(User u) throws Exception {
		if((boolean)isNull_value(u)[0] || alreadyId(u.getId()))
			return false;
		else
			return udo.insertUser(u) == 1;
	}
	
	public boolean isupdateUser(User u) throws Exception {
		if((boolean)isNull_value(u)[0] || !alreadyId(u.getId()))
			return false;
		else
			return udo.updateUser(u) == 1;
	}
	
	public boolean isdeleteUser(String id) throws Exception {	
		if((boolean)isNull_value(id)[0] || !alreadyId(id))
			return false;
		else
			return udo.deleteUser(id) == 1;
	}
	
	
	
} // end class


class UtilOfDao{
	public String[] trans(User user) {
		return new String[]{user.getId(), user.getPassword(), user.getName(), user.getEmail()};
	}
	
	public Object[] isNull_value(User u) {
		return isNull_value(trans(u));
	}
	
	public Object[] isNull_value(String...value) {
		Object[] result = new Object[] {false,""};
		String[] whoisNull = {"ID","Password","Name","Email"};
		
		for(int i = 0; i < value.length; i++) {
			if(value[i] == null || "".equals(value[i])) {
				result = new Object[] {true, whoisNull[i]+" is missing"};
				break;
			}
		}
		return result;
	}
} // end class
package dao;

import vo.member;

public interface hwmemberdao {
	
	
//create
	
void add(member m);

//read

member query(String username,String password);//登入判斷帳號密碼
boolean query(String username);
boolean query2(String password);

//update

void update(int assets,String name);

}

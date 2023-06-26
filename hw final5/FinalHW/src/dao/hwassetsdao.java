package dao;

import java.util.List;

import vo.assets;
import vo.order;

public interface hwassetsdao {
	
//read
assets queryassets(String name);

assets queryall(String name);
}

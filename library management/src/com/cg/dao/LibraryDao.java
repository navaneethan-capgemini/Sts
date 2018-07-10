package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.dto.LibraryDto;

public class LibraryDao implements ILibraryDao {
	
	public static Map<String, LibraryDto> map=new HashMap<>();
	
		static
		{
			LibraryDto dto1=new LibraryDto();
			dto1.setMid("101");
			dto1.setName("abc");
			dto1.setBalance(400);
			
			LibraryDto dto2=new LibraryDto();
			dto2.setMid("201");
			dto2.setName("cda");
			dto2.setBalance(-200);
			
			LibraryDto dto3=new LibraryDto();
			dto3.setMid("301");
			dto3.setName("mno");
			dto3.setBalance(-500);
			
			map.put(dto1.getMid(),dto1);
			map.put(dto2.getMid(),dto2);
			map.put(dto3.getMid(),dto3);
			
		}
	
	
	
	
	
	@Override
	public LibraryDto displayDetails(String mid) {
		// TODO Auto-generated method stub
		return map.get(mid);
		
	}

	@Override
	public LibraryDto amountbalance(String mid, int payment) {
		// TODO Auto-generated method stub
		
		/*int amount=map.get(mid).getBalance();
		System.out.println(amount);
		int newAmount=amount+payment;
		map.get(mid).setBalance(newAmount);*/
		LibraryDto dto= map.get(mid);
		int amount=dto.getBalance();
		amount+=payment;
		dto.setBalance(amount);
		return map.get(mid);
		
		
	}

}

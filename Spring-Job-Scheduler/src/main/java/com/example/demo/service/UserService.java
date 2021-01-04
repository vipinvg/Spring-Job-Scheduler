package com.example.demo.service;
import com.example.demo.model.User;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	 Logger log= LoggerFactory.getLogger(UserService.class);
	
	 //schedule a job to add user in DB every 5 sec
	@Scheduled(fixedRate = 5000)
	public void add2DBJob()
	{
		User user = new User();
		user.setName("user" +new Random().nextInt(888));
		
		dao.saveAll(Arrays.asList(user));
		System.out.println("Add user to DB " +new Date().toString());
		
	}
	//cron job fetches users from DB every 15 sec
	@Scheduled (cron = "0/15 * * * * *")
	public void fetchDBJob()
	{
		
		List<com.example.demo.model.User> user = dao.findAll();
		System.out.println("fetch user from DB " +new Date().toString());
		System.out.println("no of record fetched  " +user.size());
	}

}

package com.idle.worknine.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idle.worknine.entity.Register;
import com.idle.worknine.repository.RegisterRepository;
import com.idle.worknine.repository.UserRepository;

@Service
public class LoginService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;

	@Autowired
	RegisterRepository registerRepository;

	public void save(Register register) {

		try{
			if(logger.isDebugEnabled()){
				logger.debug("In LoginService Class, save() Method");
			}
			registerRepository.save(register);
		}catch(Exception e){
			logger.error("Password & Confirm Password are different");
		}

	}


	public Register authenticate(Integer id){
		if(id != null){
			return registerRepository.findOne(id);
		}else
			return null;
	}

}

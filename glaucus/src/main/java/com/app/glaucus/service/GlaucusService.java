package com.app.glaucus.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.app.glaucus.dto.ResponseDto;
import com.app.glaucus.entity.Number;
import com.app.glaucus.repository.NumberRepository;
@Service
@Transactional
public class GlaucusService implements ApplicationRunner {
	
	@Autowired
	NumberRepository numberRepository;
	
	public ResponseDto increamentValue() {
		synchronized (this) {
			try {
				Optional<Number> number = 	numberRepository.findFirstByOrderByNumber();
				Integer num = 0;
				if(number.isPresent()){
					Number numObj = number.get();
				 num = 	numObj.getNumber() +1;
				 numObj.setNumber(num);
				numberRepository.updateData(numObj.getNumber(),numObj.getId());
				}else {
					num = 1;
					Number entity = new Number();
					entity.setNumber(num);
					 numberRepository.saveAndFlush(entity);
					//numberRepository.insetData(num);
				}
					return ResponseDto.getSuccessReponse("Data increment successfully : "+num);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseDto.getErrorReponse("Some error occued please try after some time",500);
			}
			
		}
	
	}
	
	public ResponseDto getValue() {
		try {
			Optional<Number> number = 	numberRepository.findFirstByOrderByNumber();
			if(number.isPresent()){
				Integer num = 	number.get().getNumber();
				return ResponseDto.getSuccessReponse("Value is : "+num);
				}else {
					return ResponseDto.getErrorReponse("Data not found",404);
				}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDto.getErrorReponse("Some error occued please try after some time",500);
		}
		
	}

	public ResponseDto resetValue() {
		try {
			Optional<Number> number = 	numberRepository.findFirstByOrderByNumber();
			if(number.isPresent()){
			 	number.get().setNumber(0);
			 	numberRepository.saveAndFlush(number.get());
				return ResponseDto.getSuccessReponse("Data reset successfully");
				}else {
					return ResponseDto.getErrorReponse("There is no data to be reset",404);
				}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDto.getErrorReponse("Some error occued please try after some time",500);
		}
		
	
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Optional<Number> number = 	numberRepository.findFirstByOrderByNumber();
		if(!number.isPresent()){
		Number entity = new Number();
		entity.setNumber(0);
		 numberRepository.saveAndFlush(entity);
		}
		
		
	}
}

package com.app.glaucus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.glaucus.dto.ResponseDto;
import com.app.glaucus.service.GlaucusService;

@RestController
public class glaucusController {
	@Autowired
	private GlaucusService glaucusService;
	
	@GetMapping("increment")
	public ResponseDto incrementValue() {
		return glaucusService.increamentValue();
		
	}
	
	@GetMapping("getValue")
	public ResponseDto getValue() {
		return glaucusService.getValue();
		
	}

	@GetMapping("resetValue")
	public ResponseDto resetValue() {
		return glaucusService.resetValue();
		
	}
}

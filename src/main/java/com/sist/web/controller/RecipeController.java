package com.sist.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.RecipeService;
import com.sist.web.service.RecipeVectorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RecipeController {
	private final RecipeService rService;
	private final RecipeVectorService vService;
	
	@GetMapping("/recipe")
	public String recipe_insert() {
//		rService.recipeInsert();
//		return "데이터 저장 완료";
		vService.recipeVectorInsert();
		return "Vector 데이터 저장 완료";
		
	}
}

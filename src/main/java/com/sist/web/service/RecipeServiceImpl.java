package com.sist.web.service;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.oracle.OracleRecipeMapper;
import com.sist.web.mapper.postgres.PostgresRecipeMapper;
import com.sist.web.vo.RecipeVO;

import java.util.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
	private final OracleRecipeMapper oMapper;
	private final PostgresRecipeMapper pMapper;
	
	@Override
	public void recipeInsert() {
		List<RecipeVO> list=oMapper.oracleRecipeAllData();
		for(RecipeVO vo:list) {
			pMapper.postgresRecipeInsert(vo);
		}
	}
	//RecipeVector
	
	
}

package com.sist.web.mapper.oracle;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.RecipeVO;

import java.util.*;

@Mapper
@Repository
public interface OracleRecipeMapper {
	public List<RecipeVO> oracleRecipeAllData();
}

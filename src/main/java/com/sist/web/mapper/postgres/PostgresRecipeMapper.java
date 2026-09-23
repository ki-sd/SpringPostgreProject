package com.sist.web.mapper.postgres;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.RecipeVO;
import com.sist.web.vo.RecipeVectorVO;

@Mapper
@Repository
public interface PostgresRecipeMapper {
	
	public void postgresRecipeInsert(RecipeVO vo);
	public void recipeVectorInsert(RecipeVectorVO vo);
	public List<RecipeVO> postgreRecipeAllData();
}

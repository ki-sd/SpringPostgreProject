package com.sist.web.service;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

import com.sist.web.mapper.oracle.OracleRecipeMapper;
import com.sist.web.mapper.postgres.PostgresRecipeMapper;
import com.sist.web.vo.RecipeVO;
import com.sist.web.vo.RecipeVectorVO;

import java.util.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeVectorService {
	private final PostgresRecipeMapper pMapper;
	private final OracleRecipeMapper oMapper;
	private final EmbeddingModel model;
	
	public void recipeVectorInsert() {
		List<RecipeVO> list=pMapper.postgreRecipeAllData();
		System.out.println("recipe데이터:"+list.size());
		for(RecipeVO recipe:list) {
			String content=createContent(recipe);
			float[] vector=model.embed(content);
			String embedding=convertVector(vector);
			RecipeVectorVO vo=RecipeVectorVO.builder()
									.recipeId((long)recipe.getRcpSeq())
									.content(content)
									.embedding(embedding)
									.build();
			
			pMapper.recipeVectorInsert(vo);
			
			System.out.println("vector 저장:"+vector+"/"+
								"content:"+content+"/"+
								"embedding:"+embedding);
		}
	}
	private String createContent(RecipeVO vo) {
		return """
				레시피명: %s
				조리방법: %s
				요리종류: %s
				영양정보: %s kcal
				탄수화물: %s
				단백질: %s
				지방: %s
				나트륨: %s
				해시태그: %s
				주재료: %s
				조리정보: %s
				요리팁: %s
				""".formatted(
					vo.getRcpNm(),
					vo.getRcpWay2(),
					vo.getRcpPat2(),
					vo.getInfoEng(),
					vo.getInfoCar(),
					vo.getInfoPro(),
					vo.getInfoFat(),
					vo.getInfoNa(),
					vo.getHashTag(),
					vo.getRcpPartsDtls(),
					vo.getAttFileNoMk(),
					vo.getRcpNaTip()
				);
	}
	private String convertVector(float[] vector) {
		StringBuilder sb=new StringBuilder("[");
		for (int i=0;i<vector.length;i++) {
			if(i>0) {
				sb.append(",");
			}
			sb.append(vector[i]);
		}
		sb.append("]");
		return sb.toString();
	}
}

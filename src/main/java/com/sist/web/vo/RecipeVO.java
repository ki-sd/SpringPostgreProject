package com.sist.web.vo;

import lombok.Data;

//RCP_SEQ          NOT NULL NUMBER(10)    
//RCP_NM                    VARCHAR2(200) 
//RCP_WAY2                  VARCHAR2(100) 
//RCP_PAT2                  VARCHAR2(100) 
//INFO_WGT                  VARCHAR2(50)  
//INFO_ENG                  NUMBER(10,2)  
//INFO_CAR                  NUMBER(10,2)  
//INFO_PRO                  NUMBER(10,2)  
//INFO_FAT                  NUMBER(10,2)  
//INFO_NA                   NUMBER(10,2)  
//HASH_TAG                  VARCHAR2(200) 
//ATT_FILE_NO_MAIN          VARCHAR2(500) 
//ATT_FILE_NO_MK            VARCHAR2(500) 
//RCP_PARTS_DTLS            CLOB          
//RCP_NA_TIP                CLOB          
//USER_ID                   VARCHAR2(20)  
//HIT                       NUMBER    
@Data
public class RecipeVO {
	private int rcpSeq,hit;
	private double infoEng,infoCar,infoPro,infoFat,infoNa;
	private String rcpNm,rcpWay2,rcpPat2,infoWgt,hashTag,attFileNoMain,attFileNoMk,rcpPartsDtls,rcpNaTip,userId;
}

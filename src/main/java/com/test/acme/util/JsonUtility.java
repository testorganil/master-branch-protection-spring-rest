package com.test.acme.util;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtility {
	
	private static final Logger logger=LoggerFactory.getLogger(JsonUtility.class);
	public static void createJsonObject(Object protectionMassage, String typeofObject)
	{
		// Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();
 
        try {
 
            // get  object as a json string
            String jsonStr = Obj.writeValueAsString(protectionMassage);
 
            // Displaying JSON String
            logger.info(typeofObject+" : "+jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
		
		
	}


}

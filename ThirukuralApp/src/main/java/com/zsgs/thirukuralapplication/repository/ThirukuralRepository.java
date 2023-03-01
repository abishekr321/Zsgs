package com.zsgs.thirukuralapplication.repository;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.zsgs.thirukuralapplication.dto.Thirukural;



public class ThirukuralRepository {
	Object object;
	Thirukural thirukural;
	
	private static ThirukuralRepository thirukuralRepository;
	
	private ThirukuralRepository() {
		
	}
	
	public static ThirukuralRepository getInstance() {
		
		if(thirukuralRepository==null) {
			thirukuralRepository = new ThirukuralRepository();
			
		}
		return thirukuralRepository;		
	}
	
	
	
	
	
	public Thirukural getThirukuralRepository(int number,String author) {
		
		JSONParser jsonParser = new JSONParser();
		
		try {
			FileReader readFile = new FileReader(".\\src\\assert\\thirukkural.json");
			try {
				object = jsonParser.parse(readFile);
			}
			catch(Exception e) {  //parse exception
			    object = null;
				return null;
			}
			
			JSONObject thirukuralJson = (JSONObject)object;
			JSONArray jsonArray =  (JSONArray)thirukuralJson.get("kural");
			JSONObject kuralJson = (JSONObject)jsonArray.get(number-1);
		    thirukural = new Thirukural(kuralJson,author);

			return thirukural;		    
		}
		catch(Exception e) {
			thirukural=null;
			return thirukural;
			
		}
		
	}
	
	
	public List thirukuralAthigaramName(int number) {
		
		List list = new ArrayList();
		JSONParser jsonParser = new JSONParser();
		
		try {
			
			FileReader reader = new FileReader(".\\src\\assert\\thirukkuralAdhigaramEdited.json");
			try {
				object = jsonParser.parse(reader);
			}
			catch(Exception e) {
				return list;
			}
			
			JSONObject athigaram = (JSONObject)object;
			JSONArray athigaramArray = (JSONArray)athigaram.get("detail");
			JSONObject currentJsonObject = (JSONObject)athigaramArray.get(number-1);
			String athigaramName = (String)currentJsonObject.get("name");
			Long start = (Long)currentJsonObject.get("start");
	
			
			list.add(athigaramName);
			list.add(start);

			
			return list;
	
		}
		catch(Exception e) {
			return list;
		}
		
		
		
	}
	
	
	public List<Thirukural> getAllThirukuralFromAthigaram(long start){
		
		List<Thirukural> tenThirukural = new ArrayList<>();
		
        JSONParser jsonParser = new JSONParser();
		
		try {
		
			FileReader readFile = new FileReader(".\\src\\assert\\thirukkural.json");
			try {
				object = jsonParser.parse(readFile);
			}
			catch(Exception e) {  //parse exception
			    return tenThirukural;
			}
			
			JSONObject thirukuralJson = (JSONObject)object;
			int index=0;
			while(index<10) {
		
			JSONArray jsonArray =  (JSONArray)thirukuralJson.get("kural");
			JSONObject kuralJson = (JSONObject)jsonArray.get((int)start);
		    thirukural = new Thirukural(kuralJson,"mv");
		    start++;
		    index++;
		    tenThirukural.add(thirukural);
			}
		
			return tenThirukural;			    
		}
		catch(Exception e) {
			
			return tenThirukural;
			
		}
	
		
	}
	
	public Scanner getHistory() {
		File file = new File(".\\src\\assert\\ThirukuralHistory.txt");
		Scanner scanner;
		try {
		 scanner = new Scanner(file);
		}
		catch(Exception e) {
			return null;
		}
		return scanner;
	}
	
	public Scanner getSpecialities() {
		File file = new File(".\\src\\assert\\ThirukuralSirrapugal.txt");
		Scanner scanner;
		try {
		  scanner= new Scanner(file);
		}
		catch(Exception e) {
		  return null;
		}
		return scanner;
	}

}


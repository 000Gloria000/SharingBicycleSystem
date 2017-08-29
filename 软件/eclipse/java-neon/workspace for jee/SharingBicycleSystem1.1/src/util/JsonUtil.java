package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	public static JSONArray formatMapToJsonArray(List<Map<String, String>> list) throws SQLException{
		JSONArray array = new JSONArray();
		int size = list.size();
		for(int i=0; i<size; ++i){
			JSONObject mapOfColValues = new JSONObject();
			Map<String, String> map = list.get(i);
			for (String key : map.keySet()) {
				mapOfColValues.put(key, map.get(key));
			}
			array.add(mapOfColValues);
		}
		
		return array;
	}
}

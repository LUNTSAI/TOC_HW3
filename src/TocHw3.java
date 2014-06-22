//import java.util.Map;
import java.util.regex.*;
//import java.lang.*;
//import java.nio.channels.*;
import java.io.*;
import java.net.URL;
import org.json.*;

public class TocHw3 {

public static void main(String[] args) throws JSONException, IOException {
      
		try{    
				URL pageUrl = new URL(args[0]);
				BufferedReader br = new BufferedReader(new InputStreamReader(pageUrl.openStream(), "UTF-8"));
	            BufferedWriter bw = new BufferedWriter(new FileWriter("data.json", false));    
	            String oneLine = null ;
            
	            while ((oneLine = br.readLine()) != null) {
	                bw.write(oneLine);                
	            }
	            bw.close();
	            br.close();
	            //System.out.println("read() running " );     
	            //System.out.println("Done");   
		}catch (IOException e){			// exception handler
			e.printStackTrace();
		}
        
		JSONArray realprice = new JSONArray(new JSONTokener(new FileReader("data.json")));
		Pattern zone = Pattern.compile(args[1]);
		Pattern road = Pattern.compile(args[2]);
		//Pattern year = Pattern.compile(args[3]);
		int ys = Integer.parseInt(args[3]); 
		if(ys<1000){
			ys = ys * 100;
		}
		
		int avg = 0, cnt = 0, i;
		for(i = 0; i < realprice.length(); i++){
			if(zone.matcher(realprice.getJSONObject(i).getString("鄉鎮市區")).find()){
				if(road.matcher(realprice.getJSONObject(i).getString("土地區段位置或建物區門牌")).find()){
					if((realprice.getJSONObject(i).getInt("交易年月")) >= ys){
						cnt++;
						avg += realprice.getJSONObject(i).getInt("總價元");
						System.out.println(realprice.getJSONObject(i));
					}
				}
			}
		}
		if(cnt != 0){
			avg = avg/cnt;
		}
		System.out.println(avg);
		//System.out.println(cnt);
    }
}

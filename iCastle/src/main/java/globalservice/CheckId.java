package globalservice;

public class CheckId {

	public static boolean checkID(String Chk2){
	      String v[][] = {{"A", "台北市"}, {"B", "台中市"}, {"C", "基隆市"},
	         {"D", "台南市"}, {"E", "高雄市"}, {"F", "台北縣"}, {"G", "宜蘭縣"},
	         {"H", "桃園縣"}, {"J", "新竹縣"}, {"K", "苗栗縣"}, {"L", "台中縣"},
	         {"M", "南投縣"}, {"N", "彰化縣"}, {"P", "雲林縣"}, {"Q", "嘉義縣"},
	         {"R", "台南縣"}, {"S", "高雄縣"}, {"T", "屏東縣"}, {"U", "花蓮縣"},
	         {"V", "台東縣"}, {"X", "澎湖縣"}, {"Y", "陽明山"}, {"W", "金門縣"},
	         {"Z", "連江縣"}, {"I", "嘉義市"}, {"O", "新竹市"}
	      };
	 
	      int inte = -1;
	      String s1 = String.valueOf(Character.toUpperCase(Chk2.charAt(0)));
	      for(int i = 0; i < 26; i++){
	         if(s1.compareTo(v[i][0]) == 0){
	            inte = i;
	         }
	      }
	      int total = 0;
	      int all[] = new int[11];
	      String E = String.valueOf(inte + 10);
	      int E1 = Integer.parseInt(String.valueOf(E.charAt(0)));
	      int E2 = Integer.parseInt(String.valueOf(E.charAt(1)));
	      all[0] = E1;
	      all[1] = E2;
	      if("1".equals(String.valueOf(Chk2.charAt(1))) || "2".equals(String.valueOf(Chk2.charAt(1)))){
	    	  try{
	 	         for(int j = 2; j <= 10; j++)
	 	            all[j] = Integer.parseInt(String.valueOf(Chk2.charAt(j - 1)));
	 	         for(int k = 1; k <= 9; k++)
	 	            total += all[k] * (10 - k);
	 	         total += all[0] + all[10];
	 	         if(total % 10 == 0)
	 	            return true;
	 	      }catch(Exception ee){
	 	    	  ee.printStackTrace();
	 	      }
	      }
	      return false;
	   }

}

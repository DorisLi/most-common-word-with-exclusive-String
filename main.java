import java.util.*;  
class Main {
  public static void main(String[] args) {
    String str1 = "I'm Lalit. Lalit, How are you. ";
    String str2 = "i are";

    String str3 = str1.toLowerCase();
    List<String> StrToList = new ArrayList<>(Arrays.asList(str3.split("[\\s,'.]")));

    // get the sorted most common word in asending order
    HashMap<String, Integer> strCountMap = new HashMap<String, Integer>(); 

    // checking each str of strArray 
    for (String c : StrToList) { 
      if (c.trim().isEmpty()) continue;
      if (strCountMap.containsKey(c)) { 
          strCountMap.put(c, strCountMap.get(c) + 1); 
      } 
      else { 
        strCountMap.put(c, 1); 
      } 
    }

    for (String s : Arrays.asList(str2.split(" "))) {
      if (strCountMap.containsKey(s)) strCountMap.remove(s);
    }
    for (Map.Entry entry : strCountMap.entrySet()) { 
        System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
  // real solution
  public List<String> solution(String str, List<String> exclusive){
    String str1 = str.toLowerCase();
    List<String> StrToList = new ArrayList<>(Arrays.asList(str1.split("[\\s,'.]")));
    List<String> result = new ArrayList<String>();

    HashMap<String, Integer> strCountMap = new HashMap<String, Integer>(); 

    // checking each str of strArray 
    for (String c : StrToList) { 
      if (c.trim().isEmpty()) continue;
      if (strCountMap.containsKey(c)) { 
          strCountMap.put(c, strCountMap.get(c) + 1); 
      } 
      else { 
          strCountMap.put(c, 1); 
      } 
    }

    for (String s : exclusive) {
      if (strCountMap.containsKey(s)) strCountMap.remove(s);
    }
    for (Map.Entry entry : strCountMap.entrySet()) { 
      // should we output greater than 1 item only?
      if (entry.getValue() > 1) result.add(entry.getKey().toString());
    }
    return result;
  }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] emails) {
        if(emails==null || emails.length == 0) {System.out.println("the number of result: "+ 0); return;}
        //Map for storing the domainName with the set of localNames
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for(String email : emails){
            char[] emailId = email.toCharArray();
            String domain="";
            String localName = "";
            boolean domainNameStart = false;
            boolean localNameAchieved = false;
            for(char c: emailId){
                if(!localNameAchieved){
                    if(c == '.')continue;
                    else if((c == '+') ) localNameAchieved = true;
                    else if(c=='@'){
                        localNameAchieved = true;
                        domainNameStart = true;
                    }
                    else
                        localName += c;
                } else {
                    if(domainNameStart){
                        domain += 'c';
                    }
                }

            }
            Set<String> set = map.getOrDefault(domain, new HashSet<String>());
            set.add(localName);
            map.put(domain, set);

        }
        final int[] result = new int[1];
        result[0] = 0;
        map.forEach((k, v) -> { result[0] += v.size();
        });
        System.out.println("the number of result: "+ result[0]);
    }
}

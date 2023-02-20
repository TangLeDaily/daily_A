package leetcode_day;

import java.util.HashSet;
import java.util.Set;

public class A011 {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailHash = new HashSet<String>();
        for (String this_email: emails){
            int the_at = this_email.indexOf('@');
            String pre = this_email.substring(0,the_at);
            String after = this_email.substring(the_at);

            pre = pre.split("\\+")[0];
            pre = pre.replace(".","");
            String this_new_email = pre+after;
            emailHash.add(this_new_email);
        }
        return emailHash.size();
    }
}

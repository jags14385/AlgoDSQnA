package findPermutationOfStringinAnother;

import java.util.HashMap;

public class FindPermutationOfStringInAnother {
    public boolean checkInclusion(String searchString, String targetString) {
        if (searchString.length() > targetString.length()) {
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap();
        for (int counter = 0; counter < searchString.length(); counter++) {
            Character c = searchString.charAt(counter);
            if (hm.containsKey(c)) {
                Integer numOccurences = hm.get(c) + 1;
                hm.put(c, numOccurences);
            } else {
                hm.put(c, 1);
            }
        }
        for (int counter = 0; counter < targetString.length(); counter++) {
            Character c = targetString.charAt(counter);
            if (hm.containsKey(c)) {
                Integer numOfOccurences = hm.get(c) - 1;
                hm.put(c, numOfOccurences);
            }
        }
        boolean flag = false;
        for(Character c: hm.keySet()){
            if(hm.get(c) == 0)
                flag = true;
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s1 = "abb";
        String s2 = "eidboa";
        boolean status = new FindPermutationOfStringInAnother().checkInclusion(s1, s2);
        System.out.println(status);
    }

}

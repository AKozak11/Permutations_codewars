import java.util.*;

public class Permutations {

  public static List<String> singlePermutations(String s) {

    List<String> result = new ArrayList<String>();

    if(s.length() == 0) {
      result.add(s);
      return result;
    } else {

      for(int i = 0; i < s.length(); i++) {

        String shorter = s.substring(0,i) + s.substring(i + 1);

        List<String> shorterPs = singlePermutations(shorter);

        for(String str : shorterPs) {

          result.add(s.charAt(i) + str);

        }

      }

      removeDuplicates(result);

      return result;
    }

  }

  public static void removeDuplicates(List<String> words) {

    int size = words.size();
    for(int i = 0; i < words.size()-1; i++) {
      for(int j = i+1; j < words.size(); j++){
        if(words.get(i).equals(words.get(j))){
          words.remove(j);
          j--;
        }

      }

    }

  }

  public static void main(String args[]) {

    System.out.println(singlePermutations("aaaab"));

  }

}

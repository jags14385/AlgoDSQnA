package permutationGeneration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayPermutations {

    public Set<String> generatePermutations(String str) {
        if (str.length() == 1)
            return new HashSet<>(Collections.singleton(str));

        String allCharsExceptLast = str.substring(0, str.length() - 1);
        char lastCharacter = str.charAt(str.length() - 1);

        Set<String> permutationsOfAllCharsExceptLast = generatePermutations(allCharsExceptLast);
        Set<String> permutations = new HashSet<>();

        for (String permutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
            for (int position = 0; position <= permutationOfAllCharsExceptLast.length(); position++) {
                String permutation = permutationOfAllCharsExceptLast.substring(0, position) + lastCharacter +
                        permutationOfAllCharsExceptLast.substring(position);
                permutations.add(permutation);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        StringBuilder str = new StringBuilder();

        for (int num : arr)
            str.append(num);

        // P(123) = All possible combinations of p(12) + 3 over all different positions
        System.out.println(str);
        Set<String> set = new ArrayPermutations().generatePermutations(str.toString());
        System.out.println(set);
    }
}

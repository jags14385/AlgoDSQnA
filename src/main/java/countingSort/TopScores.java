package countingSort;

import java.util.Arrays;

public class TopScores {

    public int[] sortScores(int[] scores,int highestScore){
        int[] counterArray = new int[highestScore+1];
        int[] sortedScores = new int[scores.length];

        //init
        for (int counter=0;counter<highestScore+1;counter++)
            counterArray[counter]=0;

        for (int score : scores)
            counterArray[score]++;

        int index=0;
        for(int counter = highestScore ; counter>= 0; counter--)
        {
            for(int numOfOccurences = 0 ; numOfOccurences < counterArray[counter] ; numOfOccurences++){
                sortedScores[index] = counter;
                index++;
            }
        }
        return sortedScores;
    }

    public static void main(String[] args) {
        int[] unsortedScores = new int[]{37,89,41,65,91,53};
        final int HIGHEST_SCORE = 100;
        int[] sortedScores= new TopScores().sortScores(unsortedScores,HIGHEST_SCORE);
        System.out.println(Arrays.toString(sortedScores));
        // Counting Sort is only possible when you know the highest Possible score ;
    }

}

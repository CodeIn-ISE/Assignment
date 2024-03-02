package Triplet;

import java.util.*;

public class Triplet {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        int target = 18;
      sortTriplet(arr, target);
    }

    public static void sortTriplet(int arr[], int target) {
        Arrays.sort(arr);
        List<List<Integer>> final_triplet=new ArrayList<>(); // For defining lists
        for(int i=0;i<arr.length-2;i++) {
            int sum=target-arr[i];
            int start=i+1;
            int end= arr.length-1;
            while(start<end){
                int total=arr[start]+arr[end];
                if(total==sum){
                    final_triplet.add(Arrays.asList(arr[start],arr[end],arr[i]));
                    start++;
                    end--;
                }
                else if(total<sum){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
//Triplet values without sorting
        System.out.println("Without Sorting the triplet values are:"+final_triplet);
        System.out.println(" ");

// Print the sorted list of lists
        for (List<Integer> innerList : final_triplet) {
            Collections.sort (innerList);
        }
        System.out.println ("Sorted list of lists: " + final_triplet);
        System.out.println(" ");

//        Sorting the values by taking comparsion of first index value
        Collections.sort(final_triplet, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0)-o1.get(0);
            }
        });
        System.out.println("Sorted List of lists by first element: "+final_triplet);
    }
}

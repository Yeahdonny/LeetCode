import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length==0) return 0;
        if (length==1) return (nums1.length > nums2.length) ?  nums1[0] :  nums2[0];
        LinkedList<Integer> q = new LinkedList<>();
        int i = 0, j = 0;
        while(i!=nums1.length || j!= nums2.length){
            if(i==nums1.length){q.add(nums2[j++]);continue;}
            if(j==nums2.length){q.add(nums1[i++]);continue;}

            if(nums1[i] > nums2[j]){
                q.add(nums2[j++]);
            }else q.add(nums1[i++]);
        }

        if(length%2==0){//짝수
            length = length/2;
            return (double)(q.get(length)+q.get(length-1))/2;
        }else return q.get(length/2);
    }
}
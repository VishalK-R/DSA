package com.leet.binarySearch.medium;

public class ReachANumber {

	public static void main(String[] args) {
		System.out.println(reachNumber(-1000000000));
	}

	public static int reachNumber(int target) {
		target = Math.abs(target);
        int ans = getCieling(target);
        int sum = (ans*(ans+1))/2;
        if(sum-target==0) return ans;
		do{
            ans++;
            sum+=ans;
        } while((sum-target)%2!=0) ;
		return ans;
	}

	private static int getCieling(int target) {
		int start = 0, end = target;
		while(start<=end) {
			int mid = start+(end-start)/2;
			long totalCeilingSteps = ((long)mid*(mid+1))/2;
			if(totalCeilingSteps==target) {
				return mid;
			}else if(totalCeilingSteps<target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return end;
	}
}

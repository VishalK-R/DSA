package com.leet.binarySearch.hard;

public class FindInMountainArray {
	
	public static int findInMountainArray(int target, MountainArray mountainArr) {
		int peakIndex = findPeak(mountainArr);
        int leftIndex = binarySearchLeft(mountainArr,0,peakIndex, target);
        int rightIndex = binarySearchRight(mountainArr,peakIndex,mountainArr.length()-1, target);
        if(leftIndex!=-1){
            return leftIndex;
        }else if(rightIndex!=-1){
            return rightIndex;
        }
        return -1;
    }

    private static int findPeak(MountainArray mountainArr){
        int start = 0, end = mountainArr.length()-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                end=mid;
            }else if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                start=mid+1;
            }
        }
        return start;
    }

    private static int binarySearchLeft(MountainArray mountainArr, int start, int end, int target){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }else if(mountainArr.get(mid)<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    private static int binarySearchRight(MountainArray mountainArr, int start, int end, int target){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }else if(mountainArr.get(mid)>target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

}

	interface MountainArray{
		public int get(int index);
		public int length();
	}

/* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
** Instructions to candidate.
**  1) Given an array of non-negative integers representing the elevations
**     from the vertical cross section of a range of hills, determine how
**     many units of snow could be captured between the hills. 
**
**     See the example array and elevation map below.
**                                 ___
**             ___                |   |        ___
**            |   |        ___    |   |___    |   |
**         ___|   |    ___|   |   |   |   |   |   |
**     ___|___|___|___|___|___|___|___|___|___|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**                                 ___
**             ___                |   |        ___
**            |   | *   *  _*_  * |   |_*_  * |   |
**         ___|   | *  _*_|   | * |   |   | * |   |
**     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**
**     Solution: In this example 13 units of snow (*) could be captured.
**  
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement computeSnowpack() correctly.
*/

import java.io.*;
import java.util.*;

class Solution
{
  /*
  **  Find the amount of snow that could be captured.
  */
    public static Integer computeSnowpack(Integer[] arr) {
        // Todo: Implement computeSnowpack
        int low = 0, high = arr.length-1, leftMax = 0, rightMax = 0, ans = 0;
        
        while(low < high) {
            if(arr[low] < arr[high]) {
                if(arr[low] < leftMax) {
                    ans += (leftMax-arr[low]);
                } else {
                    leftMax = arr[low];
                }
                low += 1;
            } else {
                if(arr[high] > rightMax) {
                    rightMax = arr[high];
                } else {
                    ans += (rightMax-arr[high]);
                }
                high -= 1;
            }
        }
        
        
        // System.out.println(ans);
        
        return ans;
    }

  /*
  **  Returns true if the tests pass. Otherwise, returns false;
  */
  public static boolean doTestsPass()
  {
  boolean result = true;
  result &= computeSnowpack(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;
  result &= computeSnowpack(new Integer[]{1,0,0,0,0,0,0,0,0,0,0,1}) == 10;
  result &= computeSnowpack(new Integer[]{0,0,0,0,0}) == 0;
  result &= computeSnowpack(new Integer[]{0,0,1,0,0}) == 0;
  result &= computeSnowpack(new Integer[]{1}) == 0;
  result &= computeSnowpack(new Integer[]{}) == 0;
  
  
  return result;
  }

  /*
  **  Execution entry point.
  */
  public static void main(String[] args)
  {
  if(doTestsPass())
  {
    System.out.println("All tests pass");
  }
  else
  {
    System.out.println("Tests fail.");
  }
  }
}

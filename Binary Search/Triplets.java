import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Triplets {
    public static void main(String[] args) throws Exception {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().split(" ")[0]);
        solution sol = new solution();
        int mod = (int)1e9 + 7;
        while(testCases-->0) {
            String[] string = reader.readLine().split(" ");
            int[] nums = new int[string.length];
            for(int i =0; i < nums.length;i++) {
                nums[i] = Integer.parseInt(string[i]);
            }
            int[] x = new int[nums[0]];
            int[] y = new int[nums[1]];
            int[] z = new int[nums[2]];
            for(int i = 0;i < nums.length;i++) {
                String[] string1 = reader.readLine().split(" ");
                for(int j =0; j < nums[i];j++) {
                    int value = Integer.parseInt(string1[j]);
                    if(i == 0) {
                        x[j] = value;
                    }
                    else if(i == 1) {
                        y[j] = value;
                    }
                    else {
                        z[j] = value;
                    }
                }
            }
            Arrays.sort(x);
            Arrays.sort(y);
            Arrays.sort(z);
            long[] first = new long[x.length];
            long[] second = new long[z.length];
            first[0] = x[0];
            second[0] = z[0];
            for(int i = 1;i < x.length;i++) {
                first[i] = (x[i]%mod + first[i - 1]%mod)%mod;
            }
            for(int i = 1;i < z.length;i++) {
                second[i] =(z[i]%mod+ second[i - 1]%mod)%mod;
            }
            long ans = 0;
            for(int i =0;i < y.length;i++) {
                int index1 = sol.sol(x,y[i]);
                int index2 = sol.sol(z,y[i]);
                long ans1 = 0;
                long ans2 = 0;
                if(index1 > 0 && index2 > 0) {
                    ans1 = (((long) index1 *y[i])%mod + first[index1 - 1]%mod)%mod;
                    ans2 = (((long) index2 *y[i])%mod + second[index2 - 1]%mod)%mod;
                }
                ans += ans1*ans2;
                if(ans > mod) {
                    ans -= mod;
                }
            }
            System.out.println(ans);
        }
    }
}
class solution {
    public int sol(int[] nums,int value) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while(low <= high) {
            int mid = (low + high)>> 1;
            if(nums[mid] > value) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

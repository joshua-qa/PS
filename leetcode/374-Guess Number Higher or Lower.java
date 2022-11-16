// 0ms. 평범해보이지만 함정이 있어서.. 발견하지 못한다면 틀릴 수도 있음.
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long start = 1;
        long end = n;
        long mid;

        while (true) {
            mid = (start + end) / 2;
            int guessResult = guess((int) mid);

            if (guessResult == 0) {
                return (int) mid;
            } else if (guessResult == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
}

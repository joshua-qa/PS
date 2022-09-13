// 3ms. 나름 재밌는데 외국형들 중에서는 싫다는 의견도 보이네
class Solution {
    public boolean validUtf8(int[] data) {
        int curr = 0, length = data.length;

        while (curr < length) {
            int byteSize = getByteSize(data[curr]);
            if (byteSize == -1) {
                return false;
            }

            if (byteSize == 1) {
                curr++;
                continue;
            }
            int remain = byteSize - 1;

            while (remain > 0) {
                curr++;
                if (curr == length) {
                    return false;
                }
                int twoBit = data[curr] & 192;
                if (twoBit != 128) {
                    return false;
                }
                remain--;
            }
            curr++;
        }
        return true;
    }

    private int getByteSize(int firstByte) {
        int masked = firstByte & 240;
        if (masked == 240) {
            return (firstByte & 8) == 0 ? 4 : -1;
        }
        if (masked == 224) {
            return (firstByte & 16) == 0 ? 3 : -1;
        }
        if (masked >= 192) {
            return (firstByte & 32) == 0 ? 2 : -1;
        }
        if (masked < 128) {
            return 1;
        }
        return -1;
    }
}

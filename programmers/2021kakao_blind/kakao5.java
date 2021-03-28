import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = dateToInt(play_time);
        int advTime = dateToInt(adv_time);
        int length = logs.length;
        long max = 0;
        int maxIndex = 0;
        Timeline[] userLogs = new Timeline[length];
        int[] counts = new int[playTime+2];
        for (int i = 0; i < length; i++) {
            String[] log = logs[i].split("-");
            userLogs[i] = new Timeline(dateToInt(log[0]), dateToInt(log[1]));
        }
        Arrays.sort(userLogs);
        int advStart = userLogs[0].getStart();
        int advEnd = userLogs[length-1].getEnd();
        int advLength = advEnd - advStart;
        int noAdvTime = 0;

        for (Timeline timeline : userLogs) {
            int start = timeline.getStart();
            int end = timeline.getEnd();
            counts[start+1]++;
            counts[end+1]--;
        }
        for (int i = 1; i <= playTime; i++) {
            counts[i] = counts[i-1] + counts[i];
        }
        long[] timeSum = new long[playTime+2];
        for (int i = 1; i <= playTime; i++) {
            timeSum[i] = timeSum[i-1] + (long) counts[i];
        }
        if (advTime > advLength) {
            noAdvTime = advTime - advLength;
            advTime = advLength;
        }
        for (int i = 0; i <= playTime-advTime+1; i++) {
            long currentAdvTime = timeSum[i+advTime] - timeSum[i];
            if (max < currentAdvTime) {
                max = currentAdvTime;
                maxIndex = i;
            }
        }
        maxIndex = Math.max(0, maxIndex - noAdvTime);
        return intToDate(maxIndex);
    }

    private int dateToInt(String dateTime) {
        String[] date = dateTime.split(":");
        int hour = Integer.parseInt(date[0]) * 3600;
        int minute = Integer.parseInt(date[1]) * 60;
        int second = Integer.parseInt(date[2]);
        return hour + minute + second;
    }

    private String intToDate(int timeStamp) {
        int hour = timeStamp / 3600;
        String hourText = hour < 10 ? "0" + hour : String.valueOf(hour);
        timeStamp %= 3600;
        int minute = timeStamp / 60;
        String minuteText = minute < 10 ? "0" + minute : String.valueOf(minute);
        timeStamp %= 60;
        String secondText = timeStamp < 10 ? "0" + timeStamp : String.valueOf(timeStamp);
        return String.join(":", hourText, minuteText, secondText);
    }
}

class Timeline implements Comparable<Timeline> {
    int start;
    int end;

    public Timeline(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Timeline o) {
        return this.start - o.start;
    }
}
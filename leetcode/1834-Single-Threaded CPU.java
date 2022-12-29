// 195ms. 딴짓하면서 풀어서 그런가... 문제가 약간 복잡한 것도 있는데 너무 오래 걸렸다.
// Solution 댓글중에 "One of the questions I was proud to solve after couple wrong ideas" 라는 말이 좀 공감.
// 헷갈리거나 시간초과 낼만한 요소가 숨어있고, 풀어보길 잘한 문제라고 생각
class Solution {
    public int[] getOrder(int[][] tasks) {
        int length = tasks.length;
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.enqueueTime - o2.enqueueTime;
            }
        });
        PriorityQueue<Job> executionQueue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.processingTime == o2.processingTime) {
                    return o1.index - o2.index;
                }
                return o1.processingTime - o2.processingTime;
            }
        });

        for (int i = 0; i < length; i++) {
            jobQueue.offer(new Job(i, tasks[i][0], tasks[i][1]));
        }

        List<Integer> result = new ArrayList<>();
        int currentTime = jobQueue.peek().enqueueTime;
        while (!jobQueue.isEmpty() || !executionQueue.isEmpty()) {
            if (!executionQueue.isEmpty()) {
                Job currentJob = executionQueue.poll();
                currentTime += currentJob.processingTime;
                result.add(currentJob.index);
            }

            while (!jobQueue.isEmpty() && jobQueue.peek().enqueueTime <= currentTime) {
                executionQueue.offer(jobQueue.poll());
            }
            if (executionQueue.isEmpty() && !jobQueue.isEmpty()) {
                currentTime = jobQueue.peek().enqueueTime;
            }
        }

        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

class Job {
    int index;
    int enqueueTime;
    int processingTime;

    public Job(int index, int enqueueTime, int processingTime) {
        this.index = index;
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int size = positions.length;
        Robot[] robots = new Robot[size];
        for (int i = 0; i < size; i++) {
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }

        Arrays.sort(robots, new Comparator<Robot>() {
            @Override
            public int compare(Robot o1, Robot o2) {
                return o1.position - o2.position;
            }
        });

        Stack<Robot> stack = new Stack<>();
        for (int i = 0; i < robots.length; i++) {
            // 구현
            // 비어 있거나 peek의 dir이 현재와 동일한 경우, 혹은 현재가 R인데 peek이 L인 경우
            if (stack.isEmpty()) {
                stack.push(robots[i]);
                continue;
            }

            Robot peek = stack.peek();
            if (robots[i].dir == peek.dir || (robots[i].dir == 1 && peek.dir == 0)) {
                stack.push(robots[i]);
                continue;
            }

            // peek이 R이고 현재가 L인 경우 -> 해당하지 않는 상황이 나올때까지 반복
            if (robots[i].dir == 0 && peek.dir == 1) {
                while (!stack.isEmpty() && peek.dir == 1) {
                    if (peek.hp > robots[i].hp) {
                        peek.hp--;
                        robots[i].hp = 0;
                        break;
                    } else if (peek.hp < robots[i].hp) {
                        robots[i].hp--;
                        stack.pop();
                        if (!stack.isEmpty()) {
                            peek = stack.peek();
                        }
                        continue;
                    } else {
                        // peek.hp == robots[i].hp
                        stack.pop();
                        robots[i].hp = 0;
                        break;
                    }
                }
                if (robots[i].hp > 0) {
                    stack.push(robots[i]);
                }
            }
        }

        if (stack.isEmpty()) {
            return new ArrayList<>();
        }

        List<Robot> remainRobots = new ArrayList<>();
        while (!stack.isEmpty()) {
            remainRobots.add(stack.pop());
        }

        Collections.sort(remainRobots, new Comparator<Robot>() {
            @Override
            public int compare(Robot o1, Robot o2) {
                return o1.originIndex - o2.originIndex;
            }
        });

        return remainRobots.stream().map(robot -> robot.hp).toList();
    }

    class Robot {
        int originIndex;
        int position;
        int hp;
        int dir;

        public Robot(int originIndex, int position, int hp, char direction) {
            this.originIndex = originIndex;
            this.position = position;
            this.hp = hp;
            this.dir = direction == 'R' ? 1 : 0;
        }
    }
}

// 34ms. 적당히 빨리 풀었고 코드도 짧아서 만족. StringTokenizer 굉장히 오랜만에 써본다
import java.util.*;
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> files = new HashMap<>();
        for (String path : paths) {
            StringTokenizer st = new StringTokenizer(path);
            String dir = st.nextToken();
            while (st.hasMoreTokens()) {
                String[] file = st.nextToken().split("\\(");
                String fileName = file[0];
                String fileContent = file[1].substring(0, file[1].length()-1);
                if (!files.containsKey(fileContent)) {
                    files.put(fileContent, new ArrayList<>());
                }
                files.get(fileContent).add(dir + "/" + fileName);
            }
        }
        return files.values().stream().filter(fileList -> fileList.size() > 1).collect(Collectors.toList());
    }
}

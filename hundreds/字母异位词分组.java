package hundreds;

import java.util.*;

/**
 * @author: jackie
 * @date: 2023/7/18 11:26
 **/
public class 字母异位词分组 {

    /**
     * 关键点 排序+哈希表
     * 同一个List中的元素都是由相同的字母组成，遍历strs数组时将所有str排序，将排序后的str作为key，未排序的str作为list中的元素
     * 通过哈希表在循环结束后就能找到同一个key下的所有词组
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            //将字母排序
            Arrays.sort(charArray);
            String key = charArray.toString();
            //获取同一个key所在的list
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            //将str添加到list中
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

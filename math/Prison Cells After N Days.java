class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, int[]> map = new HashMap<>();
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int[] nums = new int[8];
        StringBuilder string = new StringBuilder();
        int count = 0;
        int startIndex = -1;
        for (int i = 0; i < n; i++) {
            nums = new int[8];
            string = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                string.append(cells[j]);
            }
            String string1 = string.toString();
            if (!map.containsKey(string1)) {
                int[] nums1 = new int[8];
                for (int j = 0; j < 8; j++) {
                    nums1[j] = cells[j];
                }
                map.put(string1, nums1);
                map1.put(count, string1);
                map2.put(string1, count++);
            } else {
                startIndex = map2.get(string1);
                break;
            }
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    nums[j] = 0;
                } else if (j == 7) {
                    nums[j] = 0;
                } else {
                    int value1 = cells[j - 1];
                    int value2 = cells[j + 1];
                    if (value1 == value2) {
                        nums[j] = 1;
                    } else {
                        nums[j] = 0;
                    }
                }
            }
            cells = nums;
        }
        if(startIndex == -1) {
            return cells;
        }
        int cycleLength = count - startIndex;
        int value3 = (n - startIndex) % cycleLength;
        int value4 = startIndex + value3;
        String string2 = map1.get(value4);
        return map.get(string2);
    }
}

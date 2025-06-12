class Solution {
    public int f(char c) {
        return CharMapper.getNumberFromChar(c);
    }
    public List<Integer> diffWaysToCompute(String str) {
       
        String expression = CharMapper.convertExpression(str);
        System.out.println(expression);
         int n = expression.length();
        List<Integer>[][] list = new ArrayList[n][n];
        for(int i = 0;i < n;i++) {
            for(int j =0;j < n;j++) {
                list[i][j] = new ArrayList<>();
            }
        }
        for(int i =0;i < n;i = i + 2) {
            int value = f(expression.charAt(i));
            List<Integer> list1 = new ArrayList<>();
            list1.add(value);
            list[i][i] = list1;
        }
        for(int len = 2;len <n;len= len + 2) {
           for(int i = 0;i < n;i= i + 2) {
             int j = i + len;
             if(j > n) {
                continue;
             }
             List<Integer> temp = new ArrayList<>();
             for(int k = i + 1;k < j ;k = k + 2) {
                if((k+ 1) >  n) {
                    continue;
                }
                List<Integer> list1 = list[i][k - 1];
                List<Integer> list2 = list[k+1][j];
                for(int h:list1) {
                    for(int p:list2) {
                        int value;
                        if(expression.charAt(k) == '-') {
                            value = h - p;
                        }
                        else if(expression.charAt(k) == '+') {
                            value = h + p;
                        }
                        else {
                            value = h*p;
                        }
                        temp.add(value);
                    }
                }
             }
             if(j < n) {
                list[i][j] = temp;
             }
             
           }
        }
        return list[0][n - 1];
    }
}


class CharMapper {
    private static final Map<Integer, Character> numToCharMap = new HashMap<>();
    private static final Map<Character, Integer> charToNumMap = new HashMap<>();

    static {
        String charPool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" +
                  "!@#%^&()_=[]{}`~:;\"'<>?,./\\|€£¥₩©®±§¶µ¢¿¡†‡•…‰‹›";
        for (int i = 0; i < 100; i++) {
            char ch = charPool.charAt(i);
            numToCharMap.put(i, ch);
            charToNumMap.put(ch, i);
        }
    }

    public static char getCharFromNumber(int number) {
        if (number < 0 || number > 99) {
            throw new IllegalArgumentException("Number must be between 0 and 99.");
        }
        return numToCharMap.get(number);
    }

    public static int getNumberFromChar(char ch) {
        if (!charToNumMap.containsKey(ch)) {
            throw new IllegalArgumentException("Character not mapped: " + ch);
        }
        return charToNumMap.get(ch);
    }

    public static String convertExpression(String expr) {
        StringBuilder result = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for (char ch : expr.toCharArray()) {
            if (Character.isDigit(ch)) {
                num.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*') {
                if (num.length() > 0) {
                    int val = Integer.parseInt(num.toString());
                    result.append(getCharFromNumber(val));
                    num.setLength(0);
                }
                result.append(ch);
            } else {
                throw new IllegalArgumentException("Unsupported character in expression: " + ch);
            }
        }

        if (num.length() > 0) {
            int val = Integer.parseInt(num.toString());
            result.append(getCharFromNumber(val));
        }

        return result.toString();
    }
}

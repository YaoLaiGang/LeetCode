package simplifyPath;

import java.util.Stack;

/*
* 简化路径字符串
* 将../ ./ 简化
* 将// 简化
* 最后要转化为绝对路径：结尾无/， 开头有/
* */
/*Input: "/home//foo/"
        Output: "/home/foo"
        Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.*/
/*Input: "/a/./b/../../c/"
        Output: "/c"*/
/*Input: "/a//b////c/d//././/.."
        Output: "/a/b/c"*/
// 注意，文件名可能是多个.比如‘...’
public class Solution {
    /*
    * 思路：使用栈
    *
    * 遇到 ‘/’
    *   栈顶为一个 . 直接pop
    *   若为两个. pop出一个/ , 直到遇到第二个/
    *   若栈顶为/ , 不动
    * 遇到. 其他字母。 直接push
    * 最后要除一下末尾的/
    * */
    public String simplifyPath(String path) {
        char[] p = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char tmp;
        for (char ch :
                p) {
            if (ch == '/') {
                if (stack.isEmpty()){
                    stack.push(ch);
                    continue;
                }
                tmp = stack.peek();
                if (tmp == '.'){
                    stack.pop();//一个.
                    if (stack.peek()=='.'){//两个
                        stack.pop();
                        if (stack.peek()=='.'){// 三个
                            stack.push('.');
                            stack.push('.');
                        }else{
                            int count = 0;
                            while (stack.size()!=1&&(stack.peek()!='/' || count!=1)){
                                tmp = stack.pop();
                                if (tmp == '/') ++count;
                            }
                        }
                    }

                }else if (tmp != '/'){
                    stack.push(ch);
                }
            }else {
                stack.push(ch);
            }
        }
        if (!stack.isEmpty()&&stack.peek()=='.'){
            stack.pop();//一个.
            if (stack.peek()=='.'){//两个.
                stack.pop();
                if (stack.peek()=='.'){// 三个
                    stack.push('.');
                    stack.push('.');
                }else{
                    int count = 0;
                    while (stack.size()!=1&&(stack.peek()!='/' || count!=1)){
                        tmp = stack.pop();
                        if (tmp == '/') ++count;
                    }
                }
            }
        }
        if (stack.size()>1&&stack.peek()=='/') stack.pop();
//        if (stack.isEmpty()) stack.push('/');
        for (char ch :
                stack) {
            sb.append(ch);
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/...."));
    }
}

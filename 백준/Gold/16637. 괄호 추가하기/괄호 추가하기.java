import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String expression;
    static long max_result = Long.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expression = br.readLine();

        if (N == 1) {
            System.out.println(expression);
        } else {
            dfs(0, 0);
            System.out.println(max_result);
        }
    }

    static void dfs(int idx, long current) {
        if (idx >= N) {
            max_result = Math.max(max_result, current);
            return;
        }
        long num = expression.charAt(idx) - '0';
        char op = idx == 0 ? '+' : expression.charAt(idx - 1);

        dfs(idx + 2, calculate(current, num, op));

        if (idx + 2 < N) {
            long bracketResult = bracket(idx);
            if (idx == 0) {
                dfs(idx + 4, bracketResult);
            } else {
                dfs(idx + 4, calculate(current, bracketResult, op));
            }
        }

    }

    static long calculate(long a, long b, char op) {
        long result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;

        }

        return result;
    }

    static long bracket(int idx) {
        long a = expression.charAt(idx) - '0';
        long b = expression.charAt(idx + 2) - '0';
        char op = expression.charAt(idx + 1);

        return calculate(a, b, op);

    }

}
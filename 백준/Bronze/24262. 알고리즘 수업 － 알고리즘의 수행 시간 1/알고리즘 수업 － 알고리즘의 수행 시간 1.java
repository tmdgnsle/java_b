public class Main {
    
    public static int MenOfPassion(int[] A, int n) {
        return A[n/2]; // 알고리즘은 단순히 배열의 중간 요소를 반환합니다
    }
    
    public static void main(String[] args) {
        // 이 알고리즘은 입력 크기와 상관없이 항상 동일한 수의 연산을 수행합니다
        // 따라서 시간 복잡도는 O(1)입니다
        
        System.out.println("1"); // 수행 횟수는 항상 1번
        System.out.println("0"); // 다항식의 차수는 0 (상수 시간)
    }
}
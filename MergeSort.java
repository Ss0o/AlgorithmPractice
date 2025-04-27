public class MergeSort {
    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }
    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if( start < end ) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }
    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if(tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }
    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {3,9,4,7,5,0,1,6,8,2};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}
/*
    실행 흐름
    mergeSort함수에서 임시저장공간 tmp를 만들고 오버로딩한 mergeSort함수 재호출
    오버로딩한 mergeSort함수는 재귀를 통해 반으로 분할(log n) 후 병합하는 함수 merge호출
    병합하는 함수 merge에서는 임시저장공간에 값을 복사해넣고
    왼쪽 partition과 오른쪽 partition을 비교할 인덱스 part1, part2 설정(part1 = start, part2 = mid + 1)
    비교 후 arr에 index에 순서대로 넣음(index = start)

 */
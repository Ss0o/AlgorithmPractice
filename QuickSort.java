public class QuickSort {
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        if (start < part2 - 1) {
            quickSort(arr, start, part2 -1);
        }
        if (part2 < end) {
            quickSort(arr, part2, end);
        }

    }
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap (arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
    private static void swap (int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
    private static void printArray (int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {3,9,4,7,5,0,1,6,8,2};
        quickSort(arr);
        printArray(arr);
    }
}

/*
    실행 흐름
    quickSort함수에서 시작(좌측)값과 끝(우측)값을 오버로딩한 quickSort함수를 호출
    오버로딩한 quickSort함수에서는 partition함수를 통해 전달받은 pivot값(part2)을 기준으로 좌측, 우측 부분집합으로 나누어
    quickSort함수 재귀 호출
    partition함수는 pivot값을 기준으로 좌, 우를 swap을 통해 정렬함 (pivot은 start와 end의 중간 값을 넣은 arr값)

 */

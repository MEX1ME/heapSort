public class HeapSort {
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Построение max-кучи
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Восстанавливает max-кучу с корнем в вершине i
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // Левый ребенок узла i
        int right = 2 * i + 2; // Правый ребенок узла i

        // Если левый дочерний элемент больше текущего наибольшего элемента
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Если правый дочерний элемент больше текущего наибольшего элемента
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Если наибольший элемент не является корневым
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно heapify поддерево
            heapify(arr, n, largest);
        }
    }

    // Вспомогательная функция для печати массива
    private void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Тестирование алгоритма
    public static void main(String args[]) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

        System.out.println("Отсортированный массив:");
        heapSort.printArray(arr);
    }
}
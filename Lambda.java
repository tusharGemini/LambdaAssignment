import java.util.stream.DoubleStream;

public class Lambda {
    public static final ArrayProcessor MINIMUM_VALUE = (arr) -> DoubleStream.of(arr).min().getAsDouble();
    public static final ArrayProcessor MAXIMUM_VALUE = (arr) -> DoubleStream.of(arr).max().getAsDouble();
    public static final ArrayProcessor TOTAL_SUM = (arr) -> DoubleStream.of(arr).sum();
    public static final ArrayProcessor AVERAGE_VALUE = (arr) -> DoubleStream.of(arr).average().getAsDouble();

    public static ArrayProcessor counter(double value) {
        return (arr) -> DoubleStream.of(arr).filter(element -> element == value).count();
    }

    public static void main(String [] args) {
        double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 1.1, 3.33};

        System.out.println("Maximum value in the array is - " + MAXIMUM_VALUE.apply(arr));
        System.out.println("Minimum value in the array is - " + MINIMUM_VALUE.apply(arr));
        System.out.println("Sum of values in the array is - " + TOTAL_SUM.apply(arr));
        System.out.println("Average of the values in the array is - " + AVERAGE_VALUE.apply(arr));

        int valueCount = (int) Lambda.counter(1.1).apply(arr);
        System.out.println("Number of times a value occurred - " + valueCount);
    }
}
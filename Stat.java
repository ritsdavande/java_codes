package mymath;
import java.util.List;
public class Stat {
    public double min(List<Double> numbers) {
        return numbers.stream().min(Double::compare).orElse(Double.NaN);
    }
    public double max(List<Double> numbers) {
        return numbers.stream().max(Double::compare).orElse(Double.NaN);
    }
    public int count(List<Double> numbers) {
        return numbers.size();
    }
    public double sum(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }
    public double average(List<Double> numbers) {
        return sum(numbers) / count(numbers);
    }
}

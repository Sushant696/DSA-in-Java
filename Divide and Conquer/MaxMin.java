/**
 * MaxMin
 */
public class MaxMin {

  public static class Result {
    int max;
    int min;

    Result(int max, int min) {
      this.max = max;
      this.min = min;
    }

    public String toString() {
      return "Max : " + max + " Min : " + min;
    }
  }

  public static Result minMax(int a[], int high, int low) {
    int min, max;

    if (high == low) {
      return new Result(a[high], a[low]);
    }
    if (high == low + 1) {
      if (a[high] > a[low]) {
        return new Result(a[high], a[low]);
      } else {
        return new Result(a[low], a[high]);
      }
    }

    // Divide
    int mid = (high + low) / 2;
    Result lResult = minMax(a, low, mid);
    Result rResult = minMax(a, mid + 1, high);

    // conquer
    max = Math.max(lResult.max, rResult.max);
    min = Math.min(lResult.min, rResult.min);

    return new Result(max, min);
  }

  public static void main(String[] args) {
    int a[] = { 1, -2, 453, 24, 35, 60, -7, 8, 9, 1 };
    Result result = minMax(a, a.length - 1, 0);
    System.out.println(result);
  }
}

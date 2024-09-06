package ae.hackerrank.interview_preparation_kit.greedy_algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LuckBalance.
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/greedy_algorithms/luck-balance.md]]
 */
public class LuckBalance {

  private class Competition {
    private int luck;
    private int important;

    Competition(int luck, int important) {
      this.luck = luck;
      this.important = important;
    }

    public int getLuck() {
      return this.luck;
    }

    public int getImportant() {
      return this.important;
    }
  }

  private LuckBalance() { }

  /**
   * luckBalance.
   *
   * @link https://www.baeldung.com/java-sort-collection-multiple-fields#use-comparatorcomparing-and-lambda-expression
   */
  public static int luckBalance(int k, List<List<Integer>> contests) {
    List<Competition> importantCompetitions = new ArrayList<>();
    List<Competition> nonimportantCompetitions = new ArrayList<>();

    for (var x : contests) {
      Integer luck = x.get(0);
      Integer important = x.get(1);

      if (important == 1) {
        importantCompetitions.add(new LuckBalance().new Competition(luck, important));
      } else {
        nonimportantCompetitions.add(new LuckBalance().new Competition(luck, important));
      }
    }

    importantCompetitions = importantCompetitions
      .stream()
      .sorted(
        Comparator
          .comparing(Competition::getImportant).reversed()
          .thenComparing(Competition::getLuck).reversed()
      )
      .collect(Collectors.toList());

    int total = 0;
    int size = importantCompetitions.size();

    for (int i = 0; i < Math.min(k, size); i++) {
      total += importantCompetitions.get(i).getLuck();
    }

    for (int i = Math.min(k, size); i < size; i++) {
      total -= importantCompetitions.get(i).getLuck();
    }

    for (Competition x : nonimportantCompetitions) {
      total += x.luck;
    }

    return total;
  }
}

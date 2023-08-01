// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Names scores
 *
 * https://projecteuler.net/problem=22
 *
 * Using listOfNames.txt https://projecteuler.net/project/resources/p022_listOfNames.txt
 * (right click and 'Save Link/Target As...'),
 * a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for
 * each name, multiply this value by its alphabetical position
 * in the list to obtain a name score.
 *
 * For example, when the list is sorted into
 * alphabetical order, COLIN, which
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the
 * 938th name in the list. So, COLIN would obtain
 * a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 // ////////////////////////////////////////////////////////////////////////////
 // See:
 //    - src/main/java/projecteuler/data/p022_names.txt
 //    - src/main/java/projecteuler/data/Problem0022Data.json
 // ///////////////////////////////////////////////////////////////////////////
*/

package ae.projecteuler;

import ae.projecteuler.helper.WordScore;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Problem 0022.
 */
public class Problem0022 {

  private Problem0022() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0022.
   */
  public static Integer problem0022(String[] listOfNames) {
    List<String> names = Arrays.asList(listOfNames);
    Collections.sort(names);

    int result = 0;

    for (int i = 0; i < names.size(); i++) {
      result += (i + 1) * WordScore.wordScore(names.get(i));
    }

    logger.info(String.format("Problem 00022 solved: %d", result));

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph

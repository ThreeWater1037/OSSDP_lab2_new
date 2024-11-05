import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * 等价类划分
 * 典型输入等价类：
 * 输入包含多个用户，每个用户的收藏清单各不相同，且有些清单是其他清单的子集。
 * 示例：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 空列表等价类：
 * 输入为空列表，没有任何用户的收藏清单。
 * 示例：favoriteCompanies = []
 * 单元素列表等价类：
 * 每个用户的收藏清单都只包含一个公司。
 * 示例：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * 最大允许元素等价类：
 * 每个用户的收藏清单包含最大允许数量的公司。
 * 示例：favoriteCompanies = [["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"], ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"]]
 * 重复公司等价类：
 * 不同用户的收藏清单中包含重复的公司。
 * 示例：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","google","facebook"],["google","microsoft"]]
 */

class _2022112055_6_Test {

    // 测试主要功能，使用典型输入
    @Test
    public void testPeopleIndexes_TypicalInput() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"),
                Arrays.asList("google", "facebook"),
                List.of("google"),
                List.of("amazon")
        );
        List<Integer> expected = Arrays.asList(0, 1, 4);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    // 测试空列表的边缘情况
    @Test
    public void testPeopleIndexes_EmptyList() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = List.of();
        List<Integer> expected = List.of();
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    // 测试单元素列表的边缘情况
    @Test
    public void testPeopleIndexes_SingleElementLists() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
                List.of("leetcode"),
                List.of("google"),
                List.of("facebook"),
                List.of("amazon")
        );
        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    // 测试包含最大允许元素的边缘情况
    @Test
    public void testPeopleIndexes_MaxElements() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"),
                Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t")
        );
        List<Integer> expected = Arrays.asList();
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    // 测试不同列表中包含重复公司的边缘情况
    @Test
    public void testPeopleIndexes_DuplicateCompanies() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft")
        );
        List<Integer> expected = List.of(2);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 *
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 *
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 输出：[0,1,4]
 * 解释：
 * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
 * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
 * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
 * 示例 2：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * 输出：[0,1]
 * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
 * 示例 3：
 *
 * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * 输出：[0,1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= favoriteCompanies.length <= 100
 * 1 <= favoriteCompanies[i].length <= 500
 * 1 <= favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] 中的所有字符串 各不相同 。
 * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
 * 所有字符串仅包含小写英文字母。
 *
 */
/*
class Solution6 {
    Set<String>[] s = new Set[105];

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        for (int i = 1; i < 105; ++i) {
            s[i] = new HashSet<String>();
        }
        int n = favoriteCompanies.size()-1;
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < n; ++i) {
            for (String com : favoriteCompanies.get(i)) {
                s[i].add(com);
            }

            for (int i = 0; i < n; ++i) {
                boolean isSub = false;
                for (int j = 0; j < n; ++j) {
                    if (i == j) {
                        continue;
                    }
                    isSub |= check(favoriteCompanies, i, j);
                }
                if (isSub) {
                    ans.add(i);
                }
            }

            return ans;
        }

        public boolean check(List<List<String>> favoriteCompanies, int x, int y) {
            for (String com : favoriteCompanies.get(x)) {
                if (!s[y].contains(com)) {
                    return false;
                }
            }
            return true;
        }
    }
*/

class Solution6 {
    // 定义一个Set数组，存储每个人的收藏清单
    Set<String>[] s = new Set[105];

    // 主方法，返回不是其他任何人收藏的公司清单的子集的收藏清单的下标
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // 初始化Set数组
        for (int i = 0; i < 105; ++i) {
            s[i] = new HashSet<String>();
        }
        int n = favoriteCompanies.size(); // 获取收藏清单的数量
        List<Integer> ans = new ArrayList<Integer>(); // 存储结果的列表

        // 将每个人的收藏清单存储到Set数组中
        for (int i = 0; i < n; ++i) {
            for (String com : favoriteCompanies.get(i)) {
                s[i].add(com);
            }
        }

        // 遍历每个人的收藏清单，判断是否是其他人的子集
        for (int i = 0; i < n; ++i) {
            boolean isSub = false; // 标记是否是子集
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue; // 跳过自己
                }
                isSub |= check(favoriteCompanies, i, j); // 检查是否是子集
            }
            if (!isSub) {
                ans.add(i); // 如果不是子集，加入结果列表
            }
        }

        return ans; // 返回结果列表
    }

    // 辅助方法，检查x是否是y的子集
    public boolean check(List<List<String>> favoriteCompanies, int x, int y) {
        for (String com : favoriteCompanies.get(x)) {
            if (!s[y].contains(com)) {
                return false; // 如果x中的某个公司不在y中，返回false
            }
        }
        return true; // 如果x中的所有公司都在y中，返回true
    }
}

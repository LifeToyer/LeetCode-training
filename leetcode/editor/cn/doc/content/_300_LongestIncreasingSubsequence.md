<p>给你一个整数数组 <code>nums</code> ，找到其中最长严格递增子序列的长度。</p>

<p><strong>子序列&nbsp;</strong>是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，<code>[3,6,2,7]</code> 是数组 <code>[0,3,1,6,2,2,7]</code> 的子序列。</p> &nbsp;

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [10,9,2,5,3,7,101,18]
<strong>输出：</strong>4
<strong>解释：</strong>最长递增子序列是 [2,3,7,101]，因此长度为 4 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,0,3,2,3]
<strong>输出：</strong>4
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [7,7,7,7,7,7,7]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 2500</code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b></p>

<ul> 
 <li>你能将算法的时间复杂度降低到&nbsp;<code>O(n log(n))</code> 吗?</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 动态规划</details><br>

<div>👍 3325, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=longest-increasing-subsequence" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 96 页。

`dp` 数组的定义：`dp[i]` 表示以 `nums[i]` 这个数结尾的最长递增子序列的长度。

那么 `dp` 数组中最大的那个值就是最长的递增子序列长度。

**详细题解：[动态规划设计：最长递增子序列](https://labuladong.github.io/article/fname.html?fname=动态规划设计：最长递增子序列)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，子序列**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        vector<int> dp(nums.size(), 1);/**<extend down -200>![](https://labuladong.github.io/pictures/最长递增子序列/5.jpeg) */
        // base case：dp 数组全都初始化为 1

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.size(); i++) {
            res = max(res, dp[i]);
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        dp = [1] * len(nums)

        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return max(dp)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];/**<extend down -200>![](https://labuladong.github.io/pictures/最长递增子序列/5.jpeg) */
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func lengthOfLIS(nums []int) int {
    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    dp := make([]int, len(nums))
    // base case：dp 数组全都初始化为 1
    for i := 0; i < len(dp); i++ {
        dp[i] = 1
    }

    for i := 0; i < len(nums); i++ {
        for j := 0; j < i; j++ {
            if nums[i] > nums[j] {
                dp[i] = max(dp[i], dp[j]+1)
            }
        }
    }

    res := 0
    for i := 0; i < len(dp); i++ {
        res = max(res, dp[i])
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var lengthOfLIS = function(nums) {
    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    let dp = new Array(nums.length).fill(1);/**<extend down -200>![](https://labuladong.github.io/pictures/最长递增子序列/5.jpeg) */
    // base case：dp 数组全都初始化为 1

    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }

    let res = 0;
    for (let i = 0; i < dp.length; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_longest-increasing-subsequence" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-increasing-subsequence"></div></div>
</details><hr /><br />

**类似题目**：
  - [354. 俄罗斯套娃信封问题 🔴](/problems/russian-doll-envelopes)
  - [53. 最大子数组和 🟠](/problems/maximum-subarray)
  - [剑指 Offer 42. 连续子数组的最大和 🟢](/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof)

</details>
</div>


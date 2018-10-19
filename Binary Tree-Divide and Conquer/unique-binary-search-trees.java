/*

DP using Catanla 树

https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/
DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)/164557
G(n) = F(1, n) + F(2, n) + ... + F(n, n).
            F(j, n) = G(j-1) * G(n-j)	1 <= j <= n

        So  G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)



https://blog.csdn.net/oNever_say_love/article/details/49420631


I think input 0 is special case for function F(i, n) when i = 1 or i = n.
If i = 1 (1 as root), the left sub-tree will be empty and F(1, n) only need to
consider the right sub-tree, thus F(1, n) = 1 * G(n-1). Similar idea if i = n.
*/


public int numTrees(int n) {
    int [] G = new int[n+1];
    G[0] = G[1] = 1;

    for(int i=2; i<=n; ++i) {
    	for(int j=1; j<=i; ++j) {
    		G[i] += G[j-1] * G[i-j];
    	}
    }

    return G[n];
}

//same idea

int numTrees(int n) {
    //cantalan树
    //C(2n,n)/(n+1)
    long long ans =1;
    for(int i=n+1;i<=2*n;i++){
        ans = ans*i/(i-n);
    }
    return ans/(n+1);
}

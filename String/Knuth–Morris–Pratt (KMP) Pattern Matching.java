// JAVA program for implementation of KMP pattern
// searching algorithm

class KMP_String_Matching
{
	void KMPSearch(String pat, String txt)
	{
		int M = pat.length();
		int N = txt.length();


		int lps[] = new int[M];
		int j = 0; // index for pat[]


		computeLPSArray(pat,M,lps);

		int i = 0; // index for txt[]
		while (i < N)
		{
			if (pat.charAt(j) == txt.charAt(i))
			{
				j++;
				i++;
			}
			if (j == M)//Found pattern +at index + (i-j)
			{
				j = lps[j-1];
			}
			// mismatch after j matches
			else if (i < N && pat.charAt(j) != txt.charAt(i))
			{
				if (j != 0)
					j = lps[j-1];
				else
					i = i+1;
			}
		}
	}

 //construct a lps(longest prefix of the string which is also the suffix of it) int array
    /* a b c d a b c f g
       0 0 0 0 1 2 3 0 0
         0 in b means for ab, lps is 0;
         3 in c means for abcdabc, lps is 3;
         0 in g means for abcdabcfg, lps is 0.
    */
	void computeLPSArray(String pat, int M, int lps[])
	{
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		while (i < M)
		{
			if (pat.charAt(i) == pat.charAt(len))
			{
				len++;
				lps[i] = len;
				i++;
			}
			else 
			{
				if (len != 0)
				{
					len = lps[len-1];
				}
				else 
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}

	// Driver program to test above function
	public static void main(String args[])
	{
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		new KMP_String_Matching().KMPSearch(pat,txt);
	}
}
// This code has been contributed by Amit Khandelwal.

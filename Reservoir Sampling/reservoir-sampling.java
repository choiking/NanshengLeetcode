// A function to randomly select k items from stream[0..n-1].
    public static void selectKItems(int stream[], int n, int k) {
        int i;   // index for elements in stream[]

        // reservoir[] is the output array. Initialize it with
        // first k elements from stream[]
        int reservoir[] = new int[k];

        for (i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random random = new Random();

        for (; i < n; i++) {
            int j = random.nextInt(i + 1);

            if (j < k)
                reservoir[j] = stream[i];
        }
    }
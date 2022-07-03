package Others;

import java.util.Arrays;

public class P1465_MaximumAreaPieceCake {
    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        final int mod = 1_000_000_007;
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        
        long maxH = Math.max(hCuts[0], h - hCuts[hCuts.length - 1]);
        long maxV = Math.max(vCuts[0], w - vCuts[vCuts.length - 1]);
        for (int i = 1; i < hCuts.length; i++) {
            maxH = Math.max(maxH, hCuts[i] - hCuts[i - 1]);
        }
        for (int i = 1; i < vCuts.length; i++) {
            maxV = Math.max(maxV, vCuts[i] - vCuts[i - 1]);
        }
        return (int)((maxH) * (maxV) % mod);
    }
}

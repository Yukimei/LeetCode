package BackTracking;
//关键在于穷尽每一个可能（用对手不能win来决定自己能win)
//穷尽所有可能为当前及前一个是++  然后我可以把它翻成 --
public class FlipGame {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                if (!canWin(s.substring(0, i - 1) + "--" + s.substring(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }
}

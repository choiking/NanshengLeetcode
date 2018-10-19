//using exception and Regular Expression



private final String VALIDIPV6CHARS = "0123456789abcdefABCDEF";
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP)) return "IPv6";
        return "Neither";
    }

    public boolean isIPv4(String IP) {
        if (IP.length() == 0 || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] arr = IP.split("\\.");
        if (arr.length != 4) return false;
        for (String token : arr) {
            if (token.startsWith("0") && token.length() > 1) return false;
            try {
                int value = Integer.parseInt(token);
                if (value < 0 || value > 255) return false;
                if (value == 0 && token.charAt(0) != '0') return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String IP) {
        if (IP.length() == 0 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] arr = IP.split(":");
        if (arr.length != 8) return false;
        for (String token : arr) {
            if (token.length() > 4 || token.length() == 0) return false;
            for (char c : token.toCharArray()) {
                if (!VALIDIPV6CHARS.contains(String.valueOf(c))) {
                    return false;
                }
            }
        }
        return true;
    }









    class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP)) return "IPv6";
        return "Neither";
    }

    public boolean isIPv4(String IP) {
        if (IP.length() == 0 || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] arr = IP.split("\\.");
        if (arr.length != 4) return false;
        for (String token : arr) {
            if (token.startsWith("0") && token.length() > 1) return false;
            try {
                int value = Integer.parseInt(token);
                if (value < 0 || value > 255) return false;
                if (value == 0 && token.charAt(0) != '0') return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String IP) {
        if (IP.length() == 0 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] arr = IP.split(":");
        if (arr.length != 8) return false;
        for (String token : arr) {
            if (token.length() > 4 || token.length() == 0 || token.startsWith("-")) return false;
            try {
                Long.parseLong(token, 16);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}



public String validIPAddress(String IP) {
      if (IP.matches("(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}")) {
          return "IPv4";
      }

      if (IP.matches("([0-9a-fA-F]|[0-9a-fA-F]{2}|[0-9a-fA-F]{3}|[0-9a-fA-F]{4})(\\:([0-9a-fA-F]|[0-9a-fA-F]{2}|[0-9a-fA-F]{3}|[0-9a-fA-F]{4})){7}")){
          return "IPv6";
      }

      return "Neither";
}

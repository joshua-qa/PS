private static final String ALLOW_STRING = "[^a-z0-9-_.]";
private static final String COMMA_DUPLICATE = "[.]+";
public String solution(String new_id) {
    return recommendProcess(new_id.toLowerCase());
}

private String recommendProcess(String id) {
    id = id.replaceAll(ALLOW_STRING, "");
    id = id.replaceAll(COMMA_DUPLICATE, ".");
    if (id.startsWith(".")) {
        id = id.substring(1);
    }
    if (id.endsWith(".")) {
        id = id.substring(0, id.length() - 1);
    }
    if (id.isEmpty()) {
        id = "a";
    }
    if (id.length() >= 16) {
        id = id.substring(0, 15);
        if (id.endsWith(".")) {
            id = id.substring(0, id.length() - 1);
        }
    }
    StringBuilder sb = new StringBuilder(id);
    if (sb.length() <= 2) {
        while (sb.length() < 3) {
            sb.append(id.charAt(id.length() - 1));
        }
    }

    return sb.toString();
}
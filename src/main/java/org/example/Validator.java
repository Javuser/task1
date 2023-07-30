package org.example;

public class Validator {
    public void validate(String s){
        String[] str = s.split(" ");
        switch (str[0]){
            case "GET" -> validateGet(s);
            case "CREATE" -> validateCreate(s);
            case "UPDATE" -> validateUpdate(s);
            case "DELETE" -> validateDelete(s);

            default -> throw new RuntimeException("Unknown command " + str[0]);
        }
    }

    private void validateGet(String s){
        String[] str = s.split(" ");
        if(!str[0].equals("GET")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(str.length > 2){
            throw new IllegalArgumentException("Illegal command");
        }
        if(str.length > 1 && isNotInt(str[1])){
            throw new IllegalArgumentException("Illegal command");
        }
    }

    private void validateCreate(String s) {
        String[] str = s.split(" ");
        if (!str[0].equals("CREATE")) {
            throw new IllegalArgumentException("Illegal command");
        }
        if (str.length < 2) {
            throw new IllegalArgumentException("Illegal command");
        }
    }

    // UPDATE 34 New String Value
    private void validateUpdate(String s){
        String[] str = s.split(" ");
        if(!str[0].equals("UPDATE")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(str.length < 3){
            throw new IllegalArgumentException("Illegal command");
        }
        if(isNotInt(str[1])){
            throw new IllegalArgumentException("Illegal command");
        }
    }

    //DELETE ID
    private void validateDelete(String s){
        String[] str = s.split(" ");
        if(!str[0].equals("DELETE")){
            throw new IllegalArgumentException("Illegal command");
        }
        if(str.length != 2){
            throw new IllegalArgumentException("Illegal command");
        }
        if(isNotInt(str[1])){
            throw new IllegalArgumentException("Illegal command");
        }
    }

    private boolean isNotInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}

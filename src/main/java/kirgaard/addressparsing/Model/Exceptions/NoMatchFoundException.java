package kirgaard.addressparsing.Model.Exceptions;

public class NoMatchFoundException extends Exception{
    public NoMatchFoundException(){
        super("No match found for the input");
    }
}

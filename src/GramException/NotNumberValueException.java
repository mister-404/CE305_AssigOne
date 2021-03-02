package GramException;

import Values.Value;

import java.util.List;

public class NotNumberValueException extends GramException{
    public NotNumberValueException(String msg) {
        super(msg);
    }

    public static String nonNumValsToString(List<Value> nonNumVals){
        StringBuilder buildUp = new StringBuilder();
        for(Value v : nonNumVals){
            if(buildUp.isEmpty())
                buildUp = new StringBuilder(v.toString());
            buildUp.append(",").append(v.toString());
        }
        return buildUp.toString();
    }
}
package kirgaard.addressparsing.Model;
import kirgaard.addressparsing.Model.Exceptions.NoMatchFoundException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {
    public final String street, house, floor, side, additionalCity, postcode, city;

    private Address(
            String _street, String _house, String _floor, String _side, String _additionalCity,
            String _postcode, String _city) {
        street = _street;
        house = _house;
        floor = _floor;
        side = _side;
        additionalCity = _additionalCity;
        postcode = _postcode;
        city = _city;
    }

    public String toString() {
        return street + " " + house + ", " + floor + " " + side + " " + additionalCity + "\n"
                + postcode + " " + city;
    }

    private final static String REGEX = "" +
            "(?<street>^[0-9]*[^0-9,]+)?" +
            "(?<house>[0-9]{1,3}[a-z]?)?[^a-zæøå0-9]*" +
            "(?<floor>(?:(?:kl)|(?:st)|(?:[0-9]+))\\\\.)?" +
            "(?<door>(?:(?:th)|(?:tv)|(?:mf)|(?:[0-9]+|[a-z]|(?:[0-9]+-[a-z])|(?:[a-z]+-[0-9]))),)?[^a-zæøå0-9]*" +
            "(?<additionalCity>[^0-9,.]+,?)?[^a-zæøå0-9]*" +
            "(?<postcode>[0-9]{4})?[^a-zæøå0-9]*" +
            "(?<city>[^0-9,.]+$)?";
    private final static Pattern PATTERN = Pattern.compile(REGEX);

    public static Address parse(String input) throws NoMatchFoundException, IllegalArgumentException {
        if (input == null){
            throw new IllegalArgumentException();
        }
        if (input.equals("")){
            throw new NoMatchFoundException();
        }

        input = input.toLowerCase();
        Builder builder = new Builder();
        Matcher match = PATTERN.matcher(input);

        if (!match.matches()){
            throw new NoMatchFoundException();
        }
        if (match.groupCount() == 0){
            throw new NoMatchFoundException();
        }

        Field[] builderFields = Builder.class.getDeclaredFields();
        for (Field field : builderFields) {
            String groupName = field.getName();

            Method buildMethod = null;
            try{
                buildMethod = builder.getClass().getMethod(groupName, String.class);
            }catch(NoSuchMethodException e){
                System.out.println("Trying to access a method:" + groupName + " while no such method exists.");
                System.out.println("Make sure that the Builder class has a method for each field, with the exact same name");
            }
            assert buildMethod != null;

            String groupValue = null;
            try {
                groupValue = match.group(groupName);
            }catch (IllegalArgumentException e){
                continue;
            }

            if (groupValue == null){
                continue;
            }

            // These exceptions should never be caught. If any problems arise, it will be caught with the first try/catch.
            try {
                buildMethod.invoke(builder, groupValue);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        return builder.build();
    }

    public static class Builder {
        private String street, house, floor, side, additionalCity, postcode, city;

        public Builder street(String _street) {
            street = _street;
            return this;
        }

        public Builder house(String _house) {
            house = _house;
            return this;
        }

        public Builder floor(String _floor) {
            floor = _floor;
            return this;
        }

        public Builder side(String _side) {
            side = _side;
            return this;
        }

        public Builder additionalCity(String _additionalCity) {
            side = _additionalCity;
            return this;
        }

        public Builder postcode(String _postcode) {
            postcode = _postcode;
            return this;
        }

        public Builder city(String _city) {
            city = _city;
            return this;
        }

        public Address build() {
            return new Address(street, house, floor, side, additionalCity, postcode, city);
        }
    }
}


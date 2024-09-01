package ols2405.interviewprep;

import java.time.LocalDate;
import java.util.ArrayList;

public class Resume {
    Heading heading;
    String careerObjective;
    ArrayList<Qualification> academicQualification;
    ArrayList<Experience> professionalExperience;
    ArrayList<String> hobbies;
    PersonalDetails personalDetails;

    class Address {
        String street;
        String city;
        String state;
        String country;
        int pincode;
    }

    class Heading {
        String name;
        Address address;
        String contactNumber;
        String email;
    }

    class Qualification {
        String name;
        int year;
        String institute;
        String resultType;
        float result;
    }

    class Experience {
        String jobTitle;
        String company;
        LocalDate startDate;
        LocalDate endDate;
        ArrayList<String> responsibilities;
    }

    class PersonalDetails {
        String fathersName;
        LocalDate dob;
    }
}

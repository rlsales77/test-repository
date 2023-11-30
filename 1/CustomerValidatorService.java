package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    // Violates Rule 3 (Empty method)
    private boolean isPhoneNumberValid(String phoneNumber) {
        
    }

    private boolean isAdult(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears() > 18;
    }

    public boolean isValid(Customer customer) {
        // Violates Rule 2 (Exceeds line length limit)
        return isEmailValid(customer.getEmail()) && isPhoneNumberValid(customer.getPhoneNumber()) && isAdult(customer.getBirthDate());
    }

}
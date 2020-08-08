package abhishek.foundation.bank.bankcasestudy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFound extends RuntimeException{
	public CustomerNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}

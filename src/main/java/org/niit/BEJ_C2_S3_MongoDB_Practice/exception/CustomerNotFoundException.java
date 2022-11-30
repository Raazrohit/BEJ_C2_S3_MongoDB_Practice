package org.niit.BEJ_C2_S3_MongoDB_Practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FOUND,reason = "customer id is not found")
public class CustomerNotFoundException extends Exception{
}

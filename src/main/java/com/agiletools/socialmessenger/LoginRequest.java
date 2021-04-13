package com.agiletools.socialmessenger;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

import static com.agiletools.socialmessenger.Constants.INVALID_MESSAGE;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LoginRequest {

    @Email(message = INVALID_MESSAGE)
    private String email;

    private String password;

    private String name;

}

package objects;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/* We can use this method for getting and store random data for registration/login functionality check */
public class CredentialObject {
    /* if it needed we can added field*/
    String username;
    String password;


    public  CredentialObject getFakeCredentialTestData(){
        Faker faker = new Faker();
        String username = faker.number().digits(15);
        String password = faker.number().digits(20);


        return new CredentialObject(username,password);
    }
}

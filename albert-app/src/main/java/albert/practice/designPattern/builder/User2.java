package albert.practice.designPattern.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * The @Builder annotation produces complex builder APIs for your classes.
 * @Builder lets you automatically produce the code required to have your class be instantiable with code such as:
 * Person.builder().name("Adam Savage").city("San Francisco").job("Mythbusters").job("Unchained Reaction").build();
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User2 {
    
    private String firstName;
    private String lastName;
    private String email;

}
